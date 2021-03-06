package ga.shadow.sgshop.commands;

import ga.shadow.sgshop.ShopData;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Gives you Crescent Rose", usage = "/<command>", aliases = "cr")
public class Command_scythe extends FreedomCommand {
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        ShopData sd = plugin.sh.getData(playerSender);
        if (!sd.isScythe()) {
            msg("You have not yet purchased the Scythe from the shop!", ChatColor.RED);
            return true;
        }
        playerSender.getInventory().addItem(plugin.sc.getCrescentRose());
        msg("You have been given the Scythe!", ChatColor.GREEN);
        return true;
    }
}