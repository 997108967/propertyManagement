<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<div id="header">
	<div id="rightheader">
		<p>
			<%
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			%>
			<%=sdf.format(date) %>
			<br />
		</p>
	</div>
	<div id="topheader">
		<h1 id="title">
			<a href="#"><img src="./img/timg.png" width="100px"></a>
		</h1>
	</div>
	<div id="navigation"></div>
</div>