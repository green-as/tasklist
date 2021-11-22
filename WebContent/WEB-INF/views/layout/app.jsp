<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>タスクリスト</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id ="header">
                <h1>TASKLIST</h1>
            </div>
        <div id="content">
            <%--${param.content} と書かれた部分に各ページのビューの内容が入ります --%>
            ${param.content }
        </div>
        <div id="footer">
            by taro kirameki.
        </div>
        </div>
    </body>
</html>
