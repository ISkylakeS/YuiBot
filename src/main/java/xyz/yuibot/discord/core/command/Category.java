package xyz.yuibot.discord.core.command;

public enum Category {
    CORE("Core"),
    MOD("Moderation"),
    NSFW("NSFW"),
    UPVOTER("Upvoters"),
    UTIL("Utility");

    private String string;

    Category(String meaning) {
        this.string = meaning;
    }

    @Override
    public String toString() {
        return string;
    }
}