package ua.pp.salnikov.pizzatesttask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.salnikov.pizzatesttask.service.OrderService;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders",orderService.getAllOrders());
        return "user";
    }

}
