package com.practice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	public List<Post> getPosts(int page, int size) {
		int offset = page * size;
		
		return postMapper.findAll(offset, size);
	}
	
	public int getPostCount() {
		return postMapper.count();
	}
	
	public Post getPost(Long id) {
		return postMapper.findById(id);
	}
	
	public List<Post> getPostsByTitle(int page, int size, String keyword) {
		int offset = page * size;
		
		return postMapper.postsSearch(offset, size, keyword);
	}
	
	public int getSearchCount(String keyword) {
		return postMapper.searchCount(keyword);
	}
	
	public void postForm(Post post) {
		postMapper.insert(post);
	}
	
	public void postEdit(Long id, Post post) {
		post.setId(id);
		postMapper.update(post);
	}
	
	public void delete(Long id) {
		postMapper.delete(id);
	}
}
