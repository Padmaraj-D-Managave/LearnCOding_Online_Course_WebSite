package com.learnCoding.Service;

import java.util.List;

import org.attoparser.dom.Comment;

import com.learnCoding.Entity.Comments;

public interface CommentServices {

	String saveComment(Comments comment2);

	List<Comments> getAllComments();

}
