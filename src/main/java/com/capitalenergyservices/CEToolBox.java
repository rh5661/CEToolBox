package com.capitalenergyservices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class CEToolBox {

    public static void loginPPL(Scanner reader, WebDriver driver) {
        /*
        * console prompt for PPL login information and login into PPL Supplier Portal
        */
        System.out.print("\nAll information entered will be deleted when the program exits\nEnter username: ");
        String loginUsername = reader.nextLine();
        System.out.print(("Enter password: "));
        String loginPassword = reader.nextLine();

        try {
            PPLTool.loginAccount(driver, loginUsername, loginPassword);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getAccountDataPPL(Scanner reader, WebDriver driver) {
        /*
         * console prompt for PPL account data retrieval
         */
        System.out.print("Enter account number: ");
        String accountNumber = reader.nextLine();

        try {
            PPLTool.retrieveAccountData(driver,accountNumber);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void exportAccountData(Scanner reader, WebDriver driver) {
        /*
        * console prompt for downloading account usage xlsx file
        */

        System.out.print("Download account usage data as Excel file? (Y/N): ");
        String userInput = (reader.next()).toLowerCase();

        if (userInput.equals("y") || userInput.equals("yes")) {
            PPLTool.downloadUsageFile(driver);
        }
    }

    publc static void greet() {
        System.out.println("...Welcome to CEToolBox v1.0...");
        printHelp();
    }


    public static void printHelp() {
        System.out.println("1: ECL PPL Tool\n" +
                            "2: SFE Margin Calculator\n" +
                                "q: Quit" +
                                    "h: Show all commands");
    }


    public static void main(String[] args) {

        try {
            Scanner reader = new Scanner(System.in);

            greet();
            String userInput = "";
            while(!((userInput.toLowerCase()).equals("q"))) {
                System.out.println("Enter a command (h for help): ");
                try {
                    userInput = (reader.nextLine()).toLowerCase();

                    if(userInput.equals("1")) {
                        ECLToolPPL.executeProgram();
                    } else if(userInput.equals("2")) {

                    }
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}