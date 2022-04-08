package com.lockedme;
import java.io.IOException;
import java.util.Scanner;

public class Display {
	
	Scanner scan = new Scanner(System.in);
	
	
	public void introScreen() {
		
		System.out.println("*************************************************");	
		System.out.println("*            WELCOME TO LOCKEDME.COM            *");
		System.out.println("*                                               *");
		System.out.println("*************************************************");
		System.out.println("*            THIS APP IS DEVELOPED BY           *");
		System.out.println("*               SHIKSHA PANDEY                  *");
		System.out.println("*************************************************");
		System.out.println("*   Directory: " + Test.path +"    ");
		System.out.println("*************************************************");
		System.out.println("\n\n");
		
	}
	
	public void exitScreen() {
		
		System.out.println("=================================================");
		System.out.println("=================================================");
		System.out.println("|                                               |");
		System.out.println("|    THANK YOU FOR VISITING LOCKEDME.COM        |");
		System.out.println("|                                               |");
		System.out.println("=================================================");
		System.out.println("=================================================");
		System.out.println("\n\n");
		
		
	}
	
	public void mainMenuOptions() {
		System.out.println("-------------------------------------");
		System.out.println("::            MAIN MENU            ::");
		System.out.println("-------------------------------------");
		System.out.println(":: Select any one of the following ::");
		System.out.println("::         and press enter         ::");
		System.out.println("::                                 ::");
	    System.out.println("::  1 - List All Files             ::");
	    System.out.println("::  2 - More Options               ::");
	    System.out.println("::  3 - Exit                       ::");
	    System.out.println("-------------------------------------");
	    System.out.println();
	    System.out.println("----------------------------");
	    System.out.println("::Please enter your choice::");
	    System.out.println("----------------------------");
	}
	
	public static void subMenuOptions() {
		
		System.out.println("--------------------------------------");
		System.out.println("::   MORE OPTION - SUB MENU         ::");
		System.out.println("--------------------------------------");
		System.out.println(":: Select any one of the following  ::");
		System.out.println("::         and press enter          ::");
		System.out.println("::                                  ::");
	    System.out.println("::  1 - Add a file or Data to a file::");
	    System.out.println("::  2 - Delete a file               ::");
	    System.out.println("::  3 - Search and View a file      ::");
	    System.out.println("::  4 - Go Back                     ::");
	    System.out.println("--------------------------------------");
        System.out.println();
	    System.out.println("----------------------------");
	    System.out.println("::Please enter your choice::");
	    System.out.println("----------------------------");
		
	}
	
	public void mainMenu() {
		
		int choice = 0;
		char decision = 0;
		do {
			
			mainMenuOptions();
			
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nValid Input Integers press:(1-3)\n");
				mainMenu();
			}
			
			
			switch (choice) {
			
			case 1:
					System.out.println();
					try {
						Operations.listFilesInAssendingOrder(Test.path);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n--------------------------------------\n");
					break;
					
			case 2: 
					System.out.println();
					subMenu();
					break;
					
			case 3: 
					System.out.println("\n Are you sure you want to exit ? ");
					System.out.println("  (Y) ==> Yes    (N) ==> No        ");
					decision =  scan.nextLine().toUpperCase().charAt(0);
					if(decision == 'Y' || decision == 'y') {
						System.out.println("\n");
						exitScreen();
						System.exit(1);
					}else if(decision == 'N' || decision == 'n') {
						System.out.println("\n");
						mainMenu();
					}else {
						System.out.println("\nInvalid Input \nValid Inputs Press:(Y/N)\n");
						mainMenu();
					}
					
					
			default:
					System.out.println("\nInvalid Input \nValid Input Integers Press:(1-3)\n");
					mainMenu();
				
			}
			
			
		}while(true);
		
	}
	
	
	public void subMenu() {
		String file = null;
		String fileTrim = null;
		String fileName = null;
		char decision;
		int choice = 0;
		
		do {
			
			subMenuOptions();
			
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input \nValid Input Integers Press:(1-4)");
				subMenu();
			}
			
			
			switch (choice) {
			case 1: 
					System.out.println("\n==> Adding a File...");
					System.out.println("----------------------------");
					System.out.println("::Please enter a file name::");
					System.out.println("----------------------------");
					file = scan.nextLine();
					fileTrim = file.trim();
					fileName = fileTrim.substring(0, 1).toUpperCase()+fileTrim.substring(1);
					
					try {
						Operations.addNewFiles(Test.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while adding file..");
						System.out.println("Please try again...");
					}catch(Exception e) {
						System.out.println("Error occurred while adding file..");
						System.out.println("Please try again...");
					}
					
					System.out.println("\n----------------------------------------------------\n");
      				System.out.println("Would you like to add some content in the file? (Y/N)");
      				System.out.println("\n-----------------------------------------------------\n");
      				System.out.println();
      				System.out.println("----------------------------");
      			    System.out.println("::Please enter your choice::");
      			    System.out.println("----------------------------");
      				
					decision = scan.nextLine().toUpperCase().charAt(0);
					
					if(decision == 'Y' || decision == 'y') {
						System.out.println("\n");
						try {
							Operations.addElementToFile(Test.path, fileName);
							System.out.println();
							System.out.println("--> Your data is added succesfuly <--");
							System.out.println("\n--------------------------------------\n");
						} catch (IOException e) {
							System.out.println("Error occured while adding file content..");
							System.out.println("Please try again after some time..");
						}
						subMenu();
					}else if(decision == 'N' || decision == 'n') {
						System.out.println("\n");
						mainMenu();
					}else {
						System.out.println("\nInvalid Input \nValid Inputs Press:(Y/N)\n");
						mainMenu();
					}
					break;
					
					
			case 2: 
					System.out.println("\n==> Deleting a File...");
					System.out.println("--------------------------------------");
					System.out.println("::Please enter a file name to delete::");
					System.out.println("--------------------------------------");
					file = scan.nextLine();
					fileTrim = file.trim();
					fileName = fileTrim.substring(0, 1).toUpperCase()+fileTrim.substring(1);
					
					try {
						Operations.deleteFile(Test.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while Deleting This File..");
						System.out.println("Please try again after sometimes...");
					}catch(Exception e) {
						System.out.println("Error occurred while Deleting This File..");
						System.out.println("Please try again after sometimes...");
					}
					System.out.println("\n--------------------------------------\n");
					break;
					
					
			case 3: 
					System.out.println("\n==> Searching a File...");
					System.out.println("--------------------------------------");
					System.out.println("::Please enter a file name to search::");
					System.out.println("--------------------------------------");
					file = scan.nextLine();
					fileTrim = file.trim();
					fileName = fileTrim.substring(0, 1).toUpperCase()+fileTrim.substring(1);
					try {
						Operations.searchFile(Test.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
			case 4: mainMenu();
					break;
					
			default:
				System.out.println("Invalid Input \nValid Input Integers Press:(1-4)");
				subMenu();
				
			}
			
		file = null;
		fileName = null;
			
		}while(true);
		
	}
	
}
