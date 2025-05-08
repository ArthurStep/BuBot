package main.artfix.other;

import java.awt.*;
import java.net.URI;

public class OpenBrowser {
    public static void open(String url){
        try {
            URI uri = new URI(url);
            Desktop.getDesktop().browse(uri);
        }catch(Exception e){
            System.out.println("Error -> Browser Find");
        }
    }
}
