<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/DispatcherServletDemo/StuServlet/list" method="post">
    <span>学生Id</span><input type="text" name="stu.stuId" value="1"><br>
    <span>学生姓名</span><input type="text" name="stu.stuName" value="王念"><br>
    <span>学生班级号</span><input type="text" name="stu.stuClass.stuClassId" value="1"><br>
    <span>学生班级名</span><input type="text" name="stu.stuClass.stuClassName" value="软件工程"><br>
    <span>院系号</span><input type="text" name="stu.stuClass.dept.deptId" value="1"><br>
    <span>院系名</span><input type="text" name="stu.stuClass.dept.deptName" value="软件学院"><br>
    <input type="submit" value="提交">
</form>
	
</body>
</html>