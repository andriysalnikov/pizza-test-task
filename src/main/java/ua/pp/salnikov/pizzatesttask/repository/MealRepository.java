package ua.pp.salnikov.pizzatesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.salnikov.pizzatesttask.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
