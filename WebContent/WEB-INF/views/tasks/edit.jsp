<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>id : ${task.id} のタスクの編集ページ</h2>

    <%--セッションスコープへタスクのIDの情報を保存して、/update へ渡す --%>
        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/index">Back</a></p>

    </c:param>
</c:import>