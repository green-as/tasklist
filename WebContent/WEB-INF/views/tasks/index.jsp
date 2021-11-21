<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">

    <c:param name="content">
        <h2>to-do list of tasks</h2>
        <ul>
            <c:forEach var="task" items="${tasks}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${task.id}">
                        <c:out value="${task.id}" />
                    </a>
                    ：&gt; <c:out value="${task.content}" />
                </li>
            </c:forEach>
        </ul>
        <%--↓は<a></a>なのでcreate a new taskというページに移動するリンク --%>
        <p><a href="${pageContext.request.contextPath}/new">create a new task</a></p>

    </c:param>
</c:import>
<%--jspとはhtmlにjavaをかけるようにしたもの
4行目の<c:import> を使うことで、url 属性に指定したファイルの内容をその位置で読み込むことができる
<c:param name="content"> と書いたタグの中の記述内容が、
app.jsp の ${param.content} のところに当てはまります。
<c:out>は値を出力するタグ--%>