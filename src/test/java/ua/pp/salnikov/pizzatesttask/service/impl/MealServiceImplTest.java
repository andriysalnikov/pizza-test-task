package ua.pp.salnikov.pizzatesttask.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.pp.salnikov.pizzatesttask.model.Meal;
import ua.pp.salnikov.pizzatesttask.repository.MealRepository;
import ua.pp.salnikov.pizzatesttask.util.TestModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MealServiceImplTest {

    @Mock
    private MealRepository mealRepository;
    @InjectMocks
    private MealServiceImpl mealService;

    @Test
    void whenGetAllMeals_shouldReturnListOfAllMeals() {
        List<Meal> meals = TestModel.generateListOfMeals();
        when(mealRepository.findAll()).thenReturn(meals);
        assertIterableEquals(meals, mealService.getAllMeals());
        verify(mealRepository, times(1)).findAll();
    }











}
