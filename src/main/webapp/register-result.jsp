<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="job.JobDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<JobDTO> jlist = (List<JobDTO>)session.getAttribute("jlist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src='AddEntry_JS.js'></script>
<title>住所登録システム_登録画面</title>
</head>
<body>
<h1>登録画面</h1>

<form method="post" action="/AddEntrySystem/Search01.jsp">
<div style="display:inline-flex">
<input type="submit" value="登録" class="button">
<input type="reset" value="クリア" onclick="clearButtonClickR()" class="button">
<input type="submit" value="中止" class="button">
</div>

 <p id="errormsg" style="color: red;"></p>

<table  border="1">
<tr>
<th><label for="id">登録ID</label></th>
<td ><input id = "id" type="text" name="id" size="8"></td>
</tr>

<tr>
<th><label for="name">氏名</label></th>
<td><input id = "name" type="text" name="name" size="20"></td>
</tr>

<tr>
<th><label for="age">年齢</label></th>
<td><input id = "age" type="text" name="age" size=3>歳</td>
</tr>

<tr>
<th><label for="sex">性別</label></th>
<td>
<input id = "sex" type="radio" name="gender" value="male" checked>男性
<input type="radio" name="gender" value="female">女性
</td>
</tr>

<tr>
<th><label for="job">職業</label></th>
<td>
<select name="job">
<c:forEach var="tmp" items="${jlist}">
<option><c:out value="${tmp.job}" /></option>
</c:forEach>
<!--  <option value="" id = "job"></option> -->
<!--  <option value="01">会社員</option> -->
<!--  <option value="02">公務員</option> -->
<!--  <option value="03">自営業</option> -->
<!--  <option value="04">個人事業主</option> -->
<!--  <option value="05">経営者・会社役員</option> -->
<!--  <option value="06">パート・アルバイト</option> -->
<!--  <option value="07">専業主婦・主夫</option> -->
<!--  <option value="08">学生</option> -->
<!--  <option value="09">その他</option> -->
</select>
</td>
</tr>

<tr>
<th><label for="tell">電話番号</label></th>
<td><input id = "tell" type="text" name="tell" size="13"></td>
</tr>

<tr>
<th><label for ="post">郵便番号</label></th>
<td><input id = "post" type="text" name="post" size="8"></td>
</tr>

<tr>
<th><label for ="address">市町村</label></th>
<td><input id = "address" type="text" name="address" size="20"></td>
</tr>

<tr>
<th><label for ="address-detail">番地</label></th>
<td><input id = "address-detail" type="text" name="address-detail" size="20"></td>
</tr>
</table>
</form>

</body>
</html>