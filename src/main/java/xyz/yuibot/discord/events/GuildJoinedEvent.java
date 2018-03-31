package xyz.yuibot.discord.events;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import xyz.yuibot.discord.core.entities.YuiEmoji;

public class GuildJoinedEvent {
    public GuildJoinedEvent(GuildJoinEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById(426101503665635328L);
        Guild guild = event.getGuild();

        channel.sendMessage(
                new EmbedBuilder()
                        .setTitle("Yui Hirasawa - Joined Guild")
                        .setDescription(YuiEmoji.SUCCESS + " `|` Joined a guild!")
                        .addField("Guild Name", guild.getName(), true)
                        .addField("Guild ID", guild.getId(), true)
                        .addField("Guild Members (Size)", guild.getMembers().size() + " Members", true)
                        .addField("Guild Region", guild.getRegion().toString(), true)
                        .addField("Guild Creation Date", guild.getCreationTime().toString(), true)
                        .setFooter("Yayy! I joined a new guild =w=, I hope they l-like me. :<", event.getJDA().getSelfUser().getEffectiveAvatarUrl())
                        .build()
        ).queue();
    }
}