package com.amdocs.SpringBootCustomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.SpringBootCustomer.exception.CustomerNotExistException;
import com.amdocs.SpringBootCustomer.model.Customers;
import com.amdocs.SpringBootCustomer.model.Orders;
import com.amdocs.SpringBootCustomer.service.CustomerService;
import com.amdocs.SpringBootCustomer.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private OrderService orderService;  
    private CustomerService custService;
    
    @Autowired
    public OrderController(OrderService orderService, CustomerService custService) {
		this.orderService = orderService;
		this.custService=custService;
	}
    
    @GetMapping("/customer/{customerId}")
    public List<Orders> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }
    
    @GetMapping("/allcustomers")
	public List<Customers> getAllCustomers(){
		return custService.getAllCustomers();
	}
    
    @PostMapping
    public Customers createCustomer(@RequestBody Customers customer)
    {
	   return custService.createCustomer(customer);
    }

	@PostMapping("/{customerId}")
    public Orders createOrder(@PathVariable Long customerId, @RequestBody Orders order) throws CustomerNotExistException {
		
        return orderService.createOrder(customerId, order);
    }

    @PutMapping("/{customerId}/{orderId}")
    public Orders updateOrder(
            @PathVariable Long customerId,
            @PathVariable Long orderId,
            @RequestBody Orders updatedOrder
    ) {
        return orderService.updateOrder(customerId, orderId, updatedOrder);
    }

    @GetMapping("/{orderId}")
    public Orders getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/{orderId}/status")
    public String getOrderStatus(@PathVariable Long orderId) {
        return orderService.getOrderStatus(orderId);
    }
}
