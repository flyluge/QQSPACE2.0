package com.qqSpace.service;

import com.qqSpace.domain.Comment;
import com.qqSpace.util.PageBean;

public interface CommentService {

	PageBean<Comment> findCommentByAid(Integer currpage,Integer pagesize,Comment comment);

	PageBean<Comment> findCommentByUid(Integer currpage, Integer pagesize, Comment comment);

	void deleteComment(Comment comment);

	Comment addComment(Comment comment);

}
