package com.practice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public String getPosts(@RequestParam(defaultValue = "0") int page, 
							@RequestParam(defaultValue = "5") int size,
							@RequestParam(defaultValue = "", required = false) String keyword,
							Model model) {
		List<Post> posts = null;
		int totalPosts = 0;
		
		if(keyword.isEmpty() || keyword.isBlank()) {
			posts = postService.getPosts(page, size);
			totalPosts = postService.getPostCount();
		} else {
			posts = postService.getPostsByTitle(page, size, keyword);
			totalPosts = postService.getSearchCount(keyword);
		}
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("posts", posts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", (int) Math.ceil((double) totalPosts / size));
		model.addAttribute("pageSize", size);
		
		return "posts";
	}
	
	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		Post post = postService.getPost(id);
		
		model.addAttribute("post", post);
		
		return "post";
	}
	
	@GetMapping("/posts/form")
	public String getForm() {
		return "postForm";
	}
	
	@PostMapping("/posts/form")
	public String postForm(@ModelAttribute Post post) {
		postService.postForm(post);
		
		return "redirect:/posts";
	}
	
	@GetMapping("/posts/{id}/edit")
	public String getEdit(@PathVariable Long id, Model model) {
		Post post = postService.getPost(id);
		
		model.addAttribute("post", post);
		
		return "postEditForm";
	}
	
	@PostMapping("/posts/{id}/edit")
	public String postEdit(@PathVariable Long id, @ModelAttribute Post post) {
		postService.postEdit(id, post);
		
		return "redirect:/posts/{id}";
	}
	
	@GetMapping("/posts/{id}/delete")
	public String delete(@PathVariable Long id) {
		postService.delete(id);
		
		return "redirect:/posts";
	}
}
