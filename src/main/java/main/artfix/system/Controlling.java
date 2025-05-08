package main.artfix.system;

import main.artfix.Application;
import main.artfix.other.*;

import java.util.Scanner;

public class Controlling {
    public static String start(String ask) {
        String answer = " ";
        String username = FileIng.read("username");
        username = " " + username + ".";
        switch (ask) {
            case "BUBOT":
                if (RandomNumber.get() == 0) {
                    answer = "Yes," + username;
                } else {
                    answer = "I'm listening," + username;
                }

                break;
            case "HELLO", "HI", "HI BUBOT", "HELLO BUBOT":
                if (RandomNumber.get() == 1) {
                    answer = "Hi," + username;
                } else {
                    answer = "Hello," + username;
                }
                break;

            case "HOW ARE YOU":
                if (RandomNumber.get() == 0) {
                    answer = "The processor is a bit badly damaged, but ok. haha";
                } else {
                    answer = "Fine, you.";
                }
                break;

            case "WHAT IS YOUR NAME", "WHATS YOUR NAME":
                answer = "My name is BuBot.";
                break;

            case "SORRY":
                answer = "Don't worry!";
                break;

            case "DONT WORRY":
                answer = "It's OK!";
                break;

            case "SHUT UP BUBOT", "SHUT UP":
                answer = "Sorry.";
                break;

            case "EMERGENCY STOP":
                answer = "Emergency stop!";
                break;

            case "BUBOT OPEN GOOGLE", "OPEN GOOGLE":
                OpenBrowser.open("https://google.com/");
                answer = "Done!";
                break;

            case "BUBOT OPEN YOUTUBE", "OPEN YOUTUBE":
                OpenBrowser.open("https://youtube.com/");
                answer = "Done!";
                break;

            case "BUBOT OPEN FACEBOOK", "OPEN FACEBOOK":
                OpenBrowser.open("https://facebook.com/");
                answer = "Done!";
                break;

            case "BUBOT OPEN TOURISTBOT", "OPEN TOURISTBOT":
                OpenBrowser.open("https://touristbot.org/");
                answer = "Done!";
                break;

            case "THANKS FOR ASKING", "THANKS FOR ASKING BUBOT", "FINE THANKS FOR ASKING":
                answer = "You're welcome!";
                break;

            case "RESET ALL SETTINGS":
                answer = ResetAllSettings.reset();
                break;

            case "CHANGE USER":
                answer = UserChange.change();
                break;

            case "SEND MESSAGE TO ADULT", "SEND MESSAGE TO PARENT", "SEND MESSAGE TO ADULTS", "SEND MESSAGE TO PARENTS":
                if (FileIng.read("user-type").equals("child")) {
                    System.out.print("Type message for send: ");
                    Scanner scanForMessageSendIn = new Scanner(System.in);
                    String scanForMessageSend = scanForMessageSendIn.nextLine();
                    MailSendService.send("|||MESSAGE FROM CHILD||| -> " + scanForMessageSend);
                    answer = "Message sent!";
                } else {
                    answer = "Your mode now is on adult.";
                }
                break;

            case "USER":
                answer = FileIng.read("usage-type");
                break;

            case "WIKIPEDIA", "SEARCH", "BUBOT SEARCHING", "SEARCH BUBOT", "SEARCHING BUBOT", "SEARCHING":
                WikiSearchAccess.startSearch();
                break;

            case "BYE", "GOODBYE":
                answer = "GoodBye, Have a nice day" + username;
                Application.applicationWorking = false;
                break;

            case "BUBOT CHANGE NAME", "CHANGE NAME BUBOT", "CHANGE NAME":
                NameChange.change();
                answer = "Done!";
                break;

            case "FINE", "YES", "FINE BUBOT", "YES BUBOT":
                if (RandomNumber.get() == 1) {
                    answer = "Good for you" + username;
                } else {
                    answer = "Good for you.";
                }
                break;

            case "WHO MADE YOU", "WHO MADE YOU BUBOT":
                answer = "I am made by Arthur Stepanyan.";
                break;

            case "NOTHING", "NOTHING BUBOT":
                if (RandomNumber.get() == 0) {
                    answer = "OK," + username;
                } else {
                    answer = "OK";
                }
                break;

            case "NO BUBOT", "BUBOT NO", "NO":
                answer = "OK";
                break;

            default:
                answer = " ";
                break;
        }
        System.out.println("BuBot: " + answer);
        return answer;
    }
}
