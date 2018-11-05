<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"/>
<script type="text/javascript">
    <%--请求的是json输出的也是json--%>
    function requestJson() {
        $.ajax({
            type:'post',
            url:'/requestJson',
            contentType:'application/json;charset=utf-8',
        //    数据格式是json串
            data:'{"name":"手机","price":"999"}',
            success:function (data) {
            //    返回json结果
                alert(data);
            }
        })
    }
    <%--请求的是key/value输出的也是json--%>
    function responseJson() {
        $.ajax({
            type:'post',
            url:'/responseJson',
            //    数据格式是json串
            data:'name=手机&&price=999}',
            success:function (data) {
                //    返回json结果
                alert(data);
            }
        })
    }
</script>
<body>
<input type="button"  value="请求的是json输出的也是json" onclick="requestJson()" \>
<input type="button" value="请求的是key/value输出的也是json" onclick="responseJson()"  \>

</body>
</html>
