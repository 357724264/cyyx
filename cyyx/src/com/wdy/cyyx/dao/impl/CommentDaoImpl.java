package com.wdy.cyyx.dao.impl;

import org.springframework.stereotype.Repository;

import com.wdy.cyyx.dao.CommentDao;
import com.wdy.cyyx.entity.Comment;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment, Integer> implements
		CommentDao {

}
