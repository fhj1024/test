<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:useBean id="add" class="bean.Add" scope="request"/>
	<form action="" method="post">
		按下列格式要求，输入两个整数数据：<br>
		数据一：<input type="text" name="num1"><br>
		数据二：<input type="text" name="num2"><br>
		<input type="submit" value="提交"><br>
	</form>
	<a href="show.jsp">访问show.jsp页面，查看有关信息</a>
</body>
</html>