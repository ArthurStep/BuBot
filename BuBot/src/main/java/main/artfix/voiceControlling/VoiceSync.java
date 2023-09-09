package main.artfix.voiceControlling;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceSync {
    public static void start(String textForSpeech) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
            voice.speak(textForSpeech);
            voice.deallocate();
        } else {
            System.out.println("VoiceSync ERROR");
        }
    }
}
