<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br/>
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br/>
        </c:forEach>


    </div>
</c:if>
<label for="content">create new task</label><br />
<input type="text" name="content" value="${task.content}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>


<%--リクエストスコープの message オブジェクトからデータを参照して、
入力内容の初期値として表示するようにしています。
このあと作成する edit や、入力値エラーがあって
フォームのページを再度表示する際に役立ちます。 --%>
