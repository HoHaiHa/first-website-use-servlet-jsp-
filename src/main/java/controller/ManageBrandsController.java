package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/managebrands"})
public class ManageBrandsController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageBrands.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String formType = req.getParameter("formType");
		
		if(formType.equals("addNewBrands")) {
			model.BrandsModel c = new model.BrandsModel();
			c.setBrandName(req.getParameter("addNewBrandInput")) ;
			dao.BrandsDao.addNewBrands(c);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageBrands.jsp");
			dispatcher.forward(req, resp);
		}
		if(formType.equals("manageBrandItem")) {
			if(req.getParameter("manage").equals("Xoá")) {
				dao.BrandsDao.removeBrands(req.getParameter("BrandId"));
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageBrands.jsp");
				dispatcher.forward(req, resp);
			}
			if(req.getParameter("manage").equals("Sửa")) {
				model.BrandsModel c = new model.BrandsModel();
				c.setBrandId(Integer.parseInt(req.getParameter("BrandId")));
				c.setBrandName(req.getParameter("updateInput"));
				dao.BrandsDao.updateBrands(c);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageBrands.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
	}

}
