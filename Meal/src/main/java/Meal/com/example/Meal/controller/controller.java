package Meal.com.example.Meal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Meal.com.example.Meal.Entity.meal;
import Meal.com.example.Meal.service.service;



@RestController
@RequestMapping("/pantry")
class controller {
	
	
	@Autowired
	private service todoservice;
//	private TopicService topicService;
//	
	
	
	@RequestMapping("/home")
	public String Welcome() {
		//it will automatically converted JSON object
		return "Welcome to CodingNinjas RailwayMealBookingApp";
	}
	
	@RequestMapping("/meals")
	public List<meal> getMeals(){
		
		return todoservice.getMeals();
		
	}
	@RequestMapping("/meal/{id}")
	public meal getSingleMeal(@PathVariable long id) {
		
		return todoservice.getMeal(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/meal")
	public void addMeal(@RequestBody meal todo) {
		System.out.print(todo);
		todoservice.addMeal(todo);
//		return todoservice.getTicket();
	}

	
	@RequestMapping(method=RequestMethod.PUT,value="/meal/{id}")
	public List<meal> updateTodo(@RequestBody meal topic,@PathVariable long id) {
		System.out.print(topic);
		todoservice.updateMeal(topic,id);
		return todoservice.getMeals();
	}

	
	@RequestMapping(method=RequestMethod.DELETE,value="/meal/{id}")
	public List<meal> deleteTodo(@PathVariable long id) {
		System.out.print(id);
		todoservice.deleteMeal(id);
		return todoservice.getMeals();
	}

}
