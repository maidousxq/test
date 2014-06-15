package entity;

public class OrdDetail {
	
	private String ORDER_DETAIL_ID="";
	private String ORDER_ID="";
	private String PRODUCT_ID="";
	private String QUANTITY="";

	public String getORDER_DETAIL_ID() {
		return ORDER_DETAIL_ID;
	}
	public void setORDER_DETAIL_ID(String order_detail_id) {
		ORDER_DETAIL_ID = order_detail_id;
	}
	public String getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(String order_id) {
		ORDER_ID = order_id;
	}
	public String getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(String product_id) {
		PRODUCT_ID = product_id;
	}
	public String getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(String quantity) {
		QUANTITY = quantity;
	}
}
