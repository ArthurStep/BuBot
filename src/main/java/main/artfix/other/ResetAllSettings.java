package main.artfix.other;

import main.artfix.Application;
import main.artfix.system.FileIng;
import main.artfix.system.MailSendService;
import main.artfix.voiceControlling.VoiceSync;

import java.util.Scanner;

public class ResetAllSettings {
    public static String reset() {
        String answer;

        VoiceSync.start("Default user is " + FileIng.read("usage-type") +
                "you receive message to admin mail for reset settings?");

        String codeForResetAllSettings = RandomCodeGenerator.generate();

        MailSendService.send("Hi, user requested change all settings to default (reset) BuBot" +
                " do you give access if yes type '" + codeForResetAllSettings + "' code. Thanks, With love BuBot.");

        System.out.print("Enter code: ");

        Scanner scanForResetAllSettingsCodeIn = new Scanner(System.in);
        String scanForResetAllSettingsCode = scanForResetAllSettingsCodeIn.nextLine();

        if (scanForResetAllSettingsCode.equals(codeForResetAllSettings)) {
            answer = "Settings changed to default";
            FileIng.write("username", "no");
            FileIng.write("usage-type", "no");
            FileIng.write("admin-mail", "no");
            FileIng.write("child-search-access-granted", "no");
            MailSendService.send("Dear user all settings on your BuBot set to default by your access." +
                    " Thanks, With love BuBot.");
            Application.applicationWorking = false;
        } else {
            System.out.println("Wrong code!!!");
            MailSendService.send("Wrong code entered for reset all settings access." +
                    " Thanks, With love BuBot.");
            answer = "Wrong code!";
        }

        return answer;
    }
}
