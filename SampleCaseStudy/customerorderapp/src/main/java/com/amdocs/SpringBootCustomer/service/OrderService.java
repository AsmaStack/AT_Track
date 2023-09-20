package com.amdocs.SpringBootCustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.SpringBootCustomer.exception.CustomerNotExistException;
import com.amdocs.SpringBootCustomer.model.Customers;
import com.amdocs.SpringBootCustomer.model.Orders;
import com.amdocs.SpringBootCustomer.repo.CustomerRepo;
import com.amdocs.SpringBootCustomer.repo.OrderRepo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    
    private OrderRepo orderRepository;

    private CustomerRepo customerRepository;
    
    
@Autowired
    public OrderService(OrderRepo orderRepository, CustomerRepo customerRepository) {
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}

	public Orders createOrder(Long customerId, Orders order) throws CustomerNotExistException {
        Customers customer = customerRepository.findById(customerId).orElse(null);
        if(customer!=null)
        {
        order.setCustomer(customer);
        return orderRepository.save(order);
        }
        else
        {
        	throw new CustomerNotExistException("Customer is not existed");
        }
    }

    public Orders updateOrder(Long customerId, Long orderId, Orders updatedOrder) {
        Customers customer = customerRepository.findById(customerId).orElse(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        Orders existingOrder = orderRepository.findByCustomerAndOrderId(customer, orderId);
        if(existingOrder != null) {
        existingOrder.setTime_of_order(now);
        System.out.println(updatedOrder.getOrder_cost());
        System.out.println(existingOrder.getOrder_status());
        existingOrder.setOrder_cost(updatedOrder.getOrder_cost());
        //existingOrder.setOrder_status(existingOrder.getOrder_status());

        return orderRepository.save(existingOrder);
        }
        return null;
    }

    public List<Orders> getOrdersByCustomerId(Long customerId) {
        Customers customer = customerRepository.findById(customerId).orElse(null);
        return orderRepository.findByCustomer(customer);
    }

    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public String getOrderStatus(Long orderId) {
        Orders order = orderRepository.findById(orderId).orElse(null);
        return order.getOrder_status();
    }
}
