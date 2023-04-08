package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Return;
import edu.iu.c322.orderservice.repository.InMemoryOrderRepository;
import edu.iu.c322.orderservice.repository.InMemoryReturnRepository;
import edu.iu.c322.orderservice.repository.OrderRepository;
import edu.iu.c322.orderservice.repository.ReturnRepository;
import jakarta.persistence.EntityManager;
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
        if(repository.existsById(order.getCustomerId()))
            throw new IllegalStateException("Order already exists!");

        Order newOrder = repository.save(order);
        return newOrder.getCustomerId();
    }

    @GetMapping({"/{id}"})
    public Order getOrderById(@Valid @PathVariable int id) {
        return repository.getReferenceById(id);
    }

    @PutMapping("/return")
    public void update(@Valid @RequestBody Return newReturn) {
        Return var = returnRepository.getReferenceById(newReturn.getOrderId());

<<<<<<< HEAD
        //TODO: Enable when itemId has been fixed
        /*
        Item item = order.getItems().stream().filter(x -> x.getId() == newReturn.getItemId()).findAny().orElse(null);
        if(item == null)
            throw new IllegalStateException("item id is not valid");
         */

        //TODO: How to do merge??
=======
        Item item = order.getItems().stream().filter(x -> x.getId() == newReturn.getItemId()).findAny().orElse(null);
        if(item == null)
            throw new IllegalStateException("item id is not valid");
>>>>>>> parent of 45b661a (Disabled itemId error check)

    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable int id) {
        repository.delete(repository.getReferenceById(id));
    }
}
