package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Return;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReturnRepository {
    List<Return> returns = new ArrayList<>();

    public void Update(Return newReturn) {
        returns.add(newReturn);
    }
}
