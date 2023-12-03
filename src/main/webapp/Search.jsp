<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="job.*" %>
<jsp:useBean id = "jdto" scope="request" class="job.JobDTO" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src='AddEntry_JS.js'></script>
<title>住所登録システム_検索画面</title>
</head>
<body>
<h1>住所登録システム</h1>

<div style="display:inline-flex">
<form method="get" action="http://localhost:8080/AddEntrySystem//Search.jsp">
<input type="submit" value="検索"  class="button">
</form>

<form>
<input type="reset" value="クリア" onclick="clearButtonClickS()" class="button">
</form>

<form method="post" action="http://localhost:8080/AddEntrySystem/Entry.jsp">
<input type="submit" value="新規" class="button">
</form>

<form method="get" action="http://localhost:8080/AddEntrySystem/Entry.jsp">
<input type="submit" value="変更" class="button" >
</form>

<form>
<input type="submit" value="削除" class="button">
</form>

<form>
<input type="button" value="終了" onclick = "closeWindow()" class="button">
</form>
</div>

 <p id="errormsg" style="color: red;"></p>

<table  border="1">
<tr>
<th><label for="id">登録ID</label></th>
<td><input id = "idfrom" type="text" name="idfrom" size="8">~<input id = "idto" type="text" name="idto" size="8"></td>
</tr>

<tr>
<th><label for="name">氏名</label></th>
<td><input id = "name" type="text" name="name" size="20"></td>
<th><label for="tell">電話番号</label></th>
<td><input id = "tell" type="text" name="tell" size="13"></td>
</tr>

<tr>
<th><label for="age">年齢</label></th>
<td><input id = "agefrom" type="text" name="agefrom" size=3>~<input id = "ageto" type="text" name="ageto" size=3></td>
<th><label for ="post">郵便番号</label></th>
<td><input id = "post" type="text" name="post" size="8"></td>
</tr>

<tr>
<th><label for="sex">性別</label></th>
<td>
<input type="radio" name="gender" value="male">男性
<input type="radio" name="gender" value="female">女性
<input id="sex" type="radio" name="gender" value="both" checked>両方
</td>
<th><label for ="address">市町村</label></th>
<td><input id = "address" type="text" name="address" size="20"></td>
</tr>

<tr>
<th><label for="job">職業</label></th>
<td>
<select name="job" class="form-controll">
<%
	for(int i=0; i < jdto.size(); i++){
		JobBean jb = jdto.get(i);
%>
	<option value=<%= jb.getId() %>><%= jb.getJob() %></option>
<% } %>
</select>
</td>
<th><label for ="address-detail">番地</label></th>
<td><input id = "address-detail" type="text" name="address-detail" size="20"></td>
</tr>
</table>

<p>&nbsp;</p>

<table  border="1">
<tr>
<th rowspan="2" style="background-color: blue;"><label for="checked">選択</label></th>
<th rowspan="2" style="background-color: blue;"><label for="id">登録ID</label></th>
<th><label for="name">氏名</label></th>
<th><label for="age">年齢</label></th>
<th><label for="sex">性別</label></th>
<th><label for="job">職業</label></th>
<th><label for="tell">電話番号</label></th>
</tr>
<tr>
<th><label for ="post">郵便番号</label></th>
<th colspan="3" align="left" style="background-color: blue;"><label for ="address">市町村</label></th>
<th><label for ="address-detail">番地</label></th>
</tr>
</table>

</body>
</html>