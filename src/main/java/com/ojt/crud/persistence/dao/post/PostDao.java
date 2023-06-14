package com.ojt.crud.persistence.dao.post;

import java.util.List;

import com.ojt.crud.persistence.entity.Post;

public interface PostDao {
	List<Post> getAllPosts();
}
