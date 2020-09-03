package com.bank.group5.zuulservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ZuulGatewayController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private EurekaClient client;
	
	@GetMapping("/")
	public String InvokeService() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@PostMapping("/customer")
	public String InvokeService2() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp/createCustomer";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@GetMapping("/customerByName")
	public String InvokeService3() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp/getCustomer/{lastName}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@GetMapping("/customerById")
	public String InvokeService4() {
		
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp/getCustomer/"+{id};
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@PutMapping("/updateCust")
	public String InvokeService5() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp/updateCustomer/{id}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@DeleteMapping("/deleteCust")
	public String InvokeService6() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Customer_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/customerapp/deleteCustomer/{id}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@GetMapping("/prodDefault")
	public String InvokeService7() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@PostMapping("/product")
	public String InvokeService8() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp/createProduct";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@GetMapping("/productByName")
	public String InvokeService9() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp/getProduct/{name}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@GetMapping("/productById")
	public String InvokeService10() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp/getProduct/{id}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@PutMapping("/updateProduct")
	public String InvokeService11() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp/updateProduct/{id}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
	
	@DeleteMapping("/deleteProd")
	public String InvokeService12() {
		InstanceInfo instanceInfo = client.getNextServerFromEureka("Product_implementation", false);
		String baseUrl = instanceInfo.getHomePageUrl() + "api/productapp/deleteProduct/{id}";
		System.out.println("BaseUrl:"+baseUrl);
		return template.getForObject(baseUrl, String.class);
	}
}
