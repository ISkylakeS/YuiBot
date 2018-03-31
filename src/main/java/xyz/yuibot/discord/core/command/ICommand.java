package xyz.yuibot.discord.core.command;

public @interface ICommand {
    String name() default "No name? uwu~";
    String desc() default "No description? OwO~";
    String usage() default "No usages? :<";
    String[] aliases() default {};
    boolean isDev() default false;
    boolean isUpvoter() default false;
    boolean isEnabled() default true;
    Category category() default Category.CORE;
}