import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.bean.Book;
import com.dao.BookDao;

public class ApplicationClass {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int i,bid,ch;
			String bn,an;
			float p;
			Book b;
			List<Book> l;
			do {
				System.out.println("1:Insert\n2:Update\n3:Delete\n4:Fetch\n5:Exit\n6:Fetch by Criteria\n7:Fetch by Order\n8:Fetch by Projection");
				System.out.println("Enter the Choice");
				ch=Integer.parseInt(br.readLine());
				String pn;
				String o;
				switch(ch) {
				case 1:
					System.out.println("Enter book name, author & price:");
					b=new Book();
					b.setBookName(br.readLine());
					b.setAuthorName(br.readLine());
					b.setPrice(Float.parseFloat(br.readLine()));
					i=BookDao.insertBook(b);
					if(i>0) 
						System.out.println("Inserted");
					else
						System.out.println("Try Again");
					break;
					
				case 2:
					System.out.println("Enter bookName and updated price:");
					bn=br.readLine();
					p=Float.parseFloat(br.readLine());
					i=BookDao.updateBook(bn, p);
					if(i>0)
						System.out.println("Updated");
					else
						System.out.println("Try again");
					break;
					
				case 3:
					System.out.println("Enter bookName:");
					bn=br.readLine();
					
					i=BookDao.deleteBook(bn);
					if(i>0) 
						System.out.println("Deleted");
					else
						System.out.println("Try again");
					break;
					
				case 4:
					l=BookDao.fetchBook();
					for(Book obj:l)
						System.out.println(obj);
					break;
					
				case 5:
					System.out.println("Thanks for using Application");
					System.exit(0);
					
				case 6:
					System.out.println("Enter price to apply less than criteria:");
					p=Float.parseFloat(br.readLine());
					l=BookDao.fetchByCriteria(p);
					for(Book obj:l)
						System.out.println(obj);
					break;
					
				case 7:
					System.out.println("Enter the property name,order to fetch record :");
					pn=br.readLine();
					o=br.readLine();
					l=BookDao.fetchByOrder(pn, o);
					for(Book obj:l)
						System.out.println(obj);
					break;
					
				case 8:
					System.out.println("Enter the property name,order to fetch record :");
					pn=br.readLine();
					List<Object>l1=BookDao.fetchByProjection(pn);
					for(Object obj:l1)
						System.out.println(obj);
					break;
					
				default :
					System.out.println("please Enter valid choice");
				}
			}while(true);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
