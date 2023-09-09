package main.artfix.system;

import main.artfix.other.SystemAutoReset;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIng {


    public static String read(String FileName) {
        String ReadData = "";
        try {
            File readwrite = new File("app_files/" + FileName + ".txt");
            Scanner scan = new Scanner(readwrite);
            ReadData = SecurityAES.decrypt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("System ERROR! -> File Read");
            SystemAutoReset.start();
        }
        return ReadData;
    }

    public static void write(String FileName, String WhatToWrite) {
        try {
            FileWriter readTxt = new FileWriter("app_files/" + FileName + ".txt");
            readTxt.write(SecurityAES.encrypt(WhatToWrite));
            readTxt.close();
        } catch (Exception e) {
            System.out.println("System ERROR! -> File Write");
            SystemAutoReset.start();
        }
    }
}
