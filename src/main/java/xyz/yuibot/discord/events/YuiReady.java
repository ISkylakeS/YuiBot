package xyz.yuibot.discord.events;

import net.dv8tion.jda.core.events.ReadyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YuiReady
{
    Logger log = LoggerFactory.getLogger(YuiReady.class);

    public YuiReady(ReadyEvent event)
    {
        log.info("Yui Hirasawa is ready!\nGuilds: " + event.getJDA().getGuilds().size() + "\nUsers: " + event.getJDA().getUsers().size());
    }
}