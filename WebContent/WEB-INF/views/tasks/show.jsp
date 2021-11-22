<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--↓これはJSTLのうちのコア機能を c という名前で利用できるようにする設定です。 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--↓これはJSTLのうちの日付フォーマット機能を"fmt"という名前で利用できるようにする設定です。 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <c:choose>
        <c:when test="${task != null}">
        <h2>id : ${task.id} のタスクの詳細ページ</h2>

        <table>
         <tbody>
            <tr>
                <th>タスク</th>
                     <td><c:out value="${task.content}" /></td>
            </tr>
            <tr>
                <th>作成日時</th>
                    <td><fmt:formatDate value="${task.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
            <tr>
                <th>更新日時</th>
                <td><fmt:formatDate value="${task.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </tbody>
        </table>
        <p><a href="${pageContext.request.contextPath}/index">Back</a></p>
        <p><a href="${pageContext.request.contextPath}/edit?id=${task.id}">edit this task</a></p>
        </c:when>
        <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
        </c:otherwise>
    </c:choose>
    </c:param>
</c:import>
