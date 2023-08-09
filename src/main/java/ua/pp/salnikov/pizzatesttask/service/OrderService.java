package ua.pp.salnikov.pizzatesttask.service;

import ua.pp.salnikov.pizzatesttask.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    List<Order> getAllOrdersWithActiveStatus();
    void createOrder();
    void updateOrderByPerformer(Integer id);
    void updateOrderByUser(Integer id);

}
