package io.github.seggan.liquid;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.ItemUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import org.bukkit.inventory.ItemStack;

public final class Util {

    private Util() {}

    public static String getID(ItemStack stack) {
        SlimefunItem sfItem = SlimefunItem.getByItem(stack);
        if (sfItem != null) {
            return sfItem.getId();
        } else {
            return ChatUtils.removeColorCodes(ItemUtils.getItemName(stack))
                .toUpperCase().replace(" ", "_");
        }
    }
}
