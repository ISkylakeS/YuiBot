package xyz.yuibot.discord.commands;

import xyz.yuibot.discord.core.command.*;
import xyz.yuibot.discord.core.entities.Context;
import net.dv8tion.jda.core.EmbedBuilder;

@ICommand(
        name = "about",
        desc = "About me, Yui Hirasawa =w=",
        usage = "about",
        aliases = {"info"}
)
public class AboutCommand implements Command {
    @Override
    public void execute(String args, Context ctx) {
        ctx.sendMessage(new EmbedBuilder()
                .setTitle("About me, Yui!")
                .setDescription("Hello! I'm Yui, your cute helper!\nI was created by <@280158289667555328>!")
                .build()
        );
    }
}