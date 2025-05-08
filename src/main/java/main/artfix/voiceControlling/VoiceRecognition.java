package main.artfix.voiceControlling;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import main.artfix.Application;
import main.artfix.other.SystemAutoReset;

public class VoiceRecognition {

    public static String start() {
        String recognizedText = "ERROR";
        try {
            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("app_files/dictionary/0113.dic");
            configuration.setLanguageModelPath("app_files/dictionary/0113.lm");
            //http://www.speech.cs.cmu.edu/tools/lmtool-new.html

            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);
            System.out.println("Listening...");
                SpeechResult result = recognizer.getResult();
                if (result != null) {
                    recognizedText = result.getHypothesis();
                }

            recognizer.stopRecognition();
        } catch (Exception e) {
            System.out.println("System ERROR! -> Voice Recognition");
            SystemAutoReset.start();
            Application.applicationWorking = false;
        }
        return recognizedText;
    }
}
