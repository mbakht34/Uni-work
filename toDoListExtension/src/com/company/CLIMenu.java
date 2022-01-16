package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIMenu {
    File file = new File("save.txt");
    Scanner fs = new Scanner (file);


    Status todoStat = Status.PENDING;
    public CLIMenu(ArrayList<Todo> arr) throws IOException {


        FileWriter fw = new FileWriter("save.txt", true);
        PrintWriter pw = new PrintWriter(fw);






       boolean exit = true;
            while(exit ==true){
            ArrayList<Todo> myArray = arr;
            System.out.print("1. List todo");
            System.out.print(System.lineSeparator());
            System.out.print("2. Add todo");
            System.out.print(System.lineSeparator());
            System.out.print("3. Update todo");
            System.out.print(System.lineSeparator());
            System.out.print("4. Delete todo");
            System.out.print(System.lineSeparator());
            System.out.print("5. Quit");
            System.out.print(System.lineSeparator());

            Scanner uc = new Scanner(System.in);

            int choice = uc.nextInt();


            switch (choice) {
                case 1:
                    for(int i = 0; i<myArray.size(); i++){
                        System.out.print("These are the current list: " + (i+1) + ". " + myArray.get(i).toString());

                        System.out.print(System.lineSeparator());


                    }
                    Scanner fileScan = new Scanner(file);
                    String listStr = "This is the list of all to-do's: ";
                    while(fileScan.hasNextLine()){

                   listStr = listStr.concat(fileScan.nextLine());
                    }
                    System.out.println(listStr);



                    break;
                case 2:
                    Scanner td = new Scanner(System.in);
                    System.out.print("Enter title for todo");
                    String tl = td.nextLine();
                    System.out.print("Enter a due date for the todo in the format YYYY-MM-DDTHH:MM");
                    String dueDate = td.nextLine();
                    LocalDateTime tDate = LocalDateTime.parse(dueDate);
                    System.out.print("Select a category for the todo");
                    System.out.print(System.lineSeparator());
                    System.out.print("Select a item between 1 and 6 and press enter");
                    System.out.print(System.lineSeparator());
                    System.out.print("1. Red\n" + " 2. White\n" + "3. Blue\n" + "4. Purple\n" + "5. Yellow\n" + "6. Green");
                    System.out.print(System.lineSeparator());
                    int col = td.nextInt();
                    Category cater;
                    switch (col) {
                        case 1:
                            cater = Category.RED;
                            break;
                        case 2:
                            cater = Category.WHITE;
                            break;
                        case 3:
                            cater = Category.BLUE;
                            break;
                        case 4:
                            cater = Category.PURPLE;
                            break;
                        case 5:
                            cater = Category.YELLOW;
                            break;
                        case 6:
                            cater = Category.GREEN;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + col);
                    }
                    System.out.print("Select the importance of the todo");
                    System.out.print(System.lineSeparator());
                    System.out.print("Select an item between 1 and 3 and press enter");
                    System.out.print(System.lineSeparator());
                    System.out.print("1. LOW\n" + "2. NORMAL\n" + "3. HIGH");
                    System.out.print(System.lineSeparator());

                    int impor = td.nextInt();
                    Importance todoImpor;
                    switch (impor) {
                        case 1:
                            todoImpor = Importance.LOW;
                            break;
                        case 2:
                            todoImpor = Importance.NORMAL;
                            break;
                        case 3:
                            todoImpor = Importance.HIGH;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + impor);
                    }
                    Todo newTodo = new Todo(tl, tDate, cater, todoImpor, todoStat);
                    myArray.add(newTodo);


                    pw.println(tl + " "+ tDate + " " + cater + " " + todoImpor + " " + todoStat + ", " + "\n" );


                    break;
                case 3:
                    System.out.print("Which todo do you wish to update?");
                    System.out.print(System.lineSeparator());
                    Scanner sc4 = new Scanner(System.in);
                    int upd = sc4.nextInt();
                    System.out.print(System.lineSeparator());
                    System.out.print("Select an item between 1 and 5 and press enter 1. title\n" + "2. due date\n" + "3. category\n" + "4. importance\n" + "5. completion");
                    int spec = sc4.nextInt();
                    switch (spec){
                        case 1:
                            Scanner newscan1 = new Scanner(System.in);
                            System.out.print(System.lineSeparator());
                            System.out.print("Enter title for todo");
                            System.out.print(System.lineSeparator());
                            String nTitle = newscan1.nextLine();
                            System.out.print(System.lineSeparator());
                            myArray.get(upd -1).setText(nTitle);
                            break;
                        case 2:
                            Scanner newscan = new Scanner(System.in);
                            System.out.print(System.lineSeparator());
                            System.out.print("Enter a due date for the todo in the format YYYY-MM-DDTHH:MM");
                            String dueDate2 = newscan.nextLine();
                            LocalDateTime tDate2 = LocalDateTime.parse(dueDate2);
                            myArray.get(upd-1).setDue(tDate2);
                            break;
                        case 3:
                            System.out.print(System.lineSeparator());
                            System.out.print("Select a category for the todo");
                            System.out.print(System.lineSeparator());
                            System.out.print("Select a item between 1 and 6 and press enter");
                            System.out.print(System.lineSeparator());
                            System.out.print("1. Red\n" + " 2. White\n" + "3. Blue\n" + "4. Purple\n" + "5. Yellow\n" + "6. Green");
                            System.out.print(System.lineSeparator());

                            int col2 = sc4.nextInt();
                            Category cater2;
                            switch (col2) {
                                case 1:
                                    cater2 = Category.RED;
                                    break;
                                case 2:
                                    cater2 = Category.WHITE;
                                    break;
                                case 3:
                                    cater2 = Category.BLUE;
                                    break;
                                case 4:
                                    cater2 = Category.PURPLE;
                                    break;
                                case 5:
                                    cater2 = Category.YELLOW;
                                    break;
                                case 6:
                                    cater2 = Category.GREEN;
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + col2);
                            }
                            myArray.get(upd-1).setCat(cater2);
                            break;
                        case 4:
                            System.out.print("Select the importance of the todo");
                            System.out.print(System.lineSeparator());
                            System.out.print("Select an item between 1 and 3 and press enter");
                            System.out.print(System.lineSeparator());
                            System.out.print("1. LOW\n" + "2. NORMAL\n" + "3. HIGH");
                            System.out.print(System.lineSeparator());

                            int impor2 = sc4.nextInt();
                            Importance todoImpor2;
                            switch (impor2) {
                                case 1:
                                    todoImpor2 = Importance.LOW;
                                    break;
                                case 2:
                                    todoImpor2 = Importance.NORMAL;
                                    break;
                                case 3:
                                    todoImpor2 = Importance.HIGH;
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + impor2);
                            }
                            myArray.get(upd-1).setImportance(todoImpor2);
                            break;
                        case 5:
                            System.out.print(System.lineSeparator());
                            System.out.print("Select a status for the todo");
                            System.out.print(System.lineSeparator());
                            System.out.print("Select an item between 1 and 4 and press enter 1. pending\n" + "2. started\n" + "3. partial\n" + "4. completed");
                            System.out.print(System.lineSeparator());
                            int stat = sc4.nextInt();
                            switch(stat){
                                case 1:
                                    myArray.get(upd-1).setCompletion(Status.PENDING);
                                    break;
                                case 2:
                                    myArray.get(upd-1).setCompletion(Status.STARTED);
                                    break;
                                case 3:
                                    myArray.get(upd-1).setCompletion(Status.PARTIAL);
                                    break;
                                case 4:
                                    myArray.get(upd-1).setCompletion(Status.COMPLETED);
                                    break;
                            }



                    }
                    break;
                case 4:
                    System.out.print("Which todo do you wish to delete?");
                    System.out.print(System.lineSeparator());
                    Scanner sc3 = new Scanner(System.in);
                    int del = sc3.nextInt();
                    myArray.remove(del-1);

                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.out.print("Please enter a valid option");
            }
                pw.close();


        }



    }




}
