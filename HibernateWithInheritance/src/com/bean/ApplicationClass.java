package com.bean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ApplicationClass {

	public static void main(String[] args) {
		try {
			Session s=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Transaction t=s.beginTransaction();
			
			Employee e=new Employee(1, "Akash");
			PartTimeEmp p=new PartTimeEmp(2, "Sachin", 20, 4120);
			FullTimeEmp f=new FullTimeEmp(3, "Omkar", 28000, 20,400);
			
			s.save(e);
			s.save(p);
			s.save(f);
			
			t.commit();
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
