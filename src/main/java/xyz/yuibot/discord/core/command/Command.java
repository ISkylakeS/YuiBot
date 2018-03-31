package xyz.yuibot.discord.core.command;

import xyz.yuibot.discord.core.entities.Context;

public interface Command {
    void execute(String args, Context ctx);

    default ICommand getInfo() {
        return this.getClass().getAnnotation(ICommand.class);
    }
}