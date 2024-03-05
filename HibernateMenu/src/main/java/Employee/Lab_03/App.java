package Employee.Lab_03;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        
        int choice;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("____________________________________");
            System.out.println("---Welcome Employee Management System---");
            System.out.println("-------------------------------------");
            System.out.println("Choose an option:");
            System.out.println("1. Insert");
            System.out.println("2. Fetch");
            System.out.println("3. Edit or modify the data");
            System.out.println("4. Delete");
            System.out.println("5. View full table");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
            case 1: // Insert
                Employee e1 = new Employee();
                System.out.println("Enter name:");
                e1.setName(scanner.next());
                System.out.println("Enter salary:");
                e1.setSalary(scanner.nextDouble());
                System.out.println("Enter phone:");
                e1.setPhone(scanner.nextLong());
                System.out.println("Enter address:");
                e1.setAddr(scanner.next());
                session.save(e1);
                tx.commit();
                System.out.println("Information successfully stored...");
                break;
            case 2: // Fetch
                System.out.println("Enter employee ID to fetch:");
                int id = scanner.nextInt();
                Employee fetchedEmployee = session.get(Employee.class, id);
                System.out.println(fetchedEmployee);
                break;
            case 3: // Edit or modify
                System.out.println("Enter employee ID to edit:");
                int idToUpdate = scanner.nextInt();
                Employee employeeToUpdate = session.get(Employee.class, idToUpdate);
                System.out.println("Enter new name:");
                employeeToUpdate.setName(scanner.next());
                System.out.println("Enter new salary:");
                employeeToUpdate.setSalary(scanner.nextDouble());
                System.out.println("Enter new phone:");
                employeeToUpdate.setPhone(scanner.nextLong());
                System.out.println("Enter new address:");
                employeeToUpdate.setAddr(scanner.next());
                session.saveOrUpdate(employeeToUpdate);
                tx.commit();
                System.out.println("Information successfully updated...");
                break;
            case 4: // Delete
                System.out.println("Enter employee ID to delete:");
                int idToDelete = scanner.nextInt();
                Employee employeeToDelete = session.get(Employee.class, idToDelete);
                session.delete(employeeToDelete);
                tx.commit();
                System.out.println("Information successfully deleted...");
                break;
            case 5: // View full table
                @SuppressWarnings("unchecked") List<Employee> employees = session.createQuery("from Employee").list();
                for (Employee emp : employees) {
                    System.out.println(emp);
                }
                break;
            case 0:
                System.out.println("Goodbye! Have a great day!");
                break;
            default:
                System.out.println("Invalid option!");
            }
        } while (choice != 0);

        tx.commit();
        session.close();
        sf.close();
        scanner.close();
    }
}
