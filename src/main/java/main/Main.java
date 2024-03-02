package main;

import java.util.List;
import org.hibernate.Session;
import dao.CategoryDao;
import model.CategoryModel;
import util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		dao.BrandsDao.removeBrands("1");

	}
}
