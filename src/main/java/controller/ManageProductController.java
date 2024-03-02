package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.ProductModel;

@WebServlet(urlPatterns = {"/admin/manageproduct"})
public class ManageProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5084431290696665134L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		java.util.List<model.ProductModel> list = dao.ProductDao.readProduct();
		req.setAttribute("productList", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageProduct.jsp");
		dispatcher.forward(req, resp);	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String formType = req.getParameter("formType");
		if("sortedBy".equals(formType)) {
			String dropdownItem = req.getParameter("dropdownItem");
			java.util.List<model.ProductModel> list = dao.ProductDao.readProduct(dropdownItem);
			req.setAttribute("productList", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageProduct.jsp");
			dispatcher.forward(req, resp);	
		}
		if("addNewProduct".equals(formType)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/addNewProduct.jsp");
			dispatcher.forward(req, resp);
		}
		if("addNewProductForm".equals(formType)) {
			if("Huỷ".equals(req.getParameter("submitAdd"))) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageProduct.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				model.ProductModel  pro = new model.ProductModel();
				pro.setProName(req.getParameter("proName"));
				
			}
		}
		
	}
	
		
}
