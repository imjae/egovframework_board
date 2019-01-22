<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">글 수정</h1>
	</div>
	
	<!--  /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">글 수정</div>
			
			<div class="panel-body">
				<form role="form" action="/board/modify.do?bn=${boardVO.board_num }" method="post">
					<div class="form_group">
						<label>제 목</label>
						<input class="form-control" name="board_title" value="${boardVO.board_title } "> 
						
					</div>
					<div class="form_group">
						<label>내 용</label>
						<textarea class="form-control" rows="6" name="board_content">${boardVO.board_content }
						
						</textarea>
						
					</div>
					
					<br><br>
					<button type="submit" class="btn btn-default">수 정 </button>
					<button type="reset" class="btn btn-default">다시 작성</button>
				</form>
			</div>
		</div>
	</div>
</div>
