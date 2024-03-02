package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.ProductModel;

import util.HibernateUtil;

public class ProductDao {
	public static void addNewProduct(ProductModel pro) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					session.persist(pro);				
					tx.commit();
				} catch (HibernateException e) {
					if (tx!=null) tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<ProductModel> readProduct() {
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			List<ProductModel> list = new ArrayList<>();
			if(sessionFactory != null) {				
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					String hql = "FROM product";
					Query query = session.createQuery(hql,ProductModel.class);
					list = query.list();
					tx.commit();
				} catch (HibernateException e) {
					if (tx!=null) tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
				return list;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<ProductModel> readProduct(String dropdownItem) {
			
		try {
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			List<ProductModel> list = new ArrayList<>();
			if(sessionFactory != null) {				
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					String hql="";
					switch (dropdownItem) {
						case "Tên tăng":
							hql = "FROM product ORDER BY proName ASC";
							break;
						case "Tên giảm":
							hql = "FROM product ORDER BY proName DESC";
							break;
						case "Số lượng tăng":
							hql = "FROM product ORDER BY quantity ASC";
							break;
						case "Số lượng giảm":
							hql = "FROM product ORDER BY quantity DESC";
							break;
						case "Ngày thêm tăng":
							hql = "FROM product ORDER BY proId ASC";
							break;
						case "Ngày thêm giảm":
							hql = "FROM product ORDER BY proId DESC";
							break;
						case "Giá tăng":
							hql = "FROM product ORDER BY price ASC";
							break;
						case "Giá giảm":
							hql = "FROM product ORDER BY price DESC";
							break;
						case "Giảm giá tăng":
							hql = "FROM product ORDER BY discounts ASC";
							break;
						case "Giảm giá giảm":
							hql = "FROM product ORDER BY discounts DESC";
							break;					
					}
					Query query = session.createQuery(hql,ProductModel.class);
					list = query.list();
					tx.commit();
				} catch (HibernateException e) {
					if (tx!=null) tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
				return list;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
