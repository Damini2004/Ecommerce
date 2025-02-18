package com.xncoder.Ecommerce.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	@Autowired
	private OrderService os;

	@PostMapping
    public ResponseEntity<?> addProductToCart(@RequestParam Long customerId, 
    		@RequestParam String name,
    		@RequestParam String mobile,
    		@RequestParam String address,
    		@RequestParam String paymentMode) {
        return ResponseEntity.ok().body(os.addOrders(customerId, name, mobile, address, paymentMode).getOrder_id());
    }

	@GetMapping
    public List<CustomerOrder> getAllOrders(@PathVariable Long customerId) {
        return os.getOrderByCustomerId(customerId);
    }
}
