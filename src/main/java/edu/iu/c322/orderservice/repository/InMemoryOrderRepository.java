package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository {
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

    public void delete(int id) {
        Order x = getOrderById(id);
        if(x != null) {
            orders.remove(x);
        } else {
            throw new IllegalStateException("order id is not valid!");
        }
    }

    public Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }
}
