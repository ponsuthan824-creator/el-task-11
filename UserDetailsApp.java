import java.io.*;
import java.util.Scanner;

public class UserDetailsApp {

    // File name where data will be stored
    static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Create file if it does not exist
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created successfully.");
            }

            // Take user input
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            // Write data to file (append mode = true)
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Email: " + email);
            bw.newLine();
            bw.write("Phone: " + phone);
            bw.newLine();
            bw.write("---------------------------");
            bw.newLine();

            // Close writers
            bw.close();
            fw.close();

            System.out.println("\nData saved successfully!\n");

            // Read data from file
            System.out.println("Stored User Details:");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close readers
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("An error occurred while handling the file.");
            e.printStackTrace();
        }

        sc.close();
    }
}