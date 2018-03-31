package xyz.yuibot.discord.utils;

public class AudioUtils {
    public static String format(long duration) {
        if (duration == Long.MAX_VALUE) return "LIVE";
        long sec = Math.round(duration/1000.0);
        long hrs = sec / (60*60);
        sec %= 60*60;
        long min = sec/60;
        sec %= 60;
        return (hrs > 0 ? hrs+":" : "") + (min < 10 ? "0"+min : min) + ":" + (sec < 10 ? "0"+sec : sec);
    }
}