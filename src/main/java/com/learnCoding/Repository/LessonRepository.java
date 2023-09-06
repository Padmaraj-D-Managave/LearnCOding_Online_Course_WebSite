package com.learnCoding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnCoding.Entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>
{

}
