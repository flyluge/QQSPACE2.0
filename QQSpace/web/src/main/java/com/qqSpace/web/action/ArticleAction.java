package com.qqSpace.web.action;
/** 
* @author 作者 YunLei
* @version 创建时间：2019年7月1日 下午3:19:59 
*/

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.qqSpace.domain.Article;
import com.qqSpace.domain.User;
import com.qqSpace.service.ArticleService;
import com.qqSpace.util.PageBean;
import com.qqSpace.util.UploadUtils;
import com.qqSpace.web.action.base.BaseAction;

public class ArticleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArticleService articleService;
	
    private File file; //得到上传的文件
    private String fileContentType; //得到文件的类型
    private String fileFileName; //得到文件的名称
    
    private Article article;
    
	
	public File getFile() {
		return file;
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

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
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
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			article.setPubdate(new Timestamp(new Date().getTime()));
			articleService.doPublish(user, article);
			this.write(true, "发表成功");			
		}
	}
	
	public void selfArticle() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			PageBean<Article> articlesPage =  articleService.selfArticle(user, 1, 5);
			write(true, articlesPage);
		}
	}
	
	public void allArticle() {
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			PageBean<Article> articlesPage =  articleService.allArticle(user, 1, 5);
			write(true, articlesPage);
		}
	}
	
	public void delArticle() {
		if(article!=null && article.getAid()!=null) {
			articleService.doDelete(article.getAid());
			this.write(true, "删除成功");
		}
	}
	
}
