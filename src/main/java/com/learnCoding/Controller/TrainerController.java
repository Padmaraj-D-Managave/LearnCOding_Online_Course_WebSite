package com.learnCoding.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnCoding.Entity.Course;
import com.learnCoding.Entity.Lesson;
import com.learnCoding.Service.TrainerServices;

@Controller
@RequestMapping
public class TrainerController 
{
	@Autowired
	TrainerServices ts;

	@PostMapping("/addCourse")
	public String addNewCourse(@RequestParam("courseId")int courseId,@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") int coursePrice,RedirectAttributes res) 
	{
		boolean course=ts.courseExists(courseId);
		if(course==true)
		{
			res.addFlashAttribute("error", "Course Already Present");
			return "redirect:/createCourse";
		}else {
			
			System.out.println(courseId+" "+courseName+" "+coursePrice);
			Course addCourse = ts.addCourse(courseId, courseName, coursePrice);
			System.out.println(addCourse);
			res.addFlashAttribute("success", "Course Added Successfully!!!!");
			return "redirect:/trainerHome";
		}
		
	}
	
	@PostMapping("/addLesson")
	public String addNewLesson(@RequestParam("courseId") int courseId,@RequestParam("lessonId") int lessonId,
			@RequestParam("lessonName") String lessonName,@RequestParam("lessonTopic") String lessonTopic,
			@RequestParam("lessonLink") String lessonLink,RedirectAttributes res) 
	{
		try {
			System.out.println(courseId+" "+lessonId+" "+lessonName+" "+lessonTopic+" "+lessonLink);
			Course course = ts.getCourse(courseId);
			Lesson lesson = new Lesson(lessonId, lessonName, lessonTopic, lessonLink, course);
			course.getLessons().add(lesson);
			ts.addLesson(lesson);
			
		
//			System.out.println(course.toString());
//			System.out.println(lesson);
			res.addFlashAttribute("success", "Lesson Added Successfully!!!!");
			return "redirect:/trainerHome";
		}
		
		catch (Exception e) {
			// TODO: handle exception
			res.addFlashAttribute("error", "Course or Lesso not present");
			return "redirect:/addLesson";
		}
	}
	
	@GetMapping("/viewCourse")
	public String getCourses(Model model)
	{	
		List<Course> courses = ts.getAllCourses();
		model.addAttribute("list",courses);
//		System.out.println(addAttribute);
		return "showAllCourse";
	}
	
}
