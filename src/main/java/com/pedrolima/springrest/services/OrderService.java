package com.pedrolima.springrest.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.entities.ItemOrder;
import com.pedrolima.springrest.entities.Order;
import com.pedrolima.springrest.entities.PaymentSlip;
import com.pedrolima.springrest.entities.enums.PaymentState;
import com.pedrolima.springrest.repositories.ItemOrderRepository;
import com.pedrolima.springrest.repositories.OrderRepository;
import com.pedrolima.springrest.repositories.PaymentRepository;
import com.pedrolima.springrest.security.UserSS;
import com.pedrolima.springrest.services.exceptions.AuthorizationException;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ItemOrderRepository itemOrderRepository;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;

	public Order findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found! Id: " + id));
	}

	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setInstant(LocalDateTime.now());
		obj.setCustomer(customerService.findById(obj.getCustomer().getId()));
		obj.getPayment().setState(PaymentState.PENDING);
		obj.getPayment().setOrder(obj);
		if (obj.getPayment() instanceof PaymentSlip) {
			PaymentSlip payment = (PaymentSlip) obj.getPayment();
			PaymentSlipService.fillPaymentSlip(payment, obj.getInstant());
		}
		obj = repository.save(obj);
		paymentRepository.save(obj.getPayment());

		for (ItemOrder item : obj.getItens()) {
			item.setDiscount(0.0);
			item.setProduct(productService.findById(item.getProduct().getId()));
			item.setPrice(item.getProduct().getPrice());
			item.setOrder(obj);
		}
		itemOrderRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
	
	public Page<Order> findPage( Integer page, Integer size, String orderBy, String direction){
		UserSS user = UserService.authenticated();
		if(user==null) {
			throw new AuthorizationException("Access denied.");
		}
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		Customer customer = customerService.findById(user.getId());
		return repository.findByCustomer(customer, pageRequest);
		
	}
}
