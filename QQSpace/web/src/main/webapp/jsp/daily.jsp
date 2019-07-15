<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<title>Insert title here</title>
</head>
<body style="background: #F9F9F9;">

	<jsp:include page="container/head.jsp"></jsp:include>
	
	
	<div class="container content">
		<div class="row">
			<div class="col-md-12">
				<div>
					<form action="daily_save" method="post">
						<textarea name="content" id="content"></textarea>
							<script type="text/javascript">
								CKEDITOR.replace('content');
							</script>
						<input type="submit" />
					</form>
				</div>
			</div>
			<div class="col-md-12" >
				<c:forEach items="${dailys }" var="daily">
					<div style="background: white;">
						${daily.content }
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="container/footer.jsp"></jsp:include>

</body>
</html>