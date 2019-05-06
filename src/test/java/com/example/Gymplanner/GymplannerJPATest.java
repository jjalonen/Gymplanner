package com.example.Gymplanner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Gymplanner.domain.Category;
import com.example.Gymplanner.domain.Exercise;
import com.example.Gymplanner.domain.ExerciseRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GymplannerJPATest {

	 @Autowired
	    private ExerciseRepository repository;
	
	 	
	 @Test
	    public void findByTitleShouldReturnExercise() {
	        List<Exercise> exercises = repository.findByTitle("Deadlifts");
	        
	        assertThat(exercises).hasSize(1);
	        assertThat(exercises.get(0).getSet()).isEqualTo(4);
	    }
	 
	 @Test
	    public void createNewExercise() {
	    	Exercise exercise = new Exercise("Squats", 0, 4, 15, new Category("Legs", null) );
	    	repository.save(exercise);
	    	assertThat(exercise.getId()).isNotNull();
	    }   
	 
	 @Test
	 	public void deleteExercise() {
		 List<Exercise> exercises = repository.findByTitle("Bicep Curls");
	        
	        assertThat(exercises).hasSize(1);
	        repository.delete(exercises.get(0));
	        
	        List<Exercise> deletedexercise = repository.findByTitle("Bicep Curls");
	        
	        assertThat(deletedexercise).hasSize(0);
		 
	 }
	 
}