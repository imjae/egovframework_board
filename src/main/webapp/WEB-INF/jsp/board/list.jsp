<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시판</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					
					<c:forEach items="${list }" var="board">
						<tr>
							<td><c:out value="${board.board_num }" /> </td>
							<td><c:out value="${board.board_title }" /> </td>
							<td><c:out value="${board.board_writer }" /> </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.board_reg_date }"/> </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.board_update_date }"/> </td>
						</tr>
					
					
					</c:forEach>
					
				</table>
			
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@ include file="../includes/footer.jsp"%>