package main.artfix.other;

import main.artfix.Application;
import main.artfix.system.FileIng;

import java.util.Scanner;

public class UsageTypeChange {
    public static void change() {
        boolean usageTypeProcess = true;
        while (usageTypeProcess) {
            System.out.println(" ");
            System.out.println("| Adult | Child/Children |");
            System.out.print("Enter BuBot usage type to continue: ");

            Scanner scanUsageTypeIn = new Scanner(System.in);
            String scanUsageType = scanUsageTypeIn.nextLine();

            if (scanUsageType.equals("no")) {
                FileIng.write("usage-type", "no");
                System.out.println("Usage type changed to default!");
                Application.applicationWorking = false;
            }

            switch (scanUsageType) {
                case "Adult", "adult", "1":
                    FileIng.write("usage-type", "adult");
                    usageTypeProcess = false;
                    break;
                case "Child", "Children", "child", "children", "Child/Children", "2":
                    FileIng.write("usage-type", "child");
                    usageTypeProcess = false;
                    break;
                default:
                    System.out.println("Enter 1 or 2!");
                    break;
            }
        }
    }
}
