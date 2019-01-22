<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- /.row -->


<div class="row">
	<div class="col-lg-12" style="width: 40%; ">
	<br><br>
		<div class="panel panel-default">
			<div class="panel-heading"> 게시글 수정 결과 페이지</div>
			
			<div class="panel-body">
					<c:if test="${modifyStatus == 'true' }">
						게시글 수정 성공
					</c:if>
					<c:if test="${modifyStatus != 'true'  }">
						게시글 수정 실패
					</c:if>
					
					<br><br>
					<button class="btn btn-default" onclick = "history.back()" >이전으로</button>
					<button class="btn btn-default" onclick = "location='/firstPage.do'" >메인페이지로</button>
					
			</div>
		</div>
	</div>
</div>
    