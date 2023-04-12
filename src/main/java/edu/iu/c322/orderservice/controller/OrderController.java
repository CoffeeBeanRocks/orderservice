package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.Item;
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

    private ReturnRepository returnRepository;
    private OrderRepository repository;

    public OrderController(OrderRepository repository, ReturnRepository returnRepository) {
        this.repository = repository;
        this.returnRepository = returnRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){

        for(int i = 0; i < order.getItems().size(); i++){
            Item item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/{customerId}")
    public List<Order> findByCustomer(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> findByOrderId(@PathVariable int orderId){
        return repository.findById(orderId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/return")
    public void update(@Valid @RequestBody Return newReturn) {
        returnRepository.save(newReturn);
    }
}
