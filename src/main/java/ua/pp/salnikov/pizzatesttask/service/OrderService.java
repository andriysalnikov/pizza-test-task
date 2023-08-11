package ua.pp.salnikov.pizzatesttask.service;

import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    List<Order> getAllOrdersWithActiveStatus();
    Order createOrder();
    void saveOrder(Integer id);
    void doOrder(Integer id);
    void cancelOrder(Integer id);
    void addMealToOrder(Integer orderId, Integer mealId);
    OrderWithMealsDto getOrderByIdWithMeals(Integer id);

}
