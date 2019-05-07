package com.example.Gymplanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Gymplanner.domain.Exercise;
import com.example.Gymplanner.domain.ExerciseRepository;
import com.example.Gymplanner.domain.User;
import com.example.Gymplanner.domain.UserRepository;
import com.example.Gymplanner.domain.Category;
import com.example.Gymplanner.domain.CategoryRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class GymplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymplannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ExerciseRepository repository, CategoryRepository crepository,
			UserRepository userRepository) {
		return (args) -> {

			Category c1 = new Category();
			c1.setName("Pull");
			crepository.save(c1);

			Category c2 = new Category();
			c2.setName("Push");
			crepository.save(c2);

			Category c3 = new Category();
			c3.setName("Legs");
			crepository.save(c3);

			Category c4 = new Category();
			c4.setName("Core");
			crepository.save(c4);

			repository.save(new Exercise("Deadlifts", 80, 4, 6, c1));
			repository.save(new Exercise("Bicep Curls", 30, 4, 8, c1));
			repository.save(new Exercise("Tricep Curls", 20, 4, 8, c1));
			repository.save(new Exercise("Pull-ups", 0, 3, 5, c1));
			repository.save(new Exercise("Bench Press", 70, 4, 5, c2));
			repository.save(new Exercise("Push-ups", 0, 3, 20, c2));
			repository.save(new Exercise("Barbell Squats", 50, 4, 8, c3));
			repository.save(new Exercise("Mountain Climbers", 0, 3, 50, c4));
			repository.save(new Exercise("Crunches", 0, 3, 25, c4));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C");

			userRepository.save(user1);
			userRepository.save(user2);
			// listaa new Exercisen tietoja sen mukaan mitä Exercise classissä on tietueita
			// Exercise exercise = new Exercise("Exe1", "4", "10", "")
			// repository.save(exercise);
		};
	}

}