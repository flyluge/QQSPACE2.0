package com.qqSpace.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qqSpace.domain.Article;
import com.qqSpace.domain.Comment;
import com.qqSpace.domain.ReComment;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.service.CommentService;
import com.qqSpace.service.RecommentService;
import com.qqSpace.service.UserService;
import com.qqSpace.util.PageBean;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月5日 上午10:55:39 
*/
public class IndexAction extends ActionSupport {
	private ArticleService articleService;
	private UserService userService;
	private CommentService commentService;
	private RecommentService recommentService;
	private User user;
	private PageBean<Article> articles;
	private Map<Integer, PageBean<Comment>> comments;
	private Map<Integer, PageBean<ReComment>> recomments;
	
	public Map<Integer, PageBean<ReComment>> getRecomments() {
		return recomments;
	}
	public void setRecomments(Map<Integer, PageBean<ReComment>> recomments) {
		this.recomments = recomments;
	}
	public void setRecommentService(RecommentService recommentService) {
		this.recommentService = recommentService;
	}
	public PageBean<Article> getArticles() {
		return articles;
	}
	public void setArticles(PageBean<Article> articles) {
		this.articles = articles;
	}
	
	public Map<Integer, PageBean<Comment>> getComments() {
		return comments;
	}
	public void setComments(Map<Integer, PageBean<Comment>> comments) {
		this.comments = comments;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String index() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			articles = articleService.allArticle(user, 1, 10);
			//System.out.println(articles);
			comments = new HashMap<>();
			for (Article article: articles.getPage()) {
				Comment comment = new Comment();
				comment.setAid(article.getAid());
				PageBean<Comment> commentPage = commentService.findCommentByAid(1, 10, comment);
//				recomments = new HashMap<>();
//				for(Comment c: commentPage.getPage()) {
//					ReComment recomment = new ReComment();
//					recomment.setComment(c);
//					PageBean<ReComment> recommentPage = recommentService.findRecomByCid(1, 5, recomment);
//					System.out.println(c+" "+recomment+" "+recomments);
//					recomments.put(c.getCid(), recommentPage);
//				}
				comments.put(article.getAid(), commentPage);
			}
			return SUCCESS;
		}
		return ERROR;
	};
}
