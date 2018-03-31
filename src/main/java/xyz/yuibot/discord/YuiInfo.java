package xyz.yuibot.discord;

public class YuiInfo {
    public static final String VERSION = "v0.2.0";
    public static final String GITHUB = "https://github.com/ohlookitsAugust/Yui";
    public static final String USER_AGENT = "JDA/DiscordBot; (" + VERSION + " " + GITHUB + ")";

    public static String getVersion() {
        return VERSION;
    }

    public static String getGithubURL() {
        return GITHUB;
    }

    public static String getUserAgent() {
        return USER_AGENT;
    }
}