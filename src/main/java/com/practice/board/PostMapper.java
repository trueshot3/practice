package com.practice.board;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface PostMapper {
	
//	@Select("SELECT * FROM post ORDER BY id desc LIMIT #{offset}, #{limit}")
	public List<Post> findAll(@Param("offset") int offset, @Param("limit") int limit);
	
//	@Select("SELECT COUNT(*) FROM post")
	public int count();
	
//	@Select("SELECT * FROM post WHERE id = #{id}")
	public Post findById(Long id);
	
//	@Select("SELECT * FROM post WHERE title LIKE CONCAT('%', #{title}, '%') ORDER BY id desc LIMIT #{offset}, #{limit}")
	public List<Post> postsSearch(@Param("offset") int offset, @Param("limit") int limit, @Param("title") String title);
	
//	@Select("SELECT COUNT(*) FROM post WHERE title LIKE CONCAT('%', #{title}, '%')")
	public int searchCount(String title);
	
//	@Insert("INSERT INTO post(title, content) values(#{title}, #{content})")
	public void insert(Post post);
	
	public void update(Post post);
	
	public void delete(Long id);
}
