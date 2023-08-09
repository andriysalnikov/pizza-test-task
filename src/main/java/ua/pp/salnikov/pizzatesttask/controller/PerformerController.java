package ua.pp.salnikov.pizzatesttask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.salnikov.pizzatesttask.service.OrderService;

@Controller
@RequestMapping("/performer")
@AllArgsConstructor
public class PerformerController {

    private OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders",orderService.getAllOrdersWithActiveStatus());
        return "performer";
    }

    @PostMapping("/update")
    public String updateOrder(@RequestParam("id") Integer id) {
        orderService.updateOrderByPerformer(id);
        return "redirect:/performer";
    }

}
