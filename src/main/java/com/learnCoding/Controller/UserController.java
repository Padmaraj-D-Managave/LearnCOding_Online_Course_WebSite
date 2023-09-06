package com.learnCoding.Controller;

import java.util.List;

import org.attoparser.dom.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnCoding.Entity.Comments;
import com.learnCoding.Entity.User;
import com.learnCoding.Service.CommentServices;
import com.learnCoding.Service.UserService;



@Controller
@RequestMapping
public class UserController 
{
	@Autowired
	UserService us;
	int username;
	
	@Autowired
	CommentServices cs;

	@PostMapping("/addUser")
	public String addUser(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,@RequestParam("password") String password,
			@RequestParam("userType") String userType,@RequestParam("mobile") String mobile,RedirectAttributes res ) 
	{
		if(us.emailExist(email)==false)
		{
		User user= new User(firstname, lastname, email, password, userType, mobile);
		System.out.println(user.toString());
		us.addUser(user);
		res.addFlashAttribute("success", "Registed Successfull");
		return "redirect:/login";
		}else {
			res.addFlashAttribute("error", "Already Present Please Login");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/loginUser")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,Model model,RedirectAttributes res)
	{
		if(us.emailExist(email))
		{
			
			User user=us.loginUser(email, password);
			if(user!=null) 
			{
				if(user.getUserType().equals("Student"))
				{
				model.addAttribute("User",user);
				this.username=user.getUsername();
				return "studentHome";
				}else {
					model.addAttribute("User",user);
					return "redirect:/trainerHome";
				}
			}
			else
			{
				res.addFlashAttribute("error", "Wrong Password");
				return "redirect:/login";
			}
		}
		else 
		{
			res.addFlashAttribute("error", "User not Registered ,REGISTER !!");
			return "redirect:/register";
		}
		
		
	}
	
	@GetMapping("/resetPass")
	public String resetPassword(@RequestParam("email") String email,RedirectAttributes res)
	{
		if(us.emailExist(email))
		{
			return "redirect:/resetPassword";
		}else 
		{
			res.addFlashAttribute("error", "Not Registered Please Register");
			return "redirect:/register";
		}
	}
	
	@PostMapping("/newPassword")
	public String newPassword(@RequestParam("email") String email,RedirectAttributes res,@RequestParam("password") String password)
	{
		if(us.emailExist(email))
		{
		User setNewPassword = us.setNewPassword(email,password);
		res.addFlashAttribute("success", "Password Reset Successfull");
		return "redirect:/login";
		}else 
		{
			res.addFlashAttribute("error", "Enter the Registered Email only");
			return "redirect:/resetPassword";
		}
	}
	
	@PostMapping("/addComments")
	public String addComments(@RequestParam("comment") String comment,Model model)
	{
		Comments comment2 = new Comments();
		comment2.setComment(comment);
		String comments=cs.saveComment(comment2);
		
		List<Comments> list=cs.getAllComments();
		model.addAttribute("list",list);
		return "lessonDetails";
	}
	
	
}
