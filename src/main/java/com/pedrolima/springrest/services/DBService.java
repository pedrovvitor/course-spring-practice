package com.pedrolima.springrest.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrolima.springrest.entities.Address;
import com.pedrolima.springrest.entities.Category;
import com.pedrolima.springrest.entities.City;
import com.pedrolima.springrest.entities.CreditCardPayment;
import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.entities.ItemOrder;
import com.pedrolima.springrest.entities.Order;
import com.pedrolima.springrest.entities.Payment;
import com.pedrolima.springrest.entities.PaymentSlip;
import com.pedrolima.springrest.entities.Product;
import com.pedrolima.springrest.entities.State;
import com.pedrolima.springrest.entities.enums.CustomerType;
import com.pedrolima.springrest.entities.enums.PaymentState;
import com.pedrolima.springrest.repositories.AddressRepository;
import com.pedrolima.springrest.repositories.CategoryRepository;
import com.pedrolima.springrest.repositories.CityRepository;
import com.pedrolima.springrest.repositories.CustomerRepository;
import com.pedrolima.springrest.repositories.ItemOrderRepository;
import com.pedrolima.springrest.repositories.OrderRepository;
import com.pedrolima.springrest.repositories.PaymentRepository;
import com.pedrolima.springrest.repositories.ProductRepository;
import com.pedrolima.springrest.repositories.StateRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	public void instantiateDatabase(){
			Category cat1 = new Category(null, "Informática");
			Category cat2 = new Category(null, "Escritório");
			Category cat3 = new Category(null, "Cama mesa e Banho");
			Category cat4 = new Category(null, "Eletrônicos");
			Category cat5 = new Category(null, "Jardinagem");
			Category cat6 = new Category(null, "Decoração");
			Category cat7 = new Category(null, "Perfumaria");

			Product p1 = new Product(null, "Computador", 2000.00);
			Product p2 = new Product(null, "Impressora", 800.00);
			Product p3 = new Product(null, "Mouse", 80.00);
			Product p4 = new Product(null, "Mesa de escritório", 300.00);
			Product p5 = new Product(null, "Toalha", 50.00);
			Product p6 = new Product(null, "Colcha", 200.00);
			Product p7 = new Product(null, "TV true color", 1200.00);
			Product p8 = new Product(null, "Roçadeira", 800.00);
			Product p9 = new Product(null, "Abajour", 100.00);
			Product p10 = new Product(null, "Pendente", 180.00);
			Product p11 = new Product(null, "Shampoo", 90.00);

			cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
			cat2.getProducts().addAll(Arrays.asList(p2,p4));
			cat3.getProducts().addAll(Arrays.asList(p5,p6));
			cat4.getProducts().addAll(Arrays.asList(p1,p2, p3, p7));
			cat5.getProducts().addAll(Arrays.asList(p8));
			cat6.getProducts().addAll(Arrays.asList(p9, p10));
			cat7.getProducts().addAll(Arrays.asList(p11));

			p1.getCategories().addAll(Arrays.asList(cat1, cat4));
			p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
			p3.getCategories().addAll(Arrays.asList(cat1, cat4));
			p4.getCategories().addAll(Arrays.asList(cat2));
			p5.getCategories().addAll(Arrays.asList(cat3));
			p6.getCategories().addAll(Arrays.asList(cat3));
			p7.getCategories().addAll(Arrays.asList(cat4));
			p8.getCategories().addAll(Arrays.asList(cat5));
			p9.getCategories().addAll(Arrays.asList(cat6));
			p10.getCategories().addAll(Arrays.asList(cat6));
			p11.getCategories().addAll(Arrays.asList(cat7));

			categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
			productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

			State st1 = new State(null, "MG");
			State st2 = new State(null, "SP");

			City c1 = new City(null, "Uberlândia", st1);
			City c2 = new City(null, "São Paulo", st2);
			City c3 = new City(null, "Campinas", st2);

			st1.getCities().add(c1);
			st2.getCities().addAll(Arrays.asList(c2, c3));

			stateRepository.saveAll(Arrays.asList(st1, st2));
			cityRepository.saveAll(Arrays.asList(c1, c2, c3));

			Customer customer1 = new Customer(null, "Maria Silva", "pedrojppb2@gmail.com", "36378912377",
					CustomerType.PESSOAFISICA);

			customer1.getPhones().addAll(Arrays.asList("8398547125", "83958521475"));

			Address ad1 = new Address(null, "Rua Flores", "300", "apto 203", "Jardim", "38220834", customer1, c1);
			Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38077012", customer1, c2);

			customer1.getAddresses().addAll(Arrays.asList(ad1, ad2));

			customerRepository.save(customer1);
			addressRepository.saveAll(Arrays.asList(ad1, ad2));
			
			Order o1 = new Order(null, LocalDateTime.of(2017, 9, 30, 10, 32), customer1, ad1);
			Order o2 = new Order(null, LocalDateTime.of(2017, 10, 10, 19, 35), customer1, ad2);
			
			Payment pay1 = new CreditCardPayment(null, PaymentState.PAYED, o1, 6);
			o1.setPayment(pay1);
			Payment pay2 = new PaymentSlip(null, PaymentState.PENDING, o2, LocalDate.of(2017, 10, 20), null);
			o2.setPayment(pay2);
			
			customer1.getOrders().addAll(Arrays.asList(o1, o2));
			
			orderRepository.saveAll(Arrays.asList(o1, o2));
			paymentRepository.saveAll(Arrays.asList(pay1, pay2));
			
			ItemOrder io1 = new ItemOrder(p1, o1, 0.00, 1, 2000.00);
			ItemOrder io2 = new ItemOrder(p3, o1, 0.00, 2, 80.00);
			ItemOrder io3 = new ItemOrder(p2, o2, 100.00, 1, 800.00);
			
			o1.getItens().addAll(Arrays.asList(io1, io2));
			o2.getItens().add(io3);
			
			p1.getItens().add(io1);
			p2.getItens().add(io3);
			p3.getItens().add(io2);
			
			itemOrderRepository.saveAll(Arrays.asList(io1, io2, io3));
	}
}
