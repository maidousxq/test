package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.OrdDetail;

import session.Session;

public class Control extends HttpServlet {

	private static final long serialVersionUID = -5617800049360063613L;

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode=request.getParameter("mode");
		String id=request.getParameter("id");

		if(mode.equals("showadd")){
			request.setAttribute("order", new Session().queryOrder());
			request.getRequestDispatcher("adddetail.jsp").forward(request, response);
		}
		if(mode.equals("query")){
			request.setAttribute("order", new Session().queryOrder());
			request.setAttribute("detail", new Session().queryOrdDetail(id));
			request.getRequestDispatcher("dispdetail.jsp").forward(request, response);
		}
		if(mode.equals("add")){
			OrdDetail detail=new OrdDetail();
			detail.setORDER_ID(request.getParameter("ORDER_ID"));
			detail.setPRODUCT_ID(request.getParameter("PRODUCT_ID"));
			detail.setQUANTITY(request.getParameter("QUANTITY"));
			new Session().addOrdDetail(detail);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(mode.equals("return")){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
	}
}