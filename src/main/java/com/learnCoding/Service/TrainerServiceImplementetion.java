package com.learnCoding.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnCoding.Entity.Course;
import com.learnCoding.Entity.Lesson;
import com.learnCoding.Repository.CourseRepository;
import com.learnCoding.Repository.LessonRepository;
@Service
public class TrainerServiceImplementetion implements TrainerServices
{
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	LessonRepository lessonRepo;

	@Override
	public Course addCourse(int courseId, String courseName, int coursePrice) {
		// TODO Auto-generated method stub
		System.out.println(courseId+" "+courseName+" "+coursePrice);
		Course course = new Course(courseId, courseName, coursePrice);
		System.out.println(course);
		courseRepo.save(course);
		return course;
	}

	@Override
	public Lesson addLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		Lesson save = lessonRepo.save(lesson);
		return save;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public boolean courseExists(int courseId) {
		// TODO Auto-generated method stub
		boolean existsById = courseRepo.existsById(courseId);
		System.out.println(existsById);
		return existsById;
	}

	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		Course course = courseRepo.findById(courseId).get();
		return course;
	}


	

	

}
