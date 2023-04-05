package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Return;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryReturnRepository {
    List<Return> returns = new ArrayList<>();

    public void Update(Return newReturn) {
        returns.add(newReturn);
    }
}
