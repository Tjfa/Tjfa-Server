<%-- 
    Document   : addmatch
    Created on : 2014-7-15, 22:37:23
    Author     : CZM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <link href="http://cdn.bootcss.com/twitter-bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="content-type" content="text/html; charset=UTF-8"> 

    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/favicon.ico">



    <link rel="stylesheet" type="text/css" href="dist/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="dist/css/shCore.css">
    <link rel="stylesheet" type="text/css" href="dist/css/demo.css">
    <style type="text/css" class="init">

    </style>
    <script type="text/javascript">
        var req;
        var content;
        function init() {
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function initContent(i) {

            content = document.getElementById("name" + i).value;
        }
        function changeDrop2(i) {

            init();
            if (document.getElementById("name" + i).value !== content) {
                alert("change");
                var url = "player_edit?id=" + i + "&&name=" + document.getElementById("name" + i).value;
                req.open("GET", url, true);
                req.onreadystatechange = callback;
                req.send(null);

            }
            //var url = "product_getChilds?id=" + escape(document.frm.parent.options[document.frm.parent.selectedIndex].value);
            //req.open("GET", url, true);
            //req.onreadystatechange = callback;
            //req.send(null);
        }

        function callback() {
            if (4 === req.readyState) {

                if (200 === req.status) {
                    alert(req.responseText);
                    eval(req.responseText);
                }
            }

        }
    </script>
    <script type="text/javascript" language="javascript" src="dist/js/jquery.js"></script>
    <script type="text/javascript" language="javascript" src="dist/js/jquery.dataTables.js"></script>
    <script type="text/javascript" language="javascript" src="dist/js/shCore.js"></script>
    <script type="text/javascript" language="javascript" src="dist/js/demo.js"></script>
    <script type="text/javascript" language="javascript" class="init">


        $(document).ready(function() {
            $('#example').dataTable();
        });


    </script>
    <body>
        <s:property value="#session.date"/>
        <form action="news_add" method="post">
            <table class="table table-striped">
                <tr><td> 新闻标题  <input type="text" name="name" placeholder="Text input"></td></tr>
                <tr><td> 新闻时间：<input type="date" name="date"></td></tr>
                <tr><td>   新闻内容：<textarea class="form-control" rows="3" name="content"></textarea></td></tr>
          
          
           <tr><td> <input type="submit" value="添加" class="btn"></td></tr>
            </table>
        </form>
        <%
        out.println(session.getAttribute("name"));
        out.println(session.getAttribute("content"));
        %>
    </body>
</html>
