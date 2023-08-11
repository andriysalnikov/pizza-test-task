package ua.pp.salnikov.pizzatesttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pp.salnikov.pizzatesttask.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
