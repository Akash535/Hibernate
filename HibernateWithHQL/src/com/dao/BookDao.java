package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bean.Book;

public class BookDao {
	static Configuration cf=new AnnotationConfiguration().configure();
	
	public static int insertBook(Book b) {
		Session s=cf.buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		int i=(int)s.save(b);
		t.commit();
		return i;
	}
	
	public static int updateBook(String bn,float p) {
		Session s=cf.buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("update Book set price=:x where bookName=:y");
		q.setParameter("x", p);
		q.setParameter("y", bn);
		int i=q.executeUpdate();
		t.commit();
		return i;
	}
	
	public static int deleteBook(String bn) {
		Session s=cf.buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("delete from Book where bookName=:a");
		q.setParameter("a", bn);
		int i=q.executeUpdate();
		t.commit();
		return i;		
	}
	
	public static List<Book>fetchBook(){
		Session s=cf.buildSessionFactory().openSession();
		Query q=s.createQuery("from Book");
		return q.list();
	}
	
	public static List<Book> fetchByCriteria(float p){
		Session s=cf.buildSessionFactory().openSession();
		Criteria c=s.createCriteria(Book.class);
		c.add(Restrictions.le("price", p));
		return c.list();
	}
	
	public static List<Book> fetchByOrder(String pn,String order){
		Session s=cf.buildSessionFactory().openSession();
		Criteria c=s.createCriteria(Book.class);
		
		if(order.equalsIgnoreCase("asc"))
			c.addOrder(Order.asc(pn));
		else if(order.equalsIgnoreCase("desc"))
			c.addOrder(Order.desc(pn));
		return c.list();
	}
	
	public static List<Object> fetchByProjection(String pn){
		Session s=cf.buildSessionFactory().openSession();
		Criteria c=s.createCriteria(Book.class);
		c.setProjection(Projections.property(pn));
		return c.list();
	}
}
