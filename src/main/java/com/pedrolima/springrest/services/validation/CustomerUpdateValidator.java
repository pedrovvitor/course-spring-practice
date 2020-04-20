package com.pedrolima.springrest.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.pedrolima.springrest.dto.CustomerDTO;
import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.repositories.CustomerRepository;
import com.pedrolima.springrest.resources.exceptions.FieldMessage;

public class CustomerUpdateValidator implements ConstraintValidator<CustomerUpdate, CustomerDTO> {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(CustomerUpdate ann) {
	}

	@Override
	public boolean isValid(CustomerDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		List<FieldMessage> list = new ArrayList<>();

		//validator customizado de email unico no banco
		Customer aux = customerRepository.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId)) {
			list.add((new FieldMessage("email", "Email already registered!")));
		}
		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}