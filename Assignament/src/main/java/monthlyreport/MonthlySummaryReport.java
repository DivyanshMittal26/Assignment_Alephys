package monthlyreport;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import Entity.MonthlySummary;

public class MonthlySummaryReport {
	public static void showSummary(Session session) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month to summarize (jan,feb,mar,april,may,june,july,aug,sep,dec): ");
        String month = sc.nextLine();

        List<MonthlySummary> list = session.createQuery(
            "FROM MonthlySummary WHERE month = :month", MonthlySummary.class)
            .setParameter("month", month).getResultList();

        int incomeTotal = 0;
        int expenseTotal = 0;

        for (MonthlySummary ms : list) {
            if ("income".equalsIgnoreCase(ms.getType()))
                incomeTotal += ms.getAmount();
            else if ("expense".equalsIgnoreCase(ms.getType()))
                expenseTotal += ms.getAmount();
        }

        System.out.println("===== Monthly Summary for " + month + " =====");
        System.out.println("Total Income : " + incomeTotal);
        System.out.println("Total Expense: " + expenseTotal);
        System.out.println("Net Balance  : " + (incomeTotal - expenseTotal));
    }
}
