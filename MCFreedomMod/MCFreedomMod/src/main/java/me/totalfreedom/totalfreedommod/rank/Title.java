package me.totalfreedom.totalfreedommod.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Title implements Displayable
{

    DEVELOPER("a", "TF Developer", ChatColor.BLACK, "TF Dev"),
    DONATOR("a", "Donator", ChatColor.YELLOW, "Donator"),
    SERVER_MANAGER("the", "Server Manager", ChatColor.DARK_RED, "Manager"),
    DEV("a", "Developer", ChatColor.DARK_PURPLE, "Dev"),
    LEAD_DEV("the", "Lead Developer", ChatColor.DARK_PURPLE, "Dev"),
    COOWNER("a", "Co-Owner", ChatColor.BLUE, "Co-Owner"),
    OWNER("the", "Owner", ChatColor.BLUE, "Owner");

    private final String determiner;
    @Getter
    private final String name;
    @Getter
    private final String tag;
    @Getter
    private final String coloredTag;
    @Getter
    private final ChatColor color;

    private Title(String determiner, String name, ChatColor color, String tag)
    {
        this.determiner = determiner;
        this.name = name;
        this.tag = "[" + tag + "]";
        this.coloredTag = ChatColor.DARK_GRAY + "[" + color + tag + ChatColor.DARK_GRAY + "]" + color;
        this.color = color;
    }

    @Override
    public String getColoredName()
    {
        return color + name;
    }

    @Override
    public String getColoredLoginMessage()
    {
        return determiner + " " + color + ChatColor.ITALIC + name;
    }

}
