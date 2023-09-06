package com.learnCoding.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.learnCoding.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	

	

}
