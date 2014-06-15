package session;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.OrdDetail;
import entity.Order;

public class Session extends Data {

	private Statement stm=null;
	private CallableStatement callstm=null;
	private ResultSet rls=null;

	public ArrayList queryOrdDetail(String id){
		ArrayList list=new ArrayList();
		OrdDetail detail=null;
		String sql="select d.* from t_order_detail d,t_order o where d.order_id=o.order_id and o.order_id='"+id+"'";
		try {
			this.stm=super.getConn().createStatement();
			this.rls=this.stm.executeQuery(sql);
			while(rls.next()){
				detail=new OrdDetail();
				detail.setORDER_DETAIL_ID(rls.getString("ORDER_DETAIL_ID"));
				detail.setORDER_ID(rls.getString("ORDER_ID"));
				detail.setPRODUCT_ID(rls.getString("PRODUCT_ID"));
				detail.setQUANTITY(rls.getString("QUANTITY"));
				list.add(detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.rls.close();
				this.stm.close();
				super.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList queryOrder(){
		ArrayList list=new ArrayList();
		Order order=null;
		String sql="select order_id,client_id,createtime,status from t_order";
		try {
			this.stm=super.getConn().createStatement();
			this.rls=this.stm.executeQuery(sql);
			while(rls.next()){
				order=new Order();
				order.setORDER_ID(rls.getString("ORDER_ID"));
				order.setCLIENT_ID(rls.getString("CLIENT_ID"));
				order.setCREATETIME(rls.getString("CREATETIME"));
				switch(rls.getInt("STATUS")){
				case 1:
					order.setSTATUS("订单刚提交但未汇款");break;
				case 2:
					order.setSTATUS("收到汇款");break;
				case 3:
					order.setSTATUS("已发货");break;
				default:break;
				}
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.rls.close();
				this.stm.close();
				super.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addOrdDetail(OrdDetail d){
		try {
			this.callstm=super.getConn().prepareCall("{call up_detail(?,?,?)}");
			this.callstm.setString(1, d.getORDER_ID());
			this.callstm.setString(2, d.getPRODUCT_ID());
			this.callstm.setInt(3, Integer.parseInt(d.getQUANTITY()));
			this.callstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.callstm.close();
				super.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}