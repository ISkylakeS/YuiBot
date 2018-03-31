package xyz.yuibot.discord;

public class YuiConfig {
    public static String token = "NDEyMDE0NTI5MDk5MzMzNjQy.DZ4mXg.1gDwGYXkJy41k1WxJRT503OZsxQ";
    public static boolean isPatreon = false;
    public static String oliyBots = "";
    public static String blspace = "";
    public static String terminal = "";
    public static String osu = "";
    public static String prefix = "yui!";
    public static String devToken = "NDE0NDEwNTAyMDUyMjQ5NjAw.DZ4mbg.eXZOBO07kNIYZH7yGi4ndNZ8p1A";

    public static String getToken() {
        return isPatreon ? devToken : token;
    }

    public static String getOliyBots() {
        return oliyBots;
    }

    public static String getBotlist() {
        return blspace;
    }

    public static String getTerminal() {
        return terminal;
    }

    public static String getosu() {
        return osu;
    }

    public static String getPrefix() {
        return prefix;
    }
}