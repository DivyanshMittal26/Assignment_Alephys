package in.sp.main;import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import CSVFile.ReadFromCsv;
import in.com.InsertData.InsertData;
import in.com.display.DisplayData;
import monthlyreport.MonthlySummaryReport;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure("configuration/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert Record");
            System.out.println("2. Read From CSV");
            System.out.println("3. Show Monthly Summary");
            System.out.println("4. Show Data In DataBase");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (ch) {
                case 1:
                    InsertData.insert(session);
                    break;
                case 2:
                    System.out.print("Enter CSV file path: ");
                    String path = sc.nextLine();
                    ReadFromCsv.readAndInsert(session, path);
                    break;
                case 3:
                    MonthlySummaryReport.showSummary(session);
                    break;
                case 4:
                	 DisplayData.show(session);
                     break;
                case 5:
                    session.close();
                    factory.close();
                    System.exit(0);
            }
        }
        
    }
}
