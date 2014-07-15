<%@page import="java.util.Date"%>
<%@page pageEncoding="UTF-8" %>
<html>
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
   
    

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
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		function initContent(i){
                    
                    content=document.getElementById("name"+i).value;
                }
		function changeDrop2(i) {
                    
			init();
                       if(document.getElementById("name"+i).value!==content){
                           alert("change");
                           var url = "player_edit?id="+i + "&&name="+document.getElementById("name"+i).value;
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
			if(4 === req.readyState) {
		
				if(200 === req.status) {
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
} );


	</script>
<body class="dt-example">
   
<div class="navbar navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="http://v2.bootcss.com/index.html">Bootstrap</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="">
                <a href="http://v2.bootcss.com/index.html">首页</a>
              </li>
              <li class="active">
                <a href="competition_list">赛事</a>
              </li>
              <li class="">
                <a href="match_list">比赛</a>
              </li>
              <li class="">
                <a href="team_list">球队</a>
              </li>
              <li class="">
                <a href="player_list">球员</a>
              </li>
              
            </ul>
          </div>
        </div>
      </div>
    </div>
    
   <div class="container">
		<section>
			

			

			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Name</th>
						<th>number</th>
						
						<th>isStart</th>
						<th>time</th>
						<th>type</th>
                                                <th>管理</th>
                                               
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Name</th>
						<th>number</th>
						
						<th>isStart</th>
						<th>time</th>
						<th>type</th>
                                                <th>管理</th>
					</tr>
				</tfoot>

				<tbody>
					<%
                                        for(int i=0;i<50;i++){
                                        %>
                                        <tr>
                                            <td><input type="text" value="competition+<%=i%>" onblur="changeDrop2(<%=i%>)" id="name<%=i%>"  onfocus="initContent(<%=i%>)"></td>
                                            <td>1</td>
                                            <td>started</td>
                                            <td><%out.println(new Date());%></td>
                                            <td>1</td>
                                           
                                            <td><a href="">添加比赛</a></td>   
                                        </tr>
                                        <%
                                        }
                                        %>
                                        
				</tbody>
			</table>

			<div class="tabs">
				<div class="js">
					<p>The Javascript shown below is used to initialise the table shown in this
					example:</p><code class="multiline brush: js;">$(document).ready(function() {
	$('#example').dataTable();
} );</code>

					<p>In addition to the above code, the following Javascript library files are loaded for use in this
					example:</p>

					<ul>
						<li><a href="../../media/js/jquery.js">../../media/js/jquery.js</a></li>
						<li><a href="../../media/js/jquery.dataTables.js">../../media/js/jquery.dataTables.js</a></li>
					</ul>
				</div>

				<div class="table">
					<p>The HTML shown below is the raw HTML table element, before it has been enhanced by
					DataTables:</p>
				</div>

				<div class="css">
					<div>
						<p>This example uses a little bit of additional CSS beyond what is loaded from the library
						files (below), in order to correctly display the table. The additional CSS used is shown
						below:</p><code class="multiline brush: js;"></code>
					</div>

					<p>The following CSS library files are loaded for use in this example to provide the styling of the
					table:</p>

					<ul>
						<li><a href=
						"../../media/css/jquery.dataTables.css">../../media/css/jquery.dataTables.css</a></li>
					</ul>
				</div>

				<div class="ajax">
					<p>This table loads data by Ajax. The latest data that has been loaded is shown below. This data
					will update automatically as any additional data is loaded.</p>
				</div>

				<div class="php">
					<p>The script used to perform the server-side processing for this table is shown below. Please note
					that this is just an example script using PHP. Server-side processing scripts can be written in any
					language, using <a href="//datatables.net/manual/server-side">the protocol described in the
					DataTables documentation</a>.</p>
				</div>
			</div>
		</section>
	</div>


    
</body>
</html>