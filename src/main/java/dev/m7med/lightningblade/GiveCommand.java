package dev.m7med.lightningblade;

import dev.velix.imperat.BukkitSource;
import dev.velix.imperat.annotations.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Command("swords")
@Description("The Almighty God blesses us with divine swords of immense power")
@Permission("custom.swords")
public class GiveCommand {

    @Usage
    public void onUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW + "Usage: " + ChatColor.GREEN + "/swords [item] [amount] [player]");
    }
    @Usage
    public void sword(
            BukkitSource sender,
            @NotNull @Named("item") @Suggest("lightning") String item,
            @Optional @Named("player") Player player
    ) {

        if (player == null) {
            if (sender.isConsole()) {
                sender.reply(ChatColor.RED + "You need to specify a player!");
                return;
            }
            player = sender.asPlayer();
        }

        giveSword(sender, item,player);
    }

    private void giveSword(BukkitSource sender, String item, Player player) {
        switch(item.toLowerCase()) {
            case "lightning":

                player.getInventory().addItem(LightningBlade.getInstance().getCustomItem().itemBuilder());

                Map<String, String> placeholders = Map.of(
                        "item", item,
                        "player", player.getName(),
                        "sender", sender.asPlayer() != null ? sender.asPlayer().getName() : "Console"
                );

                if (sender.asPlayer() != null && sender.asPlayer().equals(player)) {
                    player.sendMessage(LightningBlade.getInstance().getConfigManger().get(
                            "playerGiveHimself",
                            placeholders,"<green>You have been blessed with <aqua>%item%</aqua></yellow>!"

                    ));
                    return;
                }

                    sender.asPlayer().sendMessage(
                            LightningBlade.getInstance().getConfigManger().get(
                                    "playerGaveAnother",
                                    placeholders, "<green>You gave <aqua>%item%</aqua></yellow> to <blue>%player%</blue>!"

                            )
                    );


                player.sendMessage(
                        LightningBlade.getInstance().getConfigManger().get(
                                "playerReceivedFrom",
                                placeholders,
                       "<green>You received <aqua>%item%</aqua></yellow> from <blue>%player%</blue>!"
                        )
                );
                break;

            default:
                sender.reply(ChatColor.RED + "Unknown item: " + item + ". Available items: lighting");
                break;
        }
    }
}