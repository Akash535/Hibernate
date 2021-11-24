package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class ApplicationClass {

	public static void main(String[] args) {
		try {
			Session s=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Count of Authors:");
			int ac=Integer.parseInt(br.readLine());
			
			for(int i=0;i<ac;i++) {
				Transaction t=s.beginTransaction();
				System.out.println("Enter AuthorName & Age:");
				String an=br.readLine();
				int a=Integer.parseInt(br.readLine());
				
				List<String> l=new ArrayList<>();
				System.out.println("Enter count of books:");
				int bn=Integer.parseInt(br.readLine());
				
				System.out.println("Enter list of books:");
				for(int j=0;j<bn;j++)
					l.add(br.readLine());
				
				Author au=new Author();
				au.setAname(an);
				au.setAge(a);
				au.setBooks(l);
				
				s.save(au);
				t.commit();
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
