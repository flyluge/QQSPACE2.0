package com.qqSpace.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.Article;
import com.qqSpace.domain.Comment;
import com.qqSpace.domain.ReComment;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.service.CommentService;
import com.qqSpace.service.PraiseService;
import com.qqSpace.service.RecommentService;
import com.qqSpace.service.UserService;
import com.qqSpace.util.PageBean;
import com.qqSpace.web.action.base.BaseAction;

/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月5日 上午10:55:39 
*/
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private ArticleService articleService;
	private UserService userService;
	private CommentService commentService;
	private RecommentService recommentService;
	private PraiseService praiseService;
	private User user;
	private PageBean<Article> articles;
	private Map<Integer, Integer> praises;
	private Map<Integer, PageBean<Comment>> comments;
	private Map<Integer, PageBean<ReComment>> recomments;
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRecommentService(RecommentService recommentService) {
		this.recommentService = recommentService;
	}

	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Map<Integer, Integer> getPraises() {
		return praises;
	}

	public void setPraises(Map<Integer, Integer> praises) {
		this.praises = praises;
	}

	public void setPraiseService(PraiseService praiseService) {
		this.praiseService = praiseService;
	}
	
	public Map<Integer, PageBean<ReComment>> getRecomments() {
		return recomments;
	}
	public void setRecomments(Map<Integer, PageBean<ReComment>> recomments) {
		this.recomments = recomments;
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
	
	public String index() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			articles = articleService.allArticle(user, currpage, pagesize);
			comments = new HashMap<>();
			praises = new HashMap<>();
			for (Article article: articles.getPage()) {
				praises.put(article.getAid(), praiseService.findAllCount(article.getAid()));
				Comment comment = new Comment();
				comment.setAid(article.getAid());
				PageBean<Comment> commentPage = commentService.findCommentByAid(1, 30, comment);
				comments.put(article.getAid(), commentPage);
			}
			return SUCCESS;
		}
		else {
			this.write(false, "用户未登陆");
			return NONE;
		}
	};
}
