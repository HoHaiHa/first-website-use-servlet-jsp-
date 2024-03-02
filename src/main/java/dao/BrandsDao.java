package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import model.BrandsModel;
import util.HibernateUtil;

public class BrandsDao {
	public static void addNewBrands(BrandsModel brand) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					session.persist(brand);
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
	
	public static List<BrandsModel> readBrands() {
	    List<BrandsModel> list = new ArrayList<>();
	    Transaction transaction = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        String hql = "FROM brands ORDER BY brandName ASC";
	        Query query = session.createQuery(hql,BrandsModel.class);
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
	
	public static void removeBrands(String brandId) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        transaction = session.beginTransaction();
	        
	        BrandsModel c = session.get(BrandsModel.class, brandId);
	        if (c != null) {
	            String hql = "DELETE FROM brands WHERE brandId = :brandId";
	            Query<BrandsModel> query = session.createQuery(hql);
	            query.setParameter("brandId", brandId);
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
	
	public static void updateBrands(BrandsModel c) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        transaction = session.beginTransaction();       
	        String hql = "UPDATE brands SET brandName = :brandName WHERE brandId = :brandId";
	        Query<BrandsModel> query = session.createQuery(hql);
	        query.setParameter("brandName", c.getBrandName());
	        query.setParameter("brandId", c.getBrandId());
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
	

