package com.learnCoding.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnCoding.Entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>
{

}
