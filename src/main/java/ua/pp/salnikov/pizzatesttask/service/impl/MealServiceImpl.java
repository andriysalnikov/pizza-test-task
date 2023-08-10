package ua.pp.salnikov.pizzatesttask.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.repository.MealRepository;
import ua.pp.salnikov.pizzatesttask.service.MealService;

import java.util.List;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {
    
    private MealRepository mealRepository;

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

}
