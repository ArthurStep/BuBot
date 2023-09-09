package main.artfix.other;

import main.artfix.Application;
import main.artfix.system.FileIng;
import java.util.Scanner;

public class NameChange {
    public static void change() {
        System.out.print("Enter user name to continue: ");
        Scanner scanUsernameIn = new Scanner(System.in);
        String scanUsername = scanUsernameIn.nextLine();
        FileIng.write("username", scanUsername);
        if(scanUsername.equals("no")){
            System.out.println("Username changed to default!");
            Application.applicationWorking = false;
        }
    }
}
