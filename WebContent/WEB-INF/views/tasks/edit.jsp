<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
        <c:when test="${task != null}">
        <h2>id : ${task.id} のタスクの編集ページ</h2>

    <%--セッションスコープへタスクのIDの情報を保存して、/update へ渡す --%>
        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/index">Back</a></p>
        <p><a href="#" onclick="confirmDestroy();">delete</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/destroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("Are you sure you want to delete it?")) {
                document.forms[1].submit();
            }
        }
        </script>
        </c:when>
        <c:otherwise>
            <h2>お探しのデータは見つかりませんでした。</h2>
        </c:otherwise>
        </c:choose>
    </c:param>
</c:import>