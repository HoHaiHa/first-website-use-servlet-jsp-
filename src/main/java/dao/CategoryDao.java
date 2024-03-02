package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import model.CategoryModel;
import util.HibernateUtil;

public class CategoryDao {
	public static void addNewCategory(CategoryModel cate) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					session.persist(cate);
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
	
	public static List<CategoryModel> readCategory() {
	    List<CategoryModel> list = new ArrayList<>();
	    Transaction transaction = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        String hql = "FROM category ORDER BY cateName ASC";
	        Query query = session.createQuery(hql,CategoryModel.class);
	        list = query.list();
	        transaction.commit();
	    } catch (HibernateException e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public static void removeCategory(String cateId) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        transaction = session.beginTransaction();
	        
	        CategoryModel c = session.get(CategoryModel.class, cateId);
	        if (c != null) {
	            String hql = "DELETE FROM category WHERE cateId = :cateId";
	            Query<CategoryModel> query = session.createQuery(hql);
	            query.setParameter("cateId", c.getCateId());
	            int result = query.executeUpdate();    
	            System.out.println("Rows affected: " + result);
	        }
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	
	public static void updateCategory(CategoryModel c) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        transaction = session.beginTransaction();       
	        String hql = "UPDATE category SET cateName = :cateName WHERE cateId = :cateId";
	        Query<CategoryModel> query = session.createQuery(hql);
	        query.setParameter("cateName", c.getCateName());
	        query.setParameter("cateId", c.getCateId());
	        int result = query.executeUpdate();
	        System.out.println("Rows affected: " + result); 
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
	

