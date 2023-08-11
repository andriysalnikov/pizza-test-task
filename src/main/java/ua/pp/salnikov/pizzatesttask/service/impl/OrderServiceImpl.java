package ua.pp.salnikov.pizzatesttask.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.OrderStatus;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;
import ua.pp.salnikov.pizzatesttask.repository.MealRepository;
import ua.pp.salnikov.pizzatesttask.repository.OrderRepository;
import ua.pp.salnikov.pizzatesttask.service.OrderService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private MealRepository mealRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersWithActiveStatus() {
        return orderRepository.findAllOrdersWithActiveStatus();
    }

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.setStartDate(LocalDate.now());
        order.setStartTime(LocalTime.now());
        order.setStatus(OrderStatus.NONE);
        return orderRepository.save(order);
    }

    @Override
    public void doOrder(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        order.setEndDate(LocalDate.now());
        order.setEndTime(LocalTime.now());
        order.setStatus(OrderStatus.DONE);
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        order.setEndDate(LocalDate.now());
        order.setEndTime(LocalTime.now());
        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    @Override
    public void saveOrder(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        order.setStatus(OrderStatus.ACTIVE);
        orderRepository.save(order);
    }

    @Override
    public void addMealToOrder(Integer orderId, Integer mealId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        Meal meal = mealRepository.findById(mealId).orElseThrow(NoSuchElementException::new);
        order.getMeals().add(meal);
        orderRepository.save(order);
    }

    @Override
    public OrderWithMealsDto getOrderByIdWithMeals(Integer id) {
        Order order = orderRepository.findOrderByIdWithMeals(id).orElseThrow(NoSuchElementException::new);
        Map<Meal, Long> meals = order.getMeals().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return OrderWithMealsDto.builder()
                .id(order.getId())
                .startDate(order.getStartDate())
                .startTime(order.getStartTime())
                .endDate(order.getEndDate())
                .endTime(order.getEndTime())
                .status(order.getStatus())
                .meals(meals)
                .build();
    }

}