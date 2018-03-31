package xyz.yuibot.discord.core.entities;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import xyz.yuibot.discord.YuiBot;

public class Context {
    public Message message;
    public TextChannel channel;
    public VoiceChannel voiceChannel;
    public User author;
    public JDA jda;
    public YuiBot bot;
    public Guild guild;

    public Context(YuiBot bot) {
        this.bot = bot;
        this.jda = jda;
        this.author = author;
        this.message = message;
        this.jda = jda;
        this.channel = channel;
        this.voiceChannel = voiceChannel;
        this.guild = guild;
    }

    public Message getMessage() {
        return message;
    }

    public JDA getJDA() {
        return jda;
    }

    public YuiBot getBot() {
        return bot;
    }

    public TextChannel getChannel() {
        return channel;
    }

    public VoiceChannel getVoiceChannel() {
        return voiceChannel;
    }

    public User getAuthor() {
        return author;
    }

    public Guild getGuild() {
        return guild;
    }

    public void sendMessage(YuiEmoji emote, String message) {
        this.getChannel().sendMessage(emote + " `|` " + message).queue();
    }

    public void sendMessage(MessageEmbed embed) {
        this.getChannel().sendMessage(embed).queue();
    }
}