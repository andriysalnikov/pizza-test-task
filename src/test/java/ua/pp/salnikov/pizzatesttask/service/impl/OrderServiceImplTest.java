package ua.pp.salnikov.pizzatesttask.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;
import ua.pp.salnikov.pizzatesttask.repository.OrderRepository;
import ua.pp.salnikov.pizzatesttask.util.TestModel;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void whenCreateOrder_shouldReturnOrder() {
        Order expectedOrder = TestModel.generateExpectedOrder();
        Order returnedOrder = TestModel.generateReturnedOrder();
        when(orderRepository.save(any(Order.class))).thenReturn(returnedOrder);
        assertEquals(expectedOrder, orderService.createOrder());
    }

    @Test
    void whenGetAllOrders_shouldReturnListOfAllOrders() {
        List<Order> orders = TestModel.generateListOfOrders();
        when(orderRepository.findAll()).thenReturn(orders);
        assertIterableEquals(orders, orderService.getAllOrders());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void whenGetOrderWithMealsDto_shouldReturnOrderWithMealsDtoHavingMap() {
        OrderWithMealsDto orderWithMealsDto = TestModel.generateOrderWithMealsDto();
        Order order = TestModel.generateOrderWithMeals();
        when(orderRepository.findOrderByIdWithMeals(anyInt())).thenReturn(Optional.of(order));
        assertEquals(orderWithMealsDto, orderService.getOrderByIdWithMeals(2));
    }

}