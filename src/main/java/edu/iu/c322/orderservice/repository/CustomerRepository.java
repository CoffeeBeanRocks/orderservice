package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Address;
import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    List<Order> orders = new ArrayList<>();

    public List<Order> findAll() {
        return orders;
    }

    public int create(Order order) {
        int id = orders.size() + 1;
        order.setCustomerId(id);
        orders.add(order);
        return id;
    }

    public void update(Order order, int id) {
        Order x = getOrderById(id);
        if(x != null) {
            x.setCustomerId(order.getCustomerId());
            x.setTotal(order.getTotal());
            x.setShippingAddress(order.getShippingAddress());
        }
        else {
            throw new IllegalStateException("order id is not valid");
        }
    }

    private Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }
}
