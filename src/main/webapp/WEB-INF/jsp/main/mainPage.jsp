<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../includes/header.jsp"%>

<c:if test="${index != 1 }">
	<jsp:include page="../board/list.jsp" />
</c:if>

<c:if test="${index == 1 }">
	<jsp:include page="${mainPageUrl }" />
</c:if>
<%@ include file="../includes/footer.jsp"%>