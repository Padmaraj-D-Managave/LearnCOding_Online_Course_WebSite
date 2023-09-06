package com.learnCoding.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnCoding.Entity.Course;
import com.learnCoding.Entity.Lesson;
import com.learnCoding.Service.StudentServices;
import com.learnCoding.Service.TrainerServices;

@Controller
public class StudentController 
{
	@Autowired
	TrainerServices ts;
	
	@Autowired
	StudentServices ss;
	
	@GetMapping("/myLeaningCourse")
	public String myLearningCources(Model model) 
	{
		List<Course> allCourses = ts.getAllCourses();
		System.out.println(allCourses);
		model.addAttribute("list",allCourses);
		return "purchaseCourse";
	}
	
	@PostMapping("/getMylearningLessons")
	public String getMylearninLessons(@RequestParam("lessonId") int lessonId,Model model,RedirectAttributes res) {
//		=ts.getLessonId(lessonId);
		try {
		System.out.println(lessonId);
		Lesson lesson = ss.getLessonId(lessonId);
		model.addAttribute("lesson",lesson);
		return "lessonDetails";
		}
		catch (Exception e) {
			// TODO: handle exception
			 res.addFlashAttribute("error", "Wrong Lesson Id");
			return "redirect:/getlesson"; 
		}
	}
}
