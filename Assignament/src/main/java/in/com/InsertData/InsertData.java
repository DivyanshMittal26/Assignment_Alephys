package in.com.InsertData;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.MonthlySummary;

public class InsertData {
	 
	 public static void insert(Session session) {
	        Scanner scn = new Scanner(System.in);
	        MonthlySummary ms = new MonthlySummary();

	        System.out.println("Enter type Income or Expense:");
	        ms.setType(scn.nextLine());

	        System.out.println("Enter amount:");
	        ms.setAmount(scn.nextInt());
	        scn.nextLine();

	        System.out.println("Enter subcategory:");
	        ms.setSubcategory(scn.nextLine());

	        System.out.println("Enter month like:(jan,feb,mar,april,may,june,july,aug,sep,dec)");
	        ms.setMonth(scn.nextLine());

	        Transaction tx = session.beginTransaction();
	        session.save(ms);
	        tx.commit();

	        System.out.println("Data inserted successfully.");
	    }
	 
}
