package io.github.seggan.liquid.objects;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.github.seggan.liquid.Items;
import io.github.seggan.liquid.VanillaItems;
import io.github.seggan.liquid.machinery.Melter;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class LiquidMetal extends SlimefunItem {

    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_METALS = HashBiMap.create();
    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_CRYSTALS = HashBiMap.create();
    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_ORES = HashBiMap.create();
    private static final HashBiMap<SlimefunItemStack, ItemStack> MELTED_DUSTS = HashBiMap.create();
    private static final List<ItemStack> metals = Arrays.asList(
        SlimefunItems.ALUMINUM_BRASS_INGOT.item(),
        SlimefunItems.ALUMINUM_BRONZE_INGOT.item(),
        SlimefunItems.ALUMINUM_INGOT.item(),
        SlimefunItems.DURALUMIN_INGOT.item(),
        SlimefunItems.COBALT_INGOT.item(),
        SlimefunItems.NICKEL_INGOT.item(),
        SlimefunItems.GILDED_IRON.item(),
        SlimefunItems.GOLD_4K.item(),
        SlimefunItems.GOLD_6K.item(),
        SlimefunItems.GOLD_8K.item(),
        SlimefunItems.GOLD_10K.item(),
        SlimefunItems.GOLD_12K.item(),
        SlimefunItems.GOLD_14K.item(),
        SlimefunItems.GOLD_16K.item(),
        SlimefunItems.GOLD_18K.item(),
        SlimefunItems.GOLD_20K.item(),
        SlimefunItems.GOLD_22K.item(),
        SlimefunItems.GOLD_24K.item(),
        SlimefunItems.STEEL_INGOT.item(),
        SlimefunItems.DAMASCUS_STEEL_INGOT.item(),
        SlimefunItems.COPPER_INGOT.item(),
        SlimefunItems.BRASS_INGOT.item(),
        SlimefunItems.BRONZE_INGOT.item(),
        SlimefunItems.CORINTHIAN_BRONZE_INGOT.item(),
        SlimefunItems.HARDENED_METAL_INGOT.item(),
        SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
        SlimefunItems.REDSTONE_ALLOY.item(),
        SlimefunItems.TIN_INGOT.item(),
        SlimefunItems.ZINC_INGOT.item(),
        SlimefunItems.LEAD_INGOT.item(),
        SlimefunItems.SILVER_INGOT.item(),
        SlimefunItems.MAGNESIUM_INGOT.item(),
        SlimefunItems.CARBON.item(),
        SlimefunItems.URANIUM.item(),
        SlimefunItems.BOOSTED_URANIUM.item(),
        SlimefunItems.NEPTUNIUM.item(),
        SlimefunItems.PLUTONIUM.item(),
        SlimefunItems.SILICON.item(),
        SlimefunItems.FERROSILICON.item(),
        SlimefunItems.SOLDER_INGOT.item(),
        SlimefunItems.BILLON_INGOT.item(),
        SlimefunItems.SULFATE.item(),
        SlimefunItems.MAGNET.item(),
        SlimefunItems.CARBONADO.item(),
        Items.SLAG.item(),
        VanillaItems.IRON_INGOT,
        VanillaItems.GOLD_INGOT,
        VanillaItems.REDSTONE,
        VanillaItems.NETHERITE
    );
    private static final List<ItemStack> crystals = Arrays.asList(
        VanillaItems.LAPIS,
        VanillaItems.DIAMOND,
        VanillaItems.EMERALD,
        SlimefunItems.SALT.item(),
        SlimefunItems.MAGNESIUM_SALT.item()
    );

    private static final List<ItemStack> ores = Arrays.asList(
        VanillaItems.IRON_ORE,
        VanillaItems.GOLD_ORE,
        VanillaItems.REDSTONE_ORE,
        VanillaItems.LAPIS_ORE,
        VanillaItems.DIAMOND_ORE,
        VanillaItems.EMERALD_ORE,
        VanillaItems.NETHERITE_ORE
    );

    static {
        MELTED_DUSTS.put(SlimefunItems.IRON_DUST, VanillaItems.IRON_INGOT);
        MELTED_DUSTS.put(SlimefunItems.COPPER_DUST, SlimefunItems.COPPER_INGOT.item());
        MELTED_DUSTS.put(SlimefunItems.ALUMINUM_DUST, SlimefunItems.ALUMINUM_INGOT.item());
        MELTED_DUSTS.put(SlimefunItems.GOLD_DUST, VanillaItems.GOLD_INGOT);
        MELTED_DUSTS.put(SlimefunItems.SILVER_DUST, SlimefunItems.SILVER_INGOT.item());
        MELTED_DUSTS.put(SlimefunItems.LEAD_DUST, SlimefunItems.LEAD_INGOT.item());
        MELTED_DUSTS.put(SlimefunItems.TIN_DUST, SlimefunItems.TIN_INGOT.item());
        MELTED_DUSTS.put(SlimefunItems.MAGNESIUM_DUST, SlimefunItems.MAGNESIUM_INGOT.item());
    }

    public LiquidMetal(SlimefunItemStack item, ItemStack solid) {
        super(Items.CATEGORY, item, Melter.RECIPE_TYPE, new ItemStack[]{
            solid, new ItemStack(Material.BUCKET), null,
            null, null, null,
            null, null, null
        });

        addItemHandler((ItemUseHandler) PlayerRightClickEvent::cancel);
    }

    public static List<ItemStack> getMetals() {
        return metals;
    }

    public static List<ItemStack> getCrystals() {
        return crystals;
    }

    public static List<ItemStack> getOres() {
        return ores;
    }


    public static void addLiquid(ItemStack metal, SlimefunItemStack liquid) {
        MELTED_METALS.put(metal, liquid);
    }

    public static void addCrystal(ItemStack crystal, SlimefunItemStack liquid) {
        MELTED_CRYSTALS.put(crystal, liquid);
    }

    public static void addOre(ItemStack ore, SlimefunItemStack liquid) {
        MELTED_ORES.put(ore, liquid);
    }


    public static BiMap<ItemStack, SlimefunItemStack> getLiquids() {
        return MELTED_METALS;
    }

    public static BiMap<ItemStack, SlimefunItemStack> getLiquidCrystals() {
        return MELTED_CRYSTALS;
    }

    public static BiMap<ItemStack, SlimefunItemStack> getLiquidOres() {
        return MELTED_ORES;
    }

    public static HashBiMap<SlimefunItemStack, ItemStack> getLiquidDusts() {
        return MELTED_DUSTS;
    }

}
