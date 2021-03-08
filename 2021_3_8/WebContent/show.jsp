<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:useBean id="add" class="bean.Add"/>
	
	
	<!--<jsp:setProperty name="add" property="*"/>
		<br>num1为：<jsp:getProperty name="add" property="num1"/>
		<br>num2为：<jsp:getProperty name="add" property="num2"/>  -->
	<br>num1为：<jsp:getProperty name="add" property="num1"/>
	<br>num2为：<jsp:getProperty name="add" property="num2"/> 
	<br>最终的结果为：<%=add.getNum1()+add.getNum2() %>

</body>
</html>