package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Return;
import edu.iu.c322.orderservice.repository.OrderRepository;
import edu.iu.c322.orderservice.repository.ReturnRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;
    private ReturnRepository returnRepository;

    @GetMapping
    public List<Order> findAll() {
        return repository.findAll();
    }

    public OrderController(OrderRepository repository, ReturnRepository returnRepository) {
        this.repository = repository;
        this.returnRepository = returnRepository;
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

    @PutMapping("/return")
    public void update(@Valid @RequestBody Return newReturn) {
        Order order = repository.getOrderById(newReturn.getOrderId());
        if(order == null)
            throw new IllegalStateException("order id is not valid");

        Item item = order.getItems().stream().filter(x -> x.getId() == newReturn.getItemId()).findAny().orElse(null);
        if(item == null)
            throw new IllegalStateException("item id is not valid");

        returnRepository.Update(newReturn);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable int id) {
        repository.delete(id);
    }
}
