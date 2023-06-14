package com.ojt.crud.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ojt.crud.bl.dto.PostDTO;
import com.ojt.crud.bl.services.post.PostService;
import com.ojt.crud.web.form.PostForm;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/posts/list")
	public ModelAndView getAllPosts() {
		System.out.println("Hello");
		List<PostDTO> postDtoList = this.postService.getAllPosts();
		ModelAndView mv = new ModelAndView("posts/list");
		mv.addObject("posts", postDtoList);
		return mv;
	}
	
	@RequestMapping("/posts/create")
	public ModelAndView createPost() {
		ModelAndView mv = new ModelAndView("posts/create");
		mv.addObject("postForm", new PostForm());
		return mv;
	}
	
	@RequestMapping(value = "/posts/store", method = RequestMethod.POST)
	public ModelAndView storePost(@ModelAttribute("postForm") @Valid PostForm postForm,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mv.setViewName("posts/create");
			return mv;
		}
		
//		this.postService.savePost(postForm);
		mv.setViewName("redirect:/posts/list");
		return mv;
	}
}
