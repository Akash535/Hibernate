package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ApplicationClass {

	public static void main(String[] args) {
		try {
			Session s=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter No of Teams:");
			int tn=Integer.parseInt(br.readLine());
			for(int i=0;i<tn;i++) {
				Transaction t=s.beginTransaction();
				
				System.out.println("Enter CountryName & CoachName:");
				String cn=br.readLine();
				String co=br.readLine();
				
				Set<Player> set=new HashSet<>();
				System.out.println("Enter no of Players:");
				int pn=Integer.parseInt(br.readLine());
				for(int j=0;j<pn;j++) {
					System.out.println("Enter jno,PlayerName & StrickRate:");
					
					Player p=new Player();
					p.setJno(Integer.parseInt(br.readLine()));
					p.setpName(br.readLine());
					p.setStrickRate(Integer.parseInt(br.readLine()));
					
					set.add(p);
				}
				CricketTeam ct=new CricketTeam();
				ct.setCountryName(cn);
				ct.setCoachName(co);
				ct.setPlayers(set);
				
				s.save(ct);
				t.commit();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
