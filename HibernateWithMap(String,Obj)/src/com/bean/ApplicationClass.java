package com.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ApplicationClass {

	public static void main(String[] args) {
		try {
			Session s=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter No of Teams:");
			int tc=Integer.parseInt(br.readLine());
			for(int i=0;i<tc;i++) {
				Transaction t=s.beginTransaction();
				
				System.out.println("Enter TeamName & OwnerName:");
				String tn=br.readLine();
				String on=br.readLine();
				
				Map<String, Player> map=new HashMap<>();
				System.out.println("Enter no of players:");
				int pn=Integer.parseInt(br.readLine());
				for(int j=0;j<pn;j++) {
					System.out.println("Enter jno,PlayerName, StrickRate & CountryName:");
					
					Player p=new Player();
					p.setJno(Integer.parseInt(br.readLine()));
					p.setpName(br.readLine());
					p.setStrickRate(Integer.parseInt(br.readLine()));
					String cn=br.readLine();
					
					map.put(cn, p);
				}
				IPLTeam ipl=new IPLTeam();
				ipl.setOwnerName(on);
				ipl.setPlayers(map);
				ipl.setTeamName(tn);
				
				s.save(ipl);
				t.commit();
			}
		}
			catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
