<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--↓これはJSTLのうちのコア機能を c という名前で利用できるようにする設定です。 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--↓これはJSTLのうちの日付フォーマット機能を"fmt"という名前で利用できるようにする設定です。 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>id : ${task.id} のタスクの詳細ページ</h2>
        <p>メッセージ：<c:out value="${task.content}" /></p>
        <p>作成日時：<fmt:formatDate value="${task.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>更新日時：<fmt:formatDate value="${task.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></p>

        <p><a href="${pageContext.request.contextPath}/index">Back</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${task.id}">edit this task</a></p>
    </c:param>
</c:import>
