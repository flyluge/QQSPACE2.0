/*评论模块  */
	function publish_comment(aid, uid,id){
		id="#"+id;
		$.ajax({
			url:"CommentAction_addComment",
			type:"post",
			dataType: "json",
			data:{
				"comment.user.uid": uid,
				"comment.aid": aid,
				"comment.content":$("#publish-comment_"+aid).val()
			},
			success:function(data){
				// alert(JSON.stringify(data));
				if(data.message){
					$(id).append(`<ul class="media-list comment">
							<li class="media">
								<div class="media-left">
									<a href="#"> <img class="media-object article-user-img"
										src="/web/${selfuser.userimg }" alt="图片加载失败">
									</a>
								</div>
								<div class="media-body">
									<h5 class="media-heading">${selfuser.username }<span
											class="article-comment-time">刚刚</span><a
											href="#"><span class="glyphicon glyphicon-comment"></span></a>
									</h5>
									<p>`+$("#publish-comment_"+aid).val()+`</p>
								</div>
							</li>
						</ul>`);
					$("#comment_input").val("");
				} else {
					alert(data.data);
				}
			}
		})
	}
	/*取消点赞模块  */
	function cancel(uid,aid){
		$.ajax({
			url:"praise_cancel",
			type:"post",
			data:{
				"aid": aid,
				"uid": uid
			},
			dataType: "json",
			success:function(data){
			}
		})
	}
	/*点赞模块*/
	function praise(uid, aid,id){
		id="#"+id;
		let count=$(id).html();
		$.ajax({
			url:"praise_praise",
			type:"post",
			data:{
				"aid": aid,
				"uid": uid
			},
			dataType: "json",
			success:function(data){
				if(data.message){
					count++;
					$(id).html(count);
					$(id).after(`<span>已赞</span>`);
				}
				else{
					count--;
					$(id).html(count);
					$(id).next().remove();
					cancel(uid,aid);
				}
			}
		})
	}