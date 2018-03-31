package xyz.yuibot.discord.core.entities;

public enum YuiEmoji {
    SUCCESS(":white_check_mark:"),
    FAIL(":x:"),
    NOENTRY(":name_badge:");

    private String string;

    YuiEmoji(String meaning) {
        this.string = meaning;
    }

    @Override
    public String toString() {
        return string;
    }
}