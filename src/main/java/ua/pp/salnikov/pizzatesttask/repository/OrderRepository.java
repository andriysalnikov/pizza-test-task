package ua.pp.salnikov.pizzatesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.pp.salnikov.pizzatesttask.model.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders WHERE status = 'ACTIVE'", nativeQuery = true)
    List<Order> findAllOrdersWithActiveStatus();

    @Query(value = "SELECT o FROM Order o LEFT JOIN FETCH o.meals m WHERE o.id = :id")
    Optional<Order> findOrderByIdWithMeals(Integer id);

}