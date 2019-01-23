<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">No.${boardVO.rn} | ${boardVO.board_title }</div>

			<div class="panel-body">

				<div class="form_group">
					<label>${boardVO.board_reg_date }</label> | 
					<label>${boardVO.board_writer }</label>

				</div>
				<div class="form_group">
					<textarea class="form-control" rows="12" name="board_content" readonly="readonly">
					${boardVO.board_content }
					</textarea>
				</div>
				<br>
				
				<button type="button" class="btn btn-default" onclick="location='/firstPage.do'">목 록</button>
				
				<c:if test="${sessionScope.sessionEmail == boardVO.board_writer }">
					<button type="button" class="btn btn-default" onclick="location='/board/modifyForm.do?bn=${boardVO.board_num}'">수 정</button>
					<button type="button" class="btn btn-default" onclick="location='/board/remove.do?bn=${boardVO.board_num}'">삭 제</button>
				</c:if>
			</div>
		</div>
	</div>
</div>
