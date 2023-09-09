package main.artfix.other;

import main.artfix.system.FileIng;

public class SystemAutoReset {
    public static void start() {
        FileIng.write("username", "no");
        FileIng.write("usage-type", "no");
        FileIng.write("admin-mail", "no");
        FileIng.write("child-search-access-granted", "no");
    }
}
