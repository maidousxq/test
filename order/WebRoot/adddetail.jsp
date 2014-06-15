<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Order" %>
<html>
  <head>
  </head>
  <body>
  	<center>
  	<form action="/order/Control">
  	<input type="hidden"  name="mode" value="add"/>
  	<table>
  		<tr>
  			<td>订单号</td>
  			<td>
  				<select name="ORDER_ID">
  				<%
  				ArrayList list=(ArrayList)request.getAttribute("order");
  				for(int i=0; i<list.size(); ++i){
  					Order o=(Order)list.get(i);
  				%>
  					<option value="<%=o.getORDER_ID()%>"><%=o.getORDER_ID()%></option>
  				<%}%>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td>产品编号</td>
  			<td><input type="text" name="PRODUCT_ID"/></td>
  		</tr>
  		<tr>
  			<td>订购数量</td>
  			<td><input type="text" name="QUANTITY"/></td>
  		</tr>
  	</table>
  	<input type="submit" value="提交"/>
  	<a href="/order/Control?mode=return">返回</a>
  	</form>
  	</center>
  </body>
</html>
