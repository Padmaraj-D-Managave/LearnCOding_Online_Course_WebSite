package com.learnCoding.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnCoding.Entity.Lesson;
import com.learnCoding.Repository.LessonRepository;

@Service
public class StudentServicesImplementatiuon implements StudentServices
{
	@Autowired
	LessonRepository lessonRepo;
	
	@Override
	public Lesson getLessonId(int lessonId) 
	{
		// TODO Auto-generated method stub
		Lesson lesson = lessonRepo.findById(lessonId).get();
		return lesson;
	}

}
