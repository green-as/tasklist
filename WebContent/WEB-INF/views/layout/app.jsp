<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>タスクリスト</title>
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
            by Sota Akasaka.
        </div>
        </div>
    </body>
</html>
