package com.amdocs.SpringBootCustomer;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.amdocs.SpringBootCustomer.model.Orders;
import com.amdocs.SpringBootCustomer.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;
    
    @Test
    public void testCreateOrder() throws Exception {
        Orders mockOrder = new Orders();

        Mockito.when(orderService.createOrder(Mockito.any(Long.class), Mockito.any(Orders.class))).thenReturn(mockOrder);

        mockMvc.perform(post("/api/orders/{customerId}", 123L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(mockOrder)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.order_id", is(mockOrder.getOrderId())))
            .andExpect(jsonPath("$.time_of_order").value("2023-08-22T12:34:56"))
            .andExpect(jsonPath("$.order_cost").value(mockOrder.getOrder_cost()))
            .andExpect(jsonPath("$.order_status").value(mockOrder.getOrder_status()))
            .andExpect(jsonPath("$.customer.customer_id").value(mockOrder.getCustomer().getCustomer_id()));
    }

    @Test
    public void testGetOrdersByCustomerId() throws Exception {
        Long customerId = 123L;
        List<Orders> mockOrders = new ArrayList<>();

        Mockito.when(orderService.getOrdersByCustomerId(customerId)).thenReturn(mockOrders);

        mockMvc.perform(get("/api/orders/customer/{customerId}", customerId))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher)jsonPath("$", hasSize(mockOrders.size())));
    }

    private Object hasSize(int size) {
		return null;
	}

	// Helper method to convert objects to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
