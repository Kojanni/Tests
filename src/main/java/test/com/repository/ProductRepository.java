package test.com.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.com.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    @Query("SELECT SUM(amount) " +
            "FROM Product " +
            "WHERE name = :name")
    Integer sumAmountByName(String name);
}
