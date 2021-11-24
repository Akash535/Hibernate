package hibernatedemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ApplicationClass {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the name & precentage :");
			String n=br.readLine();
			String per=br.readLine();
			
			Student s=new Student();
			s.setName(n);
			s.setPer(per);
			
			Configuration cf=new AnnotationConfiguration().configure();
			SessionFactory sf=cf.buildSessionFactory();
			Session session=sf.openSession();
			Transaction t=session.beginTransaction();
			
			int i=(int)session.save(s);
			if(i>0) {
				t.commit();
				System.out.println("Inserted "+i);
			}
			else {
				System.out.println("try Again!!!");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}

}
