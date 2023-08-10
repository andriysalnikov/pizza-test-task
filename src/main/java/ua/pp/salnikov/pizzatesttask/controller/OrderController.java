package ua.pp.salnikov.pizzatesttask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.model.Order;
import ua.pp.salnikov.pizzatesttask.model.dto.OrderWithMealsDto;
import ua.pp.salnikov.pizzatesttask.service.MealService;
import ua.pp.salnikov.pizzatesttask.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private MealService mealService;

    @GetMapping
    public String showOrderWithMeals(@RequestParam("id") Integer id, Model model) {
        OrderWithMealsDto order = orderService.getOrderByIdWithMeals(id);
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping("/create")
    public String createOrder(Model model) {
        Order createdOrder = orderService.createOrder();
        OrderWithMealsDto order = orderService.getOrderByIdWithMeals(createdOrder.getId());
        List<Meal> meals = mealService.getAllMeals();
        model.addAttribute("order", order);
        model.addAttribute("allmeals", meals);
        return "create_order";
    }

    @GetMapping("/create")
    public String showOrder(@RequestParam("id") Integer id, Model model) {
        OrderWithMealsDto order = orderService.getOrderByIdWithMeals(id);
        List<Meal> meals = mealService.getAllMeals();
        model.addAttribute("order", order);
        model.addAttribute("allmeals", meals);
        return "create_order";
    }

    @PostMapping("/add-meal")
    public String addMealToOrder(@RequestParam("order_id") Integer orderId,
                                       @RequestParam("meal_id") Integer mealId) {
        orderService.addMealToOrder(orderId, mealId);
        return "redirect:/orders/create?&id=" + orderId;
    }

    @PostMapping("/canceled-by-user")
    public String cancelOrderByUser(@RequestParam("id") Integer id) {
        orderService.cancelOrder(id);
        return "redirect:/user";
    }

    @PostMapping("/canceled-by-performer")
    public String cancelOrderByPerformer(@RequestParam("id") Integer id) {
        orderService.cancelOrder(id);
        return "redirect:/performer";
    }

    @PostMapping("/done-by-performer")
    public String doOrderByPerformer(@RequestParam("id") Integer id) {
        orderService.doOrder(id);
        return "redirect:/performer";
    }

    @PostMapping("/save")
    public String saveOrder(@RequestParam("id") Integer id) {
        orderService.saveOrder(id);
        return "redirect:/user";
    }

}