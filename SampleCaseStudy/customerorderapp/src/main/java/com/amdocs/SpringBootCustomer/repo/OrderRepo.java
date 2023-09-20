package com.amdocs.SpringBootCustomer.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.amdocs.SpringBootCustomer.model.Customers;
import com.amdocs.SpringBootCustomer.model.Orders;

import java.util.List;

@Repository
		public interface OrderRepo extends JpaRepository<Orders, Long> {
	    List<Orders> findByCustomer(Customers customer);
	    Orders findByCustomerAndOrderId(Customers customer, Long orderId);

}
