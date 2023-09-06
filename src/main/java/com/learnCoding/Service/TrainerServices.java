package com.learnCoding.Service;

import java.util.List;

import com.learnCoding.Entity.Course;
import com.learnCoding.Entity.Lesson;

public interface TrainerServices 
{

	Course addCourse(int courseId, String courseName, int coursePrice);

	

	Lesson addLesson(Lesson lesson);

	public List<Course> getAllCourses();



	boolean courseExists(int courseId);



	Course getCourse(int courseId);






	

	


}
