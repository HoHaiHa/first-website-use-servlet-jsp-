package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/managecategory"})
public class ManageCategoryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageCategory.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String formType = req.getParameter("formType");
		
		if(formType.equals("addNewCategory")) {
			model.CategoryModel c = new model.CategoryModel();
			c.setCateName(req.getParameter("addNewCateInput")) ;
			dao.CategoryDao.addNewCategory(c);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageCategory.jsp");
			dispatcher.forward(req, resp);
		}
		if(formType.equals("manageCateItem")) {
			if(req.getParameter("manage").equals("Xoá")) {
				dao.CategoryDao.removeCategory(req.getParameter("cateId"));
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageCategory.jsp");
				dispatcher.forward(req, resp);
			}
			if(req.getParameter("manage").equals("Sửa")) {
				model.CategoryModel c = new model.CategoryModel();
				c.setCateId(Integer.parseInt(req.getParameter("cateId")));
				c.setCateName(req.getParameter("updateInput"));
				dao.CategoryDao.updateCategory(c);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/manageCategory.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
	}

}
