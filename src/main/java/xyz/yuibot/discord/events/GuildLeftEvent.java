package xyz.yuibot.discord.events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import xyz.yuibot.discord.core.entities.YuiEmoji;


public class GuildLeftEvent
{
    public GuildLeftEvent(GuildLeaveEvent event)
    {
        TextChannel channel = event.getJDA().getTextChannelById(426101503665635328L);
        Guild guild = event.getGuild();

        channel.sendMessage(
                new EmbedBuilder()
                        .setTitle("Yui Hirasawa - Left Guild")
                        .setDescription(YuiEmoji.FAIL + " `|` Left a guild!")
                        .addField("Guild Name", guild.getName(), true)
                        .addField("Guild ID", guild.getId(), true)
                        .addField("Guild Members (Size)", guild.getMembers().size() + " Members", true)
                        .addField("Guild Region", guild.getRegion().toString(), true)
                        .addField("Guild Creation Date", guild.getCreationTime().toString(), true)
                        .setFooter("I-I guess they don't like me? *crys*", event.getJDA().getSelfUser().getEffectiveAvatarUrl())
                        .build()
        ).queue();
    }
}