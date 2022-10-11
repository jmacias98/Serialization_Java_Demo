// Jesus Macias
// This program demonstrates serialization and deserialization.
// This program provides a menu to the user and from there, are able to select
// different options from adding data to a file, removing the data,
// updating data, and displaying data.
// Selection 5 exits the program.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInfo implements Serializable{
    String firstName;
    String phoneNumber;
    String DOB;
    String email;

    public String displayResults() {
        return "Personal Info [First Name= " + firstName + ", Phone Number= " + phoneNumber + ", DOB= " + DOB + ", Email= " + email + "]";
    }

    public static void main(String[] args) throws Exception {
        int choice; // variable for choice 
        int rowChoice;
        int rowChoice2;
        Scanner scanner = new Scanner(System.in); // input
        PersonalInfo entry = new PersonalInfo(); // initialize 
        ArrayList<String> personalInfo = new ArrayList<String>(); // array to save user input 

        loop : while(true)
        {
            System.out.println("\t MENU");
            System.out.println("1) Add Info to File");
            System.out.println("2) Retrieve Info from File and Display it");
            System.out.println("3) Delete Info");
            System.out.println("4) Update Info");
            System.out.println("5) Exit");
            System.out.print("Make a selection: ");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    loop2 : while(true){
                        String another;
                        System.out.println("\nEnter Information.");
                        System.out.print("Enter First Name: ");
                        entry.firstName = scanner.next();
                        System.out.print("Enter Phone Number: ");
                        entry.phoneNumber = scanner.next();
                        System.out.print("Enter DOB: ");
                        entry.DOB = scanner.next();
                        System.out.print("Enter Email: ");
                        entry.email = scanner.next();
                        personalInfo.add(entry.displayResults());
                        System.out.print("Make Another Entry?(true/false): ");
                        another = scanner.next();
                        if(another.equals("false") || another.equals("False")){
                            break loop2;
                        }
                    }
                    try{
                        FileOutputStream fileOutput = new FileOutputStream("Serialized_Text.txt");
                        ObjectOutputStream writeStream = new ObjectOutputStream(fileOutput);

                        writeStream.writeObject(personalInfo);
                        writeStream.flush();
                        writeStream.close();

                    }catch(IOException i){
                        i.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("\nReading Data From File...");
                    try{
                        FileInputStream readData = new FileInputStream("Serialized_Text.txt");
                        ObjectInputStream readStream = new ObjectInputStream(readData);
                        
                        personalInfo = (ArrayList) readStream.readObject();
                        readStream.close();
                        readData.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    for (String name : personalInfo) {
                        System.out.println(name);
                    }
                    break;

                case 3:
                    try{
                        FileInputStream readData = new FileInputStream("Serialized_Text.txt");
                        ObjectInputStream readStream = new ObjectInputStream(readData);
                        
                        personalInfo = (ArrayList) readStream.readObject();
                        readStream.close();
                        readData.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    for (String name : personalInfo) {
                        System.out.println(personalInfo.indexOf(name)+" "+name);
                    }
                    System.out.print("\nSelect Row of Data to Delete: ");
                    rowChoice2 = scanner.nextInt();
                    personalInfo.remove(rowChoice2);
                    System.out.println("Row " + rowChoice2 + " Deleted.");
                    try{
                        FileOutputStream fileOutput = new FileOutputStream("Serialized_Text.txt");
                        ObjectOutputStream writeStream = new ObjectOutputStream(fileOutput);

                        writeStream.writeObject(personalInfo);
                        writeStream.flush();
                        writeStream.close();

                    }catch(IOException i){
                        i.printStackTrace();
                    }
                    break;

                case 4:
                    try{
                        FileInputStream readData = new FileInputStream("Serialized_Text.txt");
                        ObjectInputStream readStream = new ObjectInputStream(readData);
                        
                        personalInfo = (ArrayList) readStream.readObject();
                        readStream.close();
                        readData.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    for (String name : personalInfo) {
                        System.out.println(personalInfo.indexOf(name)+" "+name);
                    }
                    System.out.print("\nSelect Row of Data to Update: ");
                    rowChoice = scanner.nextInt();
                    System.out.println("\nEnter New Data.");
                    System.out.print("Enter First Name: ");
                    entry.firstName = scanner.next();
                    System.out.print("Enter Phone Number: ");
                    entry.phoneNumber = scanner.next();
                    System.out.print("Enter DOB: ");
                    entry.DOB = scanner.next();
                    System.out.print("Enter Email: ");
                    entry.email = scanner.next();
                    System.out.println("Row "+ rowChoice + " updated.");

                    personalInfo.set(rowChoice, entry.displayResults());
                    try{
                        FileOutputStream fileOutput = new FileOutputStream("Serialized_Text.txt");
                        ObjectOutputStream writeStream = new ObjectOutputStream(fileOutput);

                        writeStream.writeObject(personalInfo);
                        writeStream.flush();
                        writeStream.close();

                    }catch(IOException i){
                        i.printStackTrace();
                    }
                    break;
                    
                case 5:
                    scanner.close();
                    break loop;

                default:
                    System.out.println("\nERROR! Invalid Selection.");
                    break;
            }
        }
    }
}
**************************************************************************
//  SAMPLE OUTPUT: 
// MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 1

// Enter Information.
// Enter First Name: Jesus
// Enter Phone Number: 630-999-2928
// Enter DOB: 8/12/1988
// Enter Email: jlewis@gmail.com
// Make Another Entry?(true/false): true

// Enter Information.
// Enter First Name: Alex
// Enter Phone Number: 299-292-1912
// Enter DOB: 9/14/1977
// Enter Email: hello@yahoo.com
// Make Another Entry?(true/false): true

// Enter Information.
// Enter First Name: Felix
// Enter Phone Number: 299-112-8912
// Enter DOB: 8/3/1950
// Enter Email: bye@aol.com
// Make Another Entry?(true/false): true

// Enter Information.
// Enter First Name: Albert
// Enter Phone Number: 111-111-1111
// Enter DOB: 1/1/1911
// Enter Email: 11111only@lewis.edu
// Make Another Entry?(true/false): true

// Enter Information.
// Enter First Name: John
// Enter Phone Number: 291-232
// Enter DOB: 00/00/0000
// Enter Email: XXXXXXXX
// Make Another Entry?(true/false): false
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// Personal Info [First Name= Jesus, Phone Number= 630-999-2928, DOB= 8/12/1988, Email= jlewis@gmail.com]
// Personal Info [First Name= Alex, Phone Number= 299-292-1912, DOB= 9/14/1977, Email= hello@yahoo.com]
// Personal Info [First Name= Felix, Phone Number= 299-112-8912, DOB= 8/3/1950, Email= bye@aol.com]
// Personal Info [First Name= Albert, Phone Number= 111-111-1111, DOB= 1/1/1911, Email= 11111only@lewis.edu]
// Personal Info [First Name= John, Phone Number= 291-232, DOB= 00/00/0000, Email= XXXXXXXX]
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 4
// 0 Personal Info [First Name= Jesus, Phone Number= 630-999-2928, DOB= 8/12/1988, Email= jlewis@gmail.com]
// 1 Personal Info [First Name= Alex, Phone Number= 299-292-1912, DOB= 9/14/1977, Email= hello@yahoo.com]
// 2 Personal Info [First Name= Felix, Phone Number= 299-112-8912, DOB= 8/3/1950, Email= bye@aol.com]
// 3 Personal Info [First Name= Albert, Phone Number= 111-111-1111, DOB= 1/1/1911, Email= 11111only@lewis.edu]
// 4 Personal Info [First Name= John, Phone Number= 291-232, DOB= 00/00/0000, Email= XXXXXXXX]

// Select Row of Data to Update: 4

// Enter New Data.
// Enter First Name: Elizabeth
// Enter Phone Number: 981-929-1883
// Enter DOB: 12/24/2021
// Enter Email: updated@outlook.com
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 2

// Reading Data From File...
// Personal Info [First Name= Jesus, Phone Number= 630-999-2928, DOB= 8/12/1988, Email= jlewis@gmail.com]
// Personal Info [First Name= Alex, Phone Number= 299-292-1912, DOB= 9/14/1977, Email= hello@yahoo.com]
// Personal Info [First Name= Felix, Phone Number= 299-112-8912, DOB= 8/3/1950, Email= bye@aol.com]
// Personal Info [First Name= Albert, Phone Number= 111-111-1111, DOB= 1/1/1911, Email= 11111only@lewis.edu]
// Personal Info [First Name= Elizabeth, Phone Number= 981-929-1883, DOB= 12/24/2021, Email= updated@outlook.com]
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 3
// 0 Personal Info [First Name= Jesus, Phone Number= 630-999-2928, DOB= 8/12/1988, Email= jlewis@gmail.com]
// 1 Personal Info [First Name= Alex, Phone Number= 299-292-1912, DOB= 9/14/1977, Email= hello@yahoo.com]
// 2 Personal Info [First Name= Felix, Phone Number= 299-112-8912, DOB= 8/3/1950, Email= bye@aol.com]
// 3 Personal Info [First Name= Albert, Phone Number= 111-111-1111, DOB= 1/1/1911, Email= 11111only@lewis.edu]
// 4 Personal Info [First Name= Elizabeth, Phone Number= 981-929-1883, DOB= 12/24/2021, Email= updated@outlook.com]

// Select Row of Data to Delete: 1
// Row 1 Deleted.
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 2

// Reading Data From File...
// Personal Info [First Name= Jesus, Phone Number= 630-999-2928, DOB= 8/12/1988, Email= jlewis@gmail.com]
// Personal Info [First Name= Felix, Phone Number= 299-112-8912, DOB= 8/3/1950, Email= bye@aol.com]
// Personal Info [First Name= Albert, Phone Number= 111-111-1111, DOB= 1/1/1911, Email= 11111only@lewis.edu]
// Personal Info [First Name= Elizabeth, Phone Number= 981-929-1883, DOB= 12/24/2021, Email= updated@outlook.com]
//          MENU
// 1) Add Info to File
// 2) Retrieve Info from File and Display it
// 3) Delete Info
// 4) Update Info
// 5) Exit
// Make a selection: 5
