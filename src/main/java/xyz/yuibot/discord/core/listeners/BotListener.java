package xyz.yuibot.discord.core.listeners;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.*;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import xyz.yuibot.discord.events.*;

public class BotListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        new YuiReady(event);
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        new GuildJoinedEvent(event);
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {
        new GuildLeftEvent(event);
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        new MessageEvent(event);
    }
}