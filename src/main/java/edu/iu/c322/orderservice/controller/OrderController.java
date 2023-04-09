package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Return;
import edu.iu.c322.orderservice.repository.OrderRepository;
import edu.iu.c322.orderservice.repository.ReturnRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order order){
        Order addedOrder = repository.save(order);
        return addedOrder.getCustomerId();
    }

    @GetMapping({"/{id}"})
    public Optional<Order> getOrderById(@PathVariable @Valid int id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/return")
    public void update(@Valid @RequestBody Return newReturn) {
        returnRepository.save(newReturn);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Order oldOrder = repository.getReferenceById(id);
        repository.delete(oldOrder);
    }
}
