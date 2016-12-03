// Brett Stevenson
// Email: therealbrettstevenson@gmail.com
// Account: bstevens
// Assignment #5: Hash Table
// Date Modified: 03/23/2016
// p5.java (v1.4)
/* This class contains the main() method of the Hash Table implementation that is primarily
   responsible for handling the various commands by which the user is able to manipulate the
   Hash Table. */
// Status: working/tested
//


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class p5 {

    public static void main(String[] args) {
        hashTable table = new hashTable(178000);
        System.out.println("1)File 2)Rec 3)Delete 4)Search 5)Clear 6)Save 7)Quit");
        int command = 0;
        while(command != 7) {
            System.out.print("What would you like to do? ");
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextInt()) {
                command = scan.nextInt();
                if (command == 1) {  // Insert from File
                    System.out.print("Filename: ");
                    if(scan.hasNext()) {
                        String filename = scan.next();
                        try {
                            Scanner file = new Scanner(new File(filename));
                            while(file.hasNextInt()) {
                                Record rec = new Entry(file.nextInt(), file.nextLine());
                                table.insert(rec);
                            }
                            file.close();
                            System.out.println("Your data has been inserted");
                        } catch (FileNotFoundException e) {
                            System.err.println("**ERROR**: The file \"" + filename + "\" was not found");
                        }
                    }

                } else if (command == 2) {  // Insert
                    System.out.print("Insert: ");
                    if (scan.hasNextInt()) {
                        Record rec = new Entry(scan.nextInt(), scan.nextLine());
                        table.insert(rec);
                        System.out.println("Your data has been inserted");
                    }
                } else if (command == 3) {  // Delete
                    System.out.print("Delete: ");
                    if (scan.hasNextInt()) {
                        table.delete(scan.nextInt());

                    }

                } else if (command == 4) {  // Search
                    System.out.print("Search: ");
                    if (scan.hasNextInt()) {
                        int key = scan.nextInt();
                        if(table.search(key) != null)  // null check
                            System.out.println(table.search(key));
                    }

                } else if (command == 5) {  // Clear
                    table.clear();
                    System.out.println("The hash table has been cleared");

                } else if (command == 6) {  // Save to TXT File
                    System.out.print("Filename: ");
                    if(scan.hasNext()) {
                        try {
                            String filename = scan.next();
                            if (!filename.contains("."))
                                filename = filename + ".txt";
                            File output = new File(filename);
                            if (output.exists()) {
                                System.out.print("The file \"" + filename + "\" already exists.");
                                System.out.println("Would you like to overwrite it? (y/n) ");
                                if (scan.hasNext() && scan.next().equals("n"))
                                    return;
                            }
                            BufferedWriter bw = new BufferedWriter(new FileWriter(output.getAbsoluteFile()));
                            bw.write(table.toString());
                            bw.close();
                            System.out.println("The hash table has been saved to \"" + filename + "\"");
                        } catch (IOException e) {
                            System.err.println("***ERROR**:" + e);
                        }
                    }
                }
            } else {
                System.out.println("**ERROR**: Please choose a value from the provided menu");
            }
        }
        System.out.println("Goodbye.");
        System.exit(0);
    }
}


