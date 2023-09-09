package main.artfix.other;

import main.artfix.system.FileIng;
import main.artfix.system.MailSendService;
import main.artfix.voiceControlling.VoiceRecognition;
import main.artfix.voiceControlling.VoiceRecognitionGlobal;
import main.artfix.voiceControlling.VoiceSync;

import java.util.Scanner;

public class WikiSearchAccess {
    public static void startSearch() {
        if (!FileIng.read("usage-type").equals("child")) {
            VoiceSync.start("I'm listening... ");
            String recognisedTxt = VoiceRecognitionGlobal.start();
            Wiki.Jwiki.SearchNoRes.Search(recognisedTxt);
        } else if (FileIng.read("child-search-access-granted").equals("yes")) {
            VoiceSync.start("I'm listening... ");
            String recognisedTxt = VoiceRecognitionGlobal.start();
            Wiki.Jwiki.SearchNoRes.Search(recognisedTxt);
        } else {
            VoiceSync.start("Sorry, Search disabled for child. Do you want to request access?");
            String accessAsk = VoiceRecognition.start();
            if (accessAsk.equals("YES")) {

                String onlyOneTimeCode = RandomCodeGenerator.generate();
                String globalTimeCode = RandomCodeGenerator.generate();

                MailSendService.send("Hi, Your child request Internet Search if you agree only 1 " +
                        "search enter code '" + onlyOneTimeCode +
                        "', but if you want to open access to search anytime write '" +
                        globalTimeCode + "' code. Thanks, With love BuBot.");

                System.out.print("Enter code: ");
                Scanner scanForChildCodeIn = new Scanner(System.in);
                String scanForChildCode = scanForChildCodeIn.nextLine();

                if (scanForChildCode.equals(onlyOneTimeCode)) {
                    VoiceSync.start("Access granted for only one search :), I'm listening...");
                    String recognisedTxt = VoiceRecognitionGlobal.start();
                    Wiki.Jwiki.SearchNoRes.Search(recognisedTxt);

                } else if (scanForChildCode.equals(globalTimeCode)) {
                    FileIng.write("child-search-access-granted", "yes");
                    VoiceSync.start("Access granted for lifetime :)), I'm listening...");
                    String recognisedTxt = VoiceRecognitionGlobal.start();
                    Wiki.Jwiki.SearchNoRes.Search(recognisedTxt);
                } else {
                    System.out.println("Wrong code!!!");
                    MailSendService.send("Wrong code entered for child search access." +
                            " Thanks, With love BuBot.");
                }

            } else {
                VoiceSync.start("OK :)");
            }
        }
    }
}
