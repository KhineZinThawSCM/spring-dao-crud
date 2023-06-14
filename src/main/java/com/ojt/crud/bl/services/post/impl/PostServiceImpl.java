package com.ojt.crud.bl.services.post.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.crud.bl.dto.PostDTO;
import com.ojt.crud.bl.services.post.PostService;
import com.ojt.crud.persistence.dao.post.PostDao;
import com.ojt.crud.persistence.entity.Post;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;
	
	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> posts = this.postDao.getAllPosts();
		if (posts == null) {
            return null;
        }

        return posts.stream().map(item -> new PostDTO(item)).collect(Collectors.toList());
	}
}
