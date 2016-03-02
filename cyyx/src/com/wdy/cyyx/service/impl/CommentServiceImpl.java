package com.wdy.cyyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdy.cyyx.dao.CommentDao;
import com.wdy.cyyx.entity.Comment;
import com.wdy.cyyx.service.CommentService;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, Integer>
		implements CommentService {

	@Resource
	public void setBaseDao(CommentDao commentDao) {
		super.setBaseDao(commentDao);
	}

}
