package com.vti;

import com.vti.entity.Product;
import com.vti.form.ProductCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsaleApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebsaleApplication.class, args);

	}
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(ProductCreateForm.class, Product.class)
				.addMappings(mapper -> mapper.skip(Product::setId));
		return modelMapper;

	}

}
