package xyz.yuibot.discord;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.entities.Game;
import xyz.yuibot.framework.CommandHandler;
import xyz.yuibot.discord.core.listeners.BotListener;
import org.slf4j.*;
import xyz.yuibot.discord.utils.IOUtils;

import java.awt.*;

public class YuiBot {
    public static YuiBot instance;
    public static JDA jda;
    public static Logger log;
    public static Color colour;
    public static String version;
    public static CommandHandler handler;

    public YuiBot() throws Exception {
        instance = this;
        log = LoggerFactory.getLogger(YuiBot.class);
        colour = Color.decode("#614126");
        version = YuiInfo.getVersion();
        handler = new CommandHandler();

        YuiBot.printInfo();

        log.info("Yui is currently starting...");

        jda = new JDABuilder(AccountType.BOT)
                .setToken(YuiConfig.getToken())
                .addEventListener(new BotListener())
                .addEventListener(handler)
                .setGame(Game.listening(YuiConfig.getPrefix() + "help // " + YuiConfig.getPrefix() + "inviteme"))
                .buildAsync();
    }

    public static void main(String[] args) {
        try {
            new YuiBot();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void printInfo() {
        String banner = IOUtils.readFile("./banner.txt");

        if (banner != null)
            System.out.println("\n" + banner);

        log.info(
                "\nYui Hirasawa " + version +
                "| JDA Version: v" + JDAInfo.VERSION +
                "| Developed by: August#0420"
        );
    }

    public static YuiBot getInstance() {
        return instance;
    }

    public static JDA getJDA() {
        return jda;
    }

    public void stop() {
        log.warn("Yui is gonna calm down, so August is stopping her!");
        jda.shutdown();
    }

    public CommandHandler getCommandHandler() {
        return handler;
    }
}