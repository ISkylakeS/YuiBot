package xyz.yuibot.discord.events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import xyz.yuibot.discord.YuiBot;
import xyz.yuibot.discord.core.entities.Context;

public class MessageEvent
{
    YuiBot bot;

    public MessageEvent(GuildMessageReceivedEvent e)
    {
        YuiBot.getInstance().getCommandHandler().handle(new Context(bot));
    }
}