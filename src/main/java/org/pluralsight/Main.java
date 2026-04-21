package org.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    static void main() {
        try {

            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String lines = bufferedReader.readLine();

            // skip the first line - and read again
            lines = bufferedReader.readLine();

            while(lines != null)
            {
                // create array to read each column of the .csv file
                String[] columns = lines.split("\\|");
                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                double hoursWorked = Double.parseDouble(columns[2]);
                double payRate = Double.parseDouble(columns[3]);

                // create employee object
                Employee employee = new  Employee(id, name, hoursWorked, payRate);

                // replace employee.getId() == int with whichever employee id in the .csv you want to print
                // too lazy to do a scanner search tbh sorry :3

                if (employee.getId() == 30) {
                    System.out.println(employee.getName() + ", Employee ID #" + employee.getId() + "'s gross pay is $"
                            + employee.getGrossPay());
                }

                // breaks the endless loop
                lines = bufferedReader.readLine();
            }

            // close the file
            bufferedReader.close();

        }

        catch (Exception ex){
            System.out.println("what are you doing!");
        }

    }


}

