package ua.pp.salnikov.pizzatesttask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.model.OrderStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@AllArgsConstructor
@Data
@Builder
public class OrderWithMealsDto {

    private Integer id;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private OrderStatus status;
    private final Map<Meal, Long> meals;

}
