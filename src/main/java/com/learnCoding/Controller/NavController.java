package com.learnCoding.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController 
{
	@GetMapping("/")
	public String index() 
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String register() 
	{
		return "register";
	}
	
	@GetMapping("/login")
	public String login() 
	{
		return "login";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPassword()
	{
		return "forgotPassword";
	}
	
	@GetMapping("/resetPassword")
	public String reset()
	{
		return "resetPassword";
	}
	
	@GetMapping("/addLesson")
	public String addLesson()
	{
		return "addLesson";
	}
	
	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
		
	}
	
	@GetMapping("/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}
	
	@GetMapping("/studentHome")
	public String  studentHome() {
		return "studentHome";
		
	}
	@GetMapping("/myCourse")
	public String myCourses() {
		return "myCourse";
	}
	@GetMapping("/getlesson")
	public String getlesson() {
		return "getlesson";
	}
	@GetMapping("/lessonDetails")
	public String lessonDetails() {
		return "lessonDetails"; 
	}
	
}
