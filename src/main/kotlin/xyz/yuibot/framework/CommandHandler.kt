package xyz.yuibot.framework

import xyz.yuibot.discord.core.entities.Context
import org.reflections.Reflections
import xyz.yuibot.discord.core.command.Command
import xyz.yuibot.discord.core.command.ICommand
import xyz.yuibot.discord.core.entities.YuiEmoji

import java.util.HashMap

class CommandHandler {
    companion object {
        public val commands = HashMap<String, Command>()
    }

    init {
        val loader = Reflections("xyz.yuibot.discord.commands")

        loader.getTypesAnnotatedWith(ICommand::class.java).forEach({ command ->
            val cmd = command.newInstance() as Command

            if (cmd.info.isEnabled)
                commands[cmd.info.name] = cmd
        })
    }

    fun getCommands(): HashMap<String, Command> {
        return commands
    }

    fun handle(ctx: Context) {
        if (ctx.author.isFake || ctx.author.isBot || !ctx.guild.isAvailable)
            return

        val prefix = "yui!"
        val wasMentioned = ctx.message.contentRaw.startsWith(ctx.guild.selfMember.asMention)
        val trigger = if (wasMentioned) ctx.guild.selfMember.asMention.length + 1 else prefix.length

        if (!ctx.message.contentDisplay.startsWith(prefix) && !wasMentioned)
            return

        if (wasMentioned && !ctx.message.contentRaw.contains(" "))
            return

        val content = ctx.message.contentRaw.substring(trigger).trim()
        val command = content.split("\\s+".toRegex())[0]
        val args = content.substring(command.length).trim()


        val cmd = commands
                .filter({ c -> c.key == command || c.value.info.aliases.contains(command) })
                .values
                .firstOrNull()

        if (cmd == null)
            return

        if (cmd.info.isDev && ctx.author.id.equals("280158289667555328")) {
            ctx.sendMessage(YuiEmoji.NOENTRY, "Sorry, you don't have permission to execute this command.")
        }

        cmd.execute(args, ctx)
    }
}