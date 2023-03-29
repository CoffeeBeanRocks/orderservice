package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    @GetMapping
    public List<Order> findAll() {
        return repository.findAll();
    }

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order){
        return repository.create(order);
    }

    @GetMapping({"/{id}"})
    public Order getOrderById(@Valid @PathVariable int id) {
        Order order = repository.getOrderById(id);
        if(order == null)
            throw new IllegalStateException("order id is not valid");
        else
            return order;
    }

    //TODO: Put Mapping, Update Order : (Issue: What is the meaning of "itemId"?)

    @DeleteMapping("/{id}")
    public void update(@PathVariable int id) {
        repository.delete(id);
    }
}
