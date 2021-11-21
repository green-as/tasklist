<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="content">create new task</label><br />
<input type="text" name="content" value="${task.content}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>


<%--リクエストスコープの message オブジェクトからデータを参照して、
入力内容の初期値として表示するようにしています。
このあと作成する edit や、入力値エラーがあって
フォームのページを再度表示する際に役立ちます。 --%>
