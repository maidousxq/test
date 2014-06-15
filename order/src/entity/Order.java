package entity;

public class Order {
	private String ORDER_ID="";
	private String CLIENT_ID="";
	private String CREATETIME="";
	private String STATUS="";

	public String getCLIENT_ID() {
		return CLIENT_ID;
	}
	public void setCLIENT_ID(String client_id) {
		CLIENT_ID = client_id;
	}
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String createtime) {
		CREATETIME = createtime;
	}
	public String getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(String order_id) {
		ORDER_ID = order_id;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String status) {
		STATUS = status;
	}
}
