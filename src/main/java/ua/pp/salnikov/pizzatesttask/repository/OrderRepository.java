package ua.pp.salnikov.pizzatesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.pp.salnikov.pizzatesttask.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders WHERE status = 'ACTIVE'", nativeQuery = true)
    List<Order> findAllOrdersWithActiveStatus();

}
