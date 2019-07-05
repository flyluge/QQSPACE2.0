let article = `<div class="col-md-12 article-wrap">
						<div class="article-content">
							<div class="article-heading">
								<img class="img-circle user-headimg article-user-img" src="img/1.jpg">
								<span class="article-user-name"></span>
							</div>
							<div class="article-body">
								<p>13213213</p>
								<!--说说图片列表-->
							</div>
							<div class="text-right">
								<span class="article-publish-time">2016/07/01</span>
								<a href="#" class=" text-danger"><span class="glyphicon glyphicon-heart"></span>15</a>
							</div>
						</div>
						<div class="publish-article-comment">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="写下你的想法" aria-describedby="basic-addon2">
								<span class="input-group-addon" id="basic-addon2">评论</span>
							</div>
						</div>
					</div>`;
let article_imglist = `<div class="col-md-12 article-imglist">
									<div class="col-md-4"><img class="img-responsive" src="img/1.jpg" /></div>
									<div class="col-md-4"><img class="img-responsive" src="img/1.jpg" /></div>
									<div class="col-md-4"><img class="img-responsive" src="img/1.jpg" /></div>
								</div>`;
let comment = `<div class="article-comment">
							<ul class="media-list comment">
								<li class="media">
									<div class="media-left">
										<a href="#">
											<img class="media-object user-img" src="img/1.jpg" alt="...">
										</a>
									</div>
									<div class="media-body">
										<h5 class="media-heading">用户一<span class="article-comment-time">time</span><a href="#"><span class="glyphicon glyphicon-comment"></span></a></h5>
										<p>
											我评论文章了
											
										</p>
									</div>
								</li>
							</ul>
						</div>`;
let recomment = `<ul class="media-list">
											<li class="media">
												<div class="media-left">
													<a href="#">
														<img class="media-object user-img" src="img/001.png" alt="...">
													</a>
												</div>
												<div class="media-body">
													<h5 class="media-heading">
														用户三<span class="article-comment-time">time</span>
														<a href="#"><span class="glyphicon glyphicon-comment"></span></a>
													</h5>
													<p>
														我评论文章了
													</p>
												</div>
											</li>
										</ul>`;
$(function(){
	init();
})
function publish_article(){
	alert($("#article_content_pub").val());
	$.ajax({
		url:"article_publish",
		type:"post",
		dataType: "json",
		data:{"article.content":$("#article_content_pub").val()},
		success:function(data){
			// alert(JSON.stringify(data));
			if(data.message){
				alert(data.data);
				window.location.href="index.html";
			} else {
				alert(data.data);
				
			}
		}
	})
}
let anum = [];
function init(){
	initArticle();
	
}
function initArticle(){
	$.ajax({
		url:"article_selfArticle",
		type:"get",
		dataType: "json",
		success:function(data){
			//alert(JSON.stringify(data));
			if(data.message){
				//alert(data.data);
				let articles = data.data.page;
				for(let i in articles){
					//alert(articles[i].content);
					anum.unshift(articles[i].aid);
					$(".publish-article").after(`
					<div class="col-md-12 article-wrap">
						<div class="article-aid" style="display: none;">${articles[i].aid}</div>
						<div class="article-content">
							<div class="article-heading">
								<img class="img-circle user-headimg article-user-img" src="img/1.jpg">
								<span class="article-user-name">${articles[i].user.username}</span>
							</div>
							<div class="article-body">
								<p>${articles[i].content}</p>
								<!--说说图片列表-->
								<div class="col-md-12 article-imglist">
								
								</div>
							</div>
							<div class="text-right">
								<span class="article-publish-time">${articles[i].pubdate}</span>
								<a href="#" class=" text-danger"><span class="glyphicon glyphicon-heart"></span>15</a>
							</div>
						</div>
					</div>`);
					
				}
				initComment();
			} else {
				alert(data.data);
				
			}
		}
	})
}
function initComment(){
	for(let i=0; i < anum.length;i++){
		console.log(anum.length);
		$.ajax({
			url:"CommentAction_findCommentByAid",
			type:"post",
			data: {
				"comment.aid": anum[i],
				"currpage": 1,
				"pagesize": 10
			},
			dataType: "json",
			success:function(data){
				//alert(JSON.stringify(data));
				if(data.message){
					let comment = data.data.page;
					if(comment.length!=0){
						
						$(".article-wrap").eq(i).append(`
								<div class="article-comment">
								
								</div>
						`);
						for(let i in comment){
							$(".article-wrap").eq(i).find(".article-comment").append(
									`<ul class="media-list comment">
									<li class="media">
									<div class="media-left">
									<a href="#">
									<img class="media-object article-user-img" src="img/1.jpg" alt="...">
									</a>
									</div>
									<div class="media-body">
									<h5 class="media-heading">用户一<span class="article-comment-time">time</span><a href="#"><span class="glyphicon glyphicon-comment"></span></a></h5>
									<p>
									我评论文章了
									</p>
									</div>
									</li>
							</ul>`);
						}
					}
					
					$(".article-wrap").eq(i).append(
							`<div class="publish-article-comment">
							<div class="input-group">
							<input type="text" class="form-control" placeholder="写下你的想法" aria-describedby="basic-addon2">
							<span class="input-group-addon" id="basic-addon2">评论</span>
							</div>
					</div>`);
					
				} else {
					alert(data.data);
				}
			}
		})
		
	}
}