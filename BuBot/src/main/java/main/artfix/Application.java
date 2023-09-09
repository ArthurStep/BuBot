package main.artfix;

import main.artfix.other.AdminMailChange;
import main.artfix.other.UsageTypeChange;
import main.artfix.system.FileIng;
import main.artfix.other.NameChange;
import main.artfix.system.Controlling;
import main.artfix.voiceControlling.VoiceRecognition;
import main.artfix.voiceControlling.VoiceSync;

public class Application {
    public static boolean applicationWorking = true;

    public static void start() {
        if (FileIng.read("username").equals("no")) {
            NameChange.change();
        }
        if(FileIng.read("usage-type").equals("no")){
            UsageTypeChange.change();
        }
        if(FileIng.read("admin-mail").equals("no")){
            AdminMailChange.change();
        }

        while (applicationWorking) {
            String userVoice = VoiceRecognition.start();
            System.out.println("You: " + userVoice);
            VoiceSync.start(Controlling.start(userVoice));

            if (userVoice.equals("EMERGENCY STOP")) {
                applicationWorking = false;
                System.out.println("If you have technical problems you can contact with admin!");
                System.out.println("Thanks for using BuBot :)");
            }
        }
        System.out.println("Bye [__] ...");
    }
}
