package CSVFile;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.MonthlySummary;

public class ReadFromCsv {
	public static void readAndInsert(Session session, String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine(); // Skip header line

            System.out.println("Reading and inserting data from CSV:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 4) {
                    System.out.println("Invalid line (skipped): " + line);
                    continue;
                }

                MonthlySummary ms = new MonthlySummary();
                ms.setType(data[0].trim());
                ms.setAmount(Integer.parseInt(data[1].trim()));
                ms.setSubcategory(data[2].trim());
                ms.setMonth(data[3].trim());

                // Insert into DB
                Transaction tx = session.beginTransaction();
                session.save(ms);
                tx.commit();

                // Print to console
                System.out.println("Inserted: " + data[0] + " | " + data[1] + " | " + data[2] + " | " + data[3]);
            }

            System.out.println("CSV data imported and displayed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
