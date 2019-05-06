package com.example.Gymplanner.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.Gymplanner.domain.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long>{
	
	List<Exercise> findByTitle(String title);
    Exercise findBooksById(Long Id);
}
