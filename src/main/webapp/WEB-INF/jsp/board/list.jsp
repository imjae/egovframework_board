<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	$(document).ready(function(){
		var actionForm = $("#actionForm");
		$("li.paginate_button a").on("click", function(e){
			console.log('click');
			e.preventDefault();
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
	});
</script>


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
			<div class="panel-heading">게시판1</div>
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
							<td><c:out value="${board.rownum}" /> </td>
							<td><a href="/board/read.do?bn=${board.board_num }"><c:out value="${board.board_title }" /></a> </td>
							<td><c:out value="${board.board_writer }" /> </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.board_reg_date }"/> </td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.board_update_date }"/> </td>
						</tr>
					
					
					</c:forEach>
					
				</table>
			
			</div>
			
			<div class='pull-right'>
				<ul class="pagination">
					<c:if test="${pageMaker.prev == 'true' }">
						<li class="paginate_button previous"><a href="${pageMaker.startPage-1 }">Previous</a></li>
					</c:if>
					
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : "" }"> <a href="${num }">${num }</a></li>
					</c:forEach>
					
					<c:if test="${pageMaker.next == 'true' }">
						<li class="paginate_button next"><a href="${pageMaker.endPage +1 }">Next</a></li>
					</c:if>
				</ul>
			</div>
			
			<c:if test="${sessionScope.sessionEmail == null }">
			
				<div class="navbar-brand" style="margin-left: 50px;">
					로그인 해야 글 작성할수 있음.
				</div>
			</c:if>
			
			<c:if test="${sessionScope.sessionEmail != null }">
			<div class="panel-foot">
					<button type="submit" class="btn btn-default" 
					style="margin-left: 15px; margin-bottom: 15px;"
					onclick="location='/board/registerForm.do'"
					>
					글등록
					</button>
			</div>
			</c:if>
			
			<!-- /.panel-body -->
		</div>
		
		<form id="actionForm" action="/board/list.do" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
		</form>
		
		<%-- 
		<div class="panel panel-default">
			<div class="panel-heading">게시판2</div>
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
		
		
		
		
		<div class="panel panel-default">
			<div class="panel-heading">게시판3</div>
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
		</div> --%>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
