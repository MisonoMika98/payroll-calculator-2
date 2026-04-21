package org.pluralsight;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


    static void main() {

        // calls the variables to assign null in order to close the file at the end
        BufferedReader bufferedReader = null;
        PrintStream printer = null;

        Scanner userInput = new Scanner(System.in);

        // stores the user's input/file name
        System.out.print("Enter the name of the file employee file to process: ");
        String fileName = userInput.nextLine().toLowerCase().trim();

        System.out.print("Enter the name of the [payroll] file to create: ");
        String fileNameChosen = userInput.nextLine().toLowerCase().trim();

        try {
            // variables to read the file, NOTE: fileName string in FileReader()
            // instead of hardcoding an actual file name to let user input

            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);


            // variables to write the file, NOTE: fileNameChosen string in FileOutputStream()
            // instead of hardcoding the file name you chose beforehand, lets you input one

            FileOutputStream fileOutputStream = new FileOutputStream(fileNameChosen);
            printer = new PrintStream(fileOutputStream);

            // redundant? probably
            String lines = bufferedReader.readLine();

            // skip the first line/original header - and reads again
            lines = bufferedReader.readLine();

            // new header for the file, since the original header is skipped to help the array work
            printer.printf("%-10s %-25s %-15s%n", "ID", "Name", "Gross Pay");
            printer.printf("%-10s %-25s %-15s%n", "----------", "-------------------------", "---------------");

            // while loop that reads the entire file
            while(lines != null)
            {
                // create array to read each column of the .csv file
                String[] columns = lines.split("\\|");
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                double hoursWorked = Double.parseDouble(columns[2]);
                double payRate = Double.parseDouble(columns[3]);

                // create employee object
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                // prints to file
                if(fileName.equals("employees.csv")) {
                    printer.printf("%-10s %-25s %-15.2f%n", employee.getId(), employee.getName(),
                            employee.getGrossPay());
                }


                // breaks the endless loop
                lines = bufferedReader.readLine();
            }

        }
        // catches any errors when inputting filename, in this case it HAS to be employees.csv
        catch (Exception ex)
        {
            System.out.println("What are you doing!");
            System.out.println(ex.getMessage());
        }

        // runs no matter what
        finally
        {
            // 3) closes the file
            try
            {
                if(bufferedReader != null) bufferedReader.close();
                if(printer != null) printer.close();
            }

            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        // might not be needed? everything else closes so might as well
        userInput.close();
    }

}

