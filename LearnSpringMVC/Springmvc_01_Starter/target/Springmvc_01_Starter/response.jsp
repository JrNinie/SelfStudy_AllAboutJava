
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css" />
<%--    引入Jquery文件--%>
    <script src="resources/jquery.min.js"></script>

<%--    简单弹框--%>
<%--    <script>--%>
<%--        $(function(){--%>
<%--            $("#btn").click(function(){--%>
<%--                alert("hello jquery");--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>


<%--    发回数据，controller可以用@RequestBody接收--%>
    <script>
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"response/testAjax",
                    //发送信息至服务器时内容编码类型
                    contentType:"application/json;charset=UTF-8",
                    //发送的信息，json格式
                    data:'{"uname":"Sandie","age":18,"birthday":"2017-12-23"}',
                    //服务器返回值的类型
                    dataType:"json",
                    type:"post",
                    //请求成功后的回调函数
                    success:function (data) {
                        //参数data指服务器端响应的json数据，进行解析
                        alert(data.uname);
                        alert(data.age);
                    }
                })
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
