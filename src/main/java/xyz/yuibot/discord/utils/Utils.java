package xyz.yuibot.discord.utils;

import java.util.concurrent.TimeUnit;

public class Utils {
    // Credit to MantaroBot/Kode (https://github.com/Mantaro/MantaroBot/blob/development/src/main/java/net/kodehawa/mantarobot/utils/Utils.java#L108)
    public static String getUptime(long ms) {
        // Get our time correctly..
        long days = TimeUnit.MILLISECONDS.toDays(ms);
        long hours = TimeUnit.MILLISECONDS.toHours(ms) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(ms));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms));

        StringBuilder output = new StringBuilder();
        boolean leading = false;

        if (days > 0) {
            output.append(days).append(" ").append((days > 1 ? "days" : "day"));
            leading = true;
        } if (hours > 0) {
            if (leading && (minutes != 0 || seconds != 0)) {
                output.append(", ");
            }

            if (!output.toString().isEmpty() && (minutes == 0 && seconds == 0)) {
                output.append(" and ");
            }

            output.append(hours).append(" ").append((hours > 1 ? "hours" : "hour"));
            leading = true;
        } if (minutes > 0) {
            if (leading && seconds != 0) {
                output.append(", ");
            }

            if (!output.toString().isEmpty() && seconds == 0) {
                output.append(" and ");
            }

            leading = true;
            output.append(minutes).append(" ").append((minutes > 1 ? "minutes" : "minute"));
        } if (seconds > 0) {
            if (leading) {
                output.append(", and ");
            }

            output.append(seconds).append(" ").append((seconds > 1 ? "seconds" : "second"));
        }

        if (output.toString().isEmpty() && !leading) {
            output.append("0 seconds, (started just now!)");
        }

        return output.toString();
    }
}