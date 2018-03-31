package xyz.yuibot.discord.utils;

import net.dv8tion.jda.core.entities.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import xyz.yuibot.discord.YuiConfig;
import xyz.yuibot.discord.YuiInfo;

import java.util.ArrayList;

public class UpvoterUtils {
    public static ArrayList<String> upvoters = new ArrayList<>();

    public static boolean hasUpvoted(User user) {
        if (upvoters.contains(user.getId()))
            return true;

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url("https://discordbots.org/api/bots/412014529099333642/votes?onlyids=1")
                .get()
                .addHeader("Authorization", YuiConfig.getOliyBots())
                .addHeader("User-Agent", YuiInfo.getUserAgent())
                .build();

        try {
            Response rawJson = client.newCall(req).execute();
            JSONArray array = new JSONArray(rawJson.body().source().readUtf8());
            upvoters.clear();
            array.iterator().forEachRemaining(it -> upvoters.add(String.valueOf(it)));
            return array.toList().contains(user.getId());
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}