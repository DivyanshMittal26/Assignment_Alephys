package in.com.display;

import java.util.List;

import org.hibernate.Session;

import Entity.MonthlySummary;

public class DisplayData {
	    public static void show(Session session) {
	        List<MonthlySummary> list = session.createQuery("from MonthlySummary", MonthlySummary.class).list();
	        if (list.isEmpty()) {
	            System.out.println("No records found.");
	        } else {
	            for (MonthlySummary ms : list) {
	                System.out.println("Type: " + ms.getType());
	                System.out.println("Amount: " + ms.getAmount());
	                System.out.println("Subcategory: " + ms.getSubcategory());
	                System.out.println("Month: " + ms.getMonth());
	                System.out.println("---------------");
	            }
	        }
	    }
}
