package com.pedrolima.springrest.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.pedrolima.springrest.entities.enums.Profile;
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
	@Autowired
	private BCryptPasswordEncoder pe;
	
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
			
			Product p12 = new Product(null, "Produto 12", 10.00);
			Product p13 = new Product(null, "Produto 13", 10.00);
			Product p14 = new Product(null, "Produto 14", 10.00);
			Product p15 = new Product(null, "Produto 15", 10.00);
			Product p16 = new Product(null, "Produto 16", 10.00);
			Product p17 = new Product(null, "Produto 17", 10.00);
			Product p18 = new Product(null, "Produto 18", 10.00);
			Product p19 = new Product(null, "Produto 19", 10.00);
			Product p20 = new Product(null, "Produto 20", 10.00);
			Product p21 = new Product(null, "Produto 21", 10.00);
			Product p22 = new Product(null, "Produto 22", 10.00);
			Product p23 = new Product(null, "Produto 23", 10.00);
			Product p24 = new Product(null, "Produto 24", 10.00);
			Product p25 = new Product(null, "Produto 25", 10.00);
			Product p26 = new Product(null, "Produto 26", 10.00);
			Product p27 = new Product(null, "Produto 27", 10.00);
			Product p28 = new Product(null, "Produto 28", 10.00);
			Product p29 = new Product(null, "Produto 29", 10.00);
			Product p30 = new Product(null, "Produto 30", 10.00);
			Product p31 = new Product(null, "Produto 31", 10.00);
			Product p32 = new Product(null, "Produto 32", 10.00);
			Product p33 = new Product(null, "Produto 33", 10.00);
			Product p34 = new Product(null, "Produto 34", 10.00);
			Product p35 = new Product(null, "Produto 35", 10.00);
			Product p36 = new Product(null, "Produto 36", 10.00);
			Product p37 = new Product(null, "Produto 37", 10.00);
			Product p38 = new Product(null, "Produto 38", 10.00);
			Product p39 = new Product(null, "Produto 39", 10.00);
			Product p40 = new Product(null, "Produto 40", 10.00);
			Product p41 = new Product(null, "Produto 41", 10.00);
			Product p42 = new Product(null, "Produto 42", 10.00);
			Product p43 = new Product(null, "Produto 43", 10.00);
			Product p44 = new Product(null, "Produto 44", 10.00);
			Product p45 = new Product(null, "Produto 45", 10.00);
			Product p46 = new Product(null, "Produto 46", 10.00);
			Product p47 = new Product(null, "Produto 47", 10.00);
			Product p48 = new Product(null, "Produto 48", 10.00);
			Product p49 = new Product(null, "Produto 49", 10.00);
			Product p50 = new Product(null, "Produto 50", 10.00);
			
			cat1.getProducts().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
					p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
					p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
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
			p12.getCategories().add(cat1);
			p13.getCategories().add(cat1);
			p14.getCategories().add(cat1);
			p15.getCategories().add(cat1);
			p16.getCategories().add(cat1);
			p17.getCategories().add(cat1);
			p18.getCategories().add(cat1);
			p19.getCategories().add(cat1);
			p20.getCategories().add(cat1);
			p21.getCategories().add(cat1);
			p22.getCategories().add(cat1);
			p23.getCategories().add(cat1);
			p24.getCategories().add(cat1);
			p25.getCategories().add(cat1);
			p26.getCategories().add(cat1);
			p27.getCategories().add(cat1);
			p28.getCategories().add(cat1);
			p29.getCategories().add(cat1);
			p30.getCategories().add(cat1);
			p31.getCategories().add(cat1);
			p32.getCategories().add(cat1);
			p33.getCategories().add(cat1);
			p34.getCategories().add(cat1);
			p35.getCategories().add(cat1);
			p36.getCategories().add(cat1);
			p37.getCategories().add(cat1);
			p38.getCategories().add(cat1);
			p39.getCategories().add(cat1);
			p40.getCategories().add(cat1);
			p41.getCategories().add(cat1);
			p42.getCategories().add(cat1);
			p43.getCategories().add(cat1);
			p44.getCategories().add(cat1);
			p45.getCategories().add(cat1);
			p46.getCategories().add(cat1);
			p47.getCategories().add(cat1);
			p48.getCategories().add(cat1);
			p49.getCategories().add(cat1);
			p50.getCategories().add(cat1);
			
			categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
			productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
			productRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
					p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
					p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

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
					CustomerType.PESSOAFISICA, pe.encode("123"));
			customer1.getPhones().addAll(Arrays.asList("8398547125", "83958521475"));
			
			Customer customer2 = new Customer(null, "Ana Costa", "pedrojppb@gmail.com", "54938619091",
					CustomerType.PESSOAFISICA, pe.encode("123"));
			customer2.getPhones().addAll(Arrays.asList("83985214789", "83963254125"));
			customer2.addProfile(Profile.ADMIN);
			
			Address ad1 = new Address(null, "Rua Flores", "300", "apto 203", "Jardim", "38220834", customer1, c1);
			Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38077012", customer1, c2);
			Address ad3 = new Address(null, "Rua Santo Antonio", "200", "Casa", "Cidade Jardim", "58005745", customer2, c3);

			customer1.getAddresses().addAll(Arrays.asList(ad1, ad2));
			customer2.getAddresses().addAll(Arrays.asList(ad3));

			customerRepository.saveAll(Arrays.asList(customer1, customer2));
			addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3));
			
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
