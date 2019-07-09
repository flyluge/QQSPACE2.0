package com.qqSpace.web.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qqSpace.domain.Article;
import com.qqSpace.domain.Comment;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.service.CommentService;
import com.qqSpace.service.PraiseService;
import com.qqSpace.service.UserService;
import com.qqSpace.util.PageBean;
import com.qqSpace.util.UploadUtils;
import com.qqSpace.web.action.base.BaseAction;

public class ArticleAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;

	private ArticleService articleService;
	private PraiseService praiseService;
	private CommentService commentService;
	private UserService userService;
	
    private File file; //得到上传的文件
    private String fileContentType; //得到文件的类型
    private String fileFileName; //得到文件的名称
    private User user=new User();
    private Article article;
    private User selfuser;
    private Integer currpage;//当前页码
    private Integer pagesize;//页面大小
    private PageBean<Article> selfarticle;
	private Map<Integer, Integer> praises;
	private Map<Integer, PageBean<Comment>> comments;
	
	public User getSelfuser() {
		return selfuser;
	}
	public PageBean<Article> getSelfarticle() {
		return selfarticle;
	}
	public Map<Integer, Integer> getPraises() {
		return praises;
	}
	public Map<Integer, PageBean<Comment>> getComments() {
		return comments;
	}
	public void setPraiseService(PraiseService praiseService) {
		this.praiseService = praiseService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public File getFile() {
		return file;
	}
	public void setCurrpage(Integer currpage) {
		this.currpage = currpage;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public String showfarticle() {
		//获取用户的所有信息
		selfuser=userService.findUserById(user.getUid());
		//获取当前用户的说说
		selfarticle = articleService.selfArticle(selfuser, currpage, pagesize);
		//获取说说的评论
		comments = new HashMap<>();
		praises = new HashMap<>();
		for (Article article: selfarticle.getPage()) {
			praises.put(article.getAid(), praiseService.findAllCount(article.getAid()));
			Comment comment = new Comment();
			comment.setAid(article.getAid());
			PageBean<Comment> commentPage = commentService.findCommentByAid(1, 10, comment);
			comments.put(article.getAid(), commentPage);
		}
		return "farticleFrame";
	}
	public String showtarticle() {
		User user1 = (User) ActionContext.getContext().getSession().get("user");
		//获取当前用户的说说
		selfarticle = articleService.selfArticle(user1, currpage, pagesize);
		//获取说说的评论
		comments = new HashMap<>();
		praises = new HashMap<>();
		for (Article article: selfarticle.getPage()) {
			praises.put(article.getAid(), praiseService.findAllCount(article.getAid()));
			Comment comment = new Comment();
			comment.setAid(article.getAid());
			PageBean<Comment> commentPage = commentService.findCommentByAid(1, 10, comment);
			comments.put(article.getAid(), commentPage);
		}
		return "tarticleFrame";
	}
	public void publish() {
		if(file!=null) {
			String path=ServletActionContext.getServletContext().getRealPath("/upload/article/img");
			String uuidFileName=UploadUtils.getUUIDName(fileFileName);
			String realPath=UploadUtils.getPath(uuidFileName);
			String url=path+realPath+"/"+uuidFileName;
			try {
				FileUtils.copyFile(file, new File(url));
			} catch (IOException e) {
				e.printStackTrace();
			}			
			article.setImage("upload/article/img"+realPath+"/"+uuidFileName);
		}
		User user1=(User) ActionContext.getContext().getSession().get("user");
		if(user1!=null) {
			article.setPubdate(new Timestamp(new Date().getTime()));
			Article article2 = articleService.doPublish(user1, article);
			
			this.write(true, article2);			
		}
	}
	
	public void selfArticle() {
		User user1=(User) ActionContext.getContext().getSession().get("user");
		if(user1!=null) {
			PageBean<Article> articlesPage =  articleService.selfArticle(user1, 1, 5);
			write(true, articlesPage);
		}
	}
	
	public void allArticle() {
		User user1=(User) ActionContext.getContext().getSession().get("user");
		if(user1!=null) {
			PageBean<Article> articlesPage =  articleService.allArticle(user1, 1, 10);
			write(true, articlesPage);
		}
	}
	
	public void delArticle() {
		if(article!=null && article.getAid()!=null) {
			articleService.doDelete(article.getAid());
			this.write(true, "删除成功");
		} else {
			write(false, "信息不全删除失败");
		}
	}
	/**
	 * 通过uid获取说说的数量
	 */
	public void getCount() {
		Integer count = articleService.findCount(user.getUid());
		this.write(true, count);
	}
	
}
