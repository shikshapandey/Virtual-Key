package com.lockedme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
	
	
	public static void listFilesInAssendingOrder(String path) {
		
		if(path==null || path.isBlank() || path.isBlank()) {
			throw new NullPointerException("--> Please add a path first <--");
		}
		
        File dir = new File(path);
		
		if(!dir.exists())
			throw new IllegalArgumentException("--> Path does not exist <--");
		
		if(dir.isFile())
			throw new IllegalArgumentException("--> Please add a proper path, you are providing a 'File name' <--");
		
		String [] files = dir.list();
		
		System.out.println("\n------------------------------------");
		if(files != null && files.length > 0) {
			
			Set<String>filesList = new TreeSet<String>(Arrays.asList(files)); 
			System.out.println("The Files in "+ dir.getAbsolutePath() + " are: \n");
			for(String file1 : filesList) {
				System.out.println(file1);
			}
			
			System.out.println("\n--> "+filesList.size() + " numbers of total files found <--");	
		}else {
			
			System.out.println("--> Directory is empty, add a file first <--");
		}
		
	}
	
	
	public static void addNewFiles(String path, String fileName) throws IOException{
		
		if(path == null || path.isBlank() || path.isEmpty()) {
			throw new NullPointerException("--> Please add a path first <--");
		}
		if(fileName == null || fileName.isBlank() || fileName.isBlank()) {
			throw new NullPointerException("--> Please provide a File name  <--");
		}
		File newFile = new File(path+File.separator+fileName);
		boolean res1 = newFile.createNewFile();
		if(res1) {
			System.out.println("\n--> New File is created sucessfully <--");
		}
		else {
			System.out.println("\n--> File Existed <--");
		}
	}
			
			
	public static void deleteFile(String path, String fileName)	throws IOException{
		if(path == null || path.isBlank() || path.isEmpty()) {
			throw new NullPointerException("--> Please add a path first <--");
		}
		if(fileName == null || fileName.isBlank() ||fileName.isEmpty()) {
			throw new NullPointerException("--> Please provide a File name  <--");
		}
		File newFile = new File(path+File.separator+fileName);
		boolean res2 = newFile.delete();
		if(res2) {
			System.out.println("\n--> File is deleted <--");
		}
		else {
			System.out.println("\n--> File not found <--");
		}
	}
	
	
	public static void searchFile(String path, String fileName) {
		
		char decision;
		Scanner scan = new Scanner(System.in);
		Display dis = new Display();
		
		if(path == null || path.isBlank() || path.isEmpty()) {
			throw new NullPointerException("--> Please add a path first <--");
		}
		if(fileName == null || fileName.isBlank() ||fileName.isEmpty()) {
			throw new NullPointerException("--> Please provide a File name <--");
		}
		File dir = new File(path);
		if(!dir.exists())
			throw new IllegalArgumentException("--> Path does not exist <--");
		
		if(dir.isFile())
			throw new IllegalArgumentException("--> Please add a proper path, you are providing a 'File Name' <--");
		
		String [] fileList = dir.list();
		boolean flag = false;
		
		Pattern pattern = Pattern.compile(fileName);
		
		if(fileList != null && fileList.length > 0) {
			for(String file:fileList) {
				Matcher matcher = pattern.matcher(file);
				if(matcher.matches()) {
					System.out.println("File Found at location: " + dir.getAbsolutePath());
					flag = true;
					
					System.out.println();
					System.out.println("----------------------------------------------------");
					System.out.println("Would you like to see the content of the file? (Y/N)");
					System.out.println("----------------------------------------------------");
					System.out.println();
					System.out.println("----------------------------");
      			    System.out.println("::Please enter your choice::");
      			    System.out.println("----------------------------");
					decision = scan.nextLine().toUpperCase().charAt(0);
					if(decision == 'Y' || decision == 'y') {
						System.out.println("\n");
						try {
							System.out.println("==> Showing data..");
							System.out.println();
							Operations.readFile(Test.path, fileName);
						} catch (IOException e) {
							System.out.println("Error occured while showing your data..");
							System.out.println("Please try again..");
						}
						dis.subMenu();
					}else if(decision == 'N' || decision == 'n') {
						System.out.println("\n");
						dis.mainMenu();
					}else {
						System.out.println("\nInvalid Input \nValid Inputs Press:(Y/N)\n");
						dis.mainMenu();
					}
					break;
				}
			}
		}
		
		if(flag == false)
			System.out.println("--> File Not Found <--");
			
	}
	
	public static void addElementToFile(String path, String fileName) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		if(path == null || path.isBlank() || path.isEmpty()) {
			throw new NullPointerException("--> Please add a path first <--");
		}
		if(fileName == null || fileName.isBlank() ||fileName.isEmpty()) {
			throw new NullPointerException("--> Please provide a File name  <--");
		}
		
		    FileWriter fileWriter = new FileWriter(path+File.separator+fileName);
			System.out.println("==> Adding data to file..");
			System.out.println("----------------------------");
			System.out.println("::Please provide your data::");
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("Please provide your Content: ");
			String content = sc.nextLine();
			fileWriter.append("File Content : " + content + "\n");
		    fileWriter.close();
		
	}
	
       public static void readFile(String path, String fileName) throws IOException {
    	   
    	   if(path == null || path.isBlank() || path.isEmpty()) {
   			throw new NullPointerException("--> Please add a path first <--");
   		      }
   		  if(fileName == null || fileName.isBlank() ||fileName.isEmpty()) {
   			throw new NullPointerException("--> Please provide a File name  <--");
   		      }
		
    	   FileInputStream fileInputStream = new FileInputStream(path+File.separator+fileName);
			
			int count =0;
			while((count=fileInputStream.read()) !=-1 ) {
				System.out.print((char) count );
			}
			System.out.println();
			fileInputStream.close();
       }
		

	}