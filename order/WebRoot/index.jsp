<%@ page language="java" pageEncoding="GBK"%>
<html>
  <head>
  </head>
  <body>
  	<center>
  	<form action="/order/Control">
  		<input type="hidden" name="mode" value="showadd"/>
  		<input type="submit" value="��Ӷ���������Ϣ"/>
  	</form><br><br>
  	<form action="/order/Control">
  		������:<input type="text" name="id" maxlength="5"/><br>
  		<input type="hidden" name="mode" value="query"/>
  		<input type="submit" value="��ѯ������ϸ��Ϣ"/>
  	</form>
  	</center>
  </body>
</html>
