<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.OrdDetail" %>
<%@ page import="entity.Order" %>
<%
ArrayList order=(ArrayList)(request.getAttribute("order")==null?"":request.getAttribute("order"));
ArrayList detail=(ArrayList)(request.getAttribute("detail")==null?"":request.getAttribute("detail"));
%>
<html>
  <head>
  </head>
  <body>
  	<center>
  	<table border>
  		<tr>
  			<td>������ϸ���</td>
  			<td>������</td>
  			<td>�ͻ����</td>
  			<td>��������ʱ��</td>
  			<td>����״̬</td>
  			<td>��Ʒ���</td>
  			<td>��������</td>
  		</tr>
  		<%
  		if(!order.equals("")&&!detail.equals("")){
  			for(int i=0; i<detail.size(); ++i){
  				OrdDetail d=(OrdDetail)detail.get(i);
  		%>
  		<tr>
  			<td><%=d.getORDER_DETAIL_ID()%></td>
  			<td><%=d.getORDER_ID()%></td>
  			<td>
  			<%
  			for(int j=0; j<order.size(); ++j){
  				Order o=(Order)order.get(j);
  				if(o.getORDER_ID().equals(d.getORDER_ID())){
  			%>
  			<%=o.getCLIENT_ID()%>
  			<%break;}}%>
  			</td>
  			<td>
  			<%
  			for(int k=0; k<order.size(); ++k){
  				Order o=(Order)order.get(k);
  				if(o.getORDER_ID().equals(d.getORDER_ID())){
  			%>
  			<%=o.getCREATETIME().substring(0,10)%>
  			<%break;}}%>
  			</td>
  			<td>
  			<%
  			for(int l=0; l<order.size(); ++l){
  				Order o=(Order)order.get(l);
  				if(o.getORDER_ID().equals(d.getORDER_ID())){
  			%>
  			<%=o.getSTATUS()%>
  			<%break;}}%>
  			</td>
  			<td><%=d.getPRODUCT_ID()%></td>
  			<td><%=d.getQUANTITY()%></td>
  		</tr>
  		<%}}%>
  	</table>
  	<a href="/order/Control?mode=return">����</a>
  	</center>
  </body>
</html>
