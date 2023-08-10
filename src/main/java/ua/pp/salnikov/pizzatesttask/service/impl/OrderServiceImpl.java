package ua.pp.salnikov.pizzatesttask.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.OrderStatus;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;
import ua.pp.salnikov.pizzatesttask.repository.OrderRepository;
import ua.pp.salnikov.pizzatesttask.service.OrderService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllOrdersWithActiveStatus() {
        return orderRepository.findAllOrdersWithActiveStatus();
    }

    @Override
    public void createOrder() {
        Order order = new Order();
        order.setStartDate(LocalDate.now());
        order.setStartTime(LocalTime.now());
        order.setStatus(OrderStatus.ACTIVE);
        orderRepository.save(order);
    }

    @Override
    public void updateOrderByPerformer(Integer id) {
        Order order = orderRepository.findById(id).get();
        order.setEndDate(LocalDate.now());
        order.setEndTime(LocalTime.now());
        order.setStatus(OrderStatus.DONE);
        orderRepository.save(order);
    }

    @Override
    public void updateOrderByUser(Integer id) {
        Order order = orderRepository.findById(id).get();
        order.setEndDate(LocalDate.now());
        order.setEndTime(LocalTime.now());
        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    @Override
    public OrderWithMealsDto getOrderByIdWithMeals(Integer id) {
        Order order = orderRepository.findOrderByIdWithMeals(id).get();
        return OrderWithMealsDto.builder()
                .id(order.getId())
                .startDate(order.getStartDate())
                .startTime(order.getStartTime())
                .endDate(order.getEndDate())
                .endTime(order.getEndTime())
                .status(order.getStatus())
                .meals(order.getMeals().stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .build();
    }
}
