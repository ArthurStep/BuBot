package main.artfix.other;

import main.artfix.system.FileIng;
import main.artfix.system.MailSendService;
import main.artfix.voiceControlling.VoiceSync;

import java.util.Scanner;

public class UserChange {
    public static String change() {
        String answer;

        VoiceSync.start("Default user is " + FileIng.read("usage-type") +
                "you receive message to admin mail for user change?");

        String codeForUserChange = RandomCodeGenerator.generate();

        MailSendService.send("Hi, user requested user change do you give access if yes type '"
                + codeForUserChange + "' code. Thanks, With love BuBot.");

        System.out.print("Enter code: ");
        Scanner scanForUserChangeCodeIn = new Scanner(System.in);
        String scanForUserChangeCode = scanForUserChangeCodeIn.nextLine();

        if (scanForUserChangeCode.equals(codeForUserChange)) {
            if (FileIng.read("usage-type").equals("adult")) {
                FileIng.write("usage-type", "child");
            } else {
                FileIng.write("usage-type", "adult");
            }
            answer = "User changed!";
        } else {
            System.out.println("Wrong code!!!");
            MailSendService.send("Wrong code entered for user change access." +
                    " Thanks, With love BuBot.");
            answer = "Wrong code!";
        }

        return answer;
    }
}
