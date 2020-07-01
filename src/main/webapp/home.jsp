<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/15
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
    <link href="new.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" href="myico.ico" type="image/x-icon" />
    <script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        table { table-layout: fixed;}
        table tr td {
            overflow:hidden;
            white-space:nowrap;
            text-overflow:ellipsis;
            -o-text-overflow:ellipsis;
            -moz-text-overflow: ellipsis;
            -webkit-text-overflow: ellipsis;
        }
    </style>
</head>
<body>
<div class="container mar">
    <table class="table">
        <thead>
        <tr >
            <th>电影名字</th>
            <th>电影类型</th>
        </tr>
        </thead>
        <tbody >
        <s:iterator value="#request.list" status="li">
            <tr>
                <td> <s:property value="name"/> </td>
                <td><s:property value="type"/> </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<center>
</center>
</body>
</html>
