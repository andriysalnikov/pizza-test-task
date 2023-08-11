package ua.pp.salnikov.pizzatesttask.util;

import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.OrderStatus;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestModel {

    public static List<Meal> generateListOfMeals() {
        Meal meal1 = Meal.builder()
                .id(1)
                .name("Casiotore")
                .description("sauce, cheese, oregano, hunting sausages, pickled cucumbers")
                .build();
        Meal meal2 = Meal.builder()
                .id(2)
                .name("Bravissimo")
                .description("sauce, cheese, oregano, sausage, mushrooms")
                .build();
        Meal meal3 = Meal.builder()
                .id(3)
                .name("Perfetto")
                .description("sauce, cheese, oregano, hunting sausages, ham, chicken, tomatoes")
                .build();
        return Arrays.asList(meal1, meal2, meal3);
    }

    public static List<Order> generateListOfOrders() {
        Order order1 = Order.builder()
                .id(1)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .status(OrderStatus.NONE)
                .build();
        Order order2 = Order.builder()
                .id(2)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .endDate(LocalDate.now())
                .endTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .status(OrderStatus.ACTIVE)
                .build();
        Order order3 = Order.builder()
                .id(3)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .endDate(LocalDate.now())
                .endTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .status(OrderStatus.CANCELED)
                .build();
        return Arrays.asList(order1, order2, order3);
    }

    public static Order generateExpectedOrder() {
        return Order.builder()
                .id(2)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.SECONDS))
                .status(OrderStatus.NONE)
                .build();
    }

    public static Order generateReturnedOrder() {
        return generateExpectedOrder();
    }

    public static Order generateOrderWithMeals() {
        Meal meal = Meal.builder()
                .id(2)
                .name("Bravissimo")
                .description("sauce, cheese, oregano, sausage, mushrooms")
                .build();
        Order order = Order.builder()
                .id(2)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .endDate(LocalDate.now())
                .endTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .status(OrderStatus.ACTIVE)
                .build();
        order.getMeals().addAll(Arrays.asList(meal, meal, meal));
        return order;
    }

    public static OrderWithMealsDto generateOrderWithMealsDto() {
        Meal meal = Meal.builder()
                .id(2)
                .name("Bravissimo")
                .description("sauce, cheese, oregano, sausage, mushrooms")
                .build();
        Map<Meal, Long> mealToQuantity = new HashMap<>();
        mealToQuantity.put(meal, 3L);
        return OrderWithMealsDto.builder()
                .id(2)
                .startDate(LocalDate.now())
                .startTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .endDate(LocalDate.now())
                .endTime(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))
                .meals(mealToQuantity)
                .status(OrderStatus.ACTIVE)
                .build();
    }

    private TestModel() {}

}