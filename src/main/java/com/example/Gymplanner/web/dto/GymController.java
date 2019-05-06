package com.example.Gymplanner.web.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Gymplanner.domain.Exercise;
import com.example.Gymplanner.domain.ExerciseRepository;
import com.example.Gymplanner.domain.CategoryRepository;

import org.springframework.ui.Model;

@Controller
public class GymController {
	@Autowired
	private ExerciseRepository repository;
	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/registration")
	public String registration() {
		return "registration";
	}


	@RequestMapping(value = "/exerciselist")
	public String exerciseList(Model model) {
		model.addAttribute("exercises", repository.findAll());
		return "exerciselist";
		// etsii ne nimet, jotka GymplannerApplicationissa on määritetty HTML listana
	}

	// RESTful service to get all exercises
	@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public @ResponseBody List<Exercise> exerciseListRest() {
		return (List<Exercise>) repository.findAll();
	}

	// RESTful service to get exercise by id
	@RequestMapping(value = "/exercise/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId) {
		return repository.findById(exerciseId);
	}

	@RequestMapping(value = "/addexercise")
	public String addExercise(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("categories", crepository.findAll());
		return "addexercise";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Exercise exercise) {
		repository.save(exercise);
		return "redirect:exerciselist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteExercise(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../exerciselist";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editExercise(@PathVariable("id") Long id, Model model) {
		model.addAttribute("exercise", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editexercise";
	}
	 @GetMapping("/user")
	    public String userIndex() {
	        return "user/index";
	 }

}