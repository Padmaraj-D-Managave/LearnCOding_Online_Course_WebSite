package com.learnCoding.Service;

import java.util.List;

import org.attoparser.dom.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnCoding.Entity.Comments;
import com.learnCoding.Repository.CommentRepository;

@Service
public class CommentServicesImplementation implements CommentServices
{
	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public String saveComment(Comments comment2) {
		// TODO Auto-generated method stub
		Comments save = commentRepo.save(comment2);
		return "save";
	}

	@Override
	public List<Comments> getAllComments() {
		// TODO Auto-generated method stub
		List<Comments> allComments = commentRepo.findAll();
		return allComments;
	}

}
