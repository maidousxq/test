<%@ page language="java" pageEncoding="GBK"%>
<html>
  <head>
  </head>
  <body>
  	<center>
  	<form action="/order/Control">
  		<input type="hidden" name="mode" value="showadd"/>
  		<input type="submit" value="添加订单详情信息"/>
  	</form><br><br>
  	<form action="/order/Control">
  		订单号:<input type="text" name="id" maxlength="5"/><br>
  		<input type="hidden" name="mode" value="query"/>
  		<input type="submit" value="查询订单明细信息"/>
  	</form>
  	</center>
  </body>
</html>
