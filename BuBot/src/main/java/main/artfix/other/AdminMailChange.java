package main.artfix.other;

import main.artfix.Application;
import main.artfix.system.FileIng;

import java.util.Scanner;

public class AdminMailChange {
    public static void change() {
        System.out.println(" ");
        System.out.print("Enter admin mail for receive important messages: ");
        Scanner scanAdminMailIn = new Scanner(System.in);
        String scanAdminMail = scanAdminMailIn.nextLine();
        FileIng.write("admin-mail", scanAdminMail);

        if (scanAdminMail.equals("no")) {
            System.out.println("Usage type changed to default!");
            Application.applicationWorking = false;
        }
    }
}
