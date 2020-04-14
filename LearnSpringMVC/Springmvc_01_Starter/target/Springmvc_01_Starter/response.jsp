
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css" />
<%--    引入Jquery文件--%>
    <script src="resources/jquery.min.js"/>
    <script>
        $(function(){
            $("#btn").click(function(){
                alert("hello jquery");
            });
        });
    </script>
</head>
<body>
    <a href="response/string">response string</a><br>

    <a href="response/voidtest">response void default</a><br>

    <a href="response/voidtest2">response void</a><br>

    <a href="response/modelandview">response modelandview</a><br>

    <a href="response/forward">response forward</a><br>

    <a href="response/redirect">response redirect</a><br>

<%--    要去springmvcConfig.xml里面设置静态资源的不拦截，否则无法显示--%>
    <button id="btn">发送AJAX请求</button>


</body>
</html>
