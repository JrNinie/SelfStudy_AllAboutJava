<%--
  Created by IntelliJ IDEA.
  User: Jr
  Date: 2020/4/14
  Time: 7:02 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--    <a href="anno/testParams?uage=12" > request params </a>--%>


<%--<form method="post" action="anno/body">--%>
<%--    user name: <input typ="text" name="uname">--%>
<%--    user age: <input typ="text" name="age">--%>
<%--    user birthday: <input typ="text" name="birthday">--%>
<%--    <input type="submit" value="submit">--%>
<%--</form>--%>

<%--不可以写成"anno/path/userid=10"是错的--%>
<%--<a href="anno/path/10" >  param variable </a>--%>


<%--<a href="anno/header" > header </a>--%>


<%--<form method="post" action="anno/modelAttribute">--%>
<%--    user name: <input typ="text" name="uname">--%>
<%--    user age: <input typ="text" name="age">--%>
<%--    <input type="submit" value="submit">--%>
<%--</form>--%>


<a href="anno/setSessionAttributes" > setSessionAttributes </a><br>
<a href="anno/getSessionAttributes" > getSessionAttributes </a><br>
<a href="anno/deleteSessionAttributes" > deleteSessionAttributes </a><br>




</body>
</html>
