package io.github.seggan.liquid;

import io.github.seggan.liquid.categories.MixerCategory;
import io.github.seggan.liquid.machinery.Centrifuge;
import io.github.seggan.liquid.machinery.Crystallizer;
import io.github.seggan.liquid.machinery.Melter;
import io.github.seggan.liquid.machinery.Mixer;
import io.github.seggan.liquid.machinery.Solidifier;
import io.github.seggan.liquid.machinery.SpraySolidifier;
import io.github.seggan.liquid.objects.LiquidMetal;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.ItemUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Liquid extends JavaPlugin implements SlimefunAddon {

    public static Liquid instance = null;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        if (getConfig().getBoolean("options.auto-update", true) && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "Seggan/Liquid/master").start();
        }
        
        new Metrics(this, 9408);

        List<LiquidMetal> metals = new ArrayList<>();

        for (ItemStack metal : LiquidMetal.getMetals()) {
            SlimefunItemStack stack = new SlimefunItemStack(
                "MOLTEN_" + Util.getID(metal).replace("_INGOT", ""),
                Material.LAVA_BUCKET,
                "&6Molten " + ChatUtils.removeColorCodes(ItemUtils.getItemName(metal))
                    .replace(" Ingot", "")
            );
            LiquidMetal.addLiquid(metal, stack);
            metals.add(new LiquidMetal(stack, metal));
        }

        for (ItemStack crystal : LiquidMetal.getCrystals()) {
            SlimefunItemStack stack = new SlimefunItemStack(
                "MOLTEN_" + Util.getID(crystal),
                Material.LAVA_BUCKET,
                "&6Molten " + ChatUtils.removeColorCodes(ItemUtils.getItemName(crystal))
            );
            LiquidMetal.addCrystal(crystal, stack);
            metals.add(new LiquidMetal(stack, crystal));
        }

        for (ItemStack ore : LiquidMetal.getOres()) {
            SlimefunItemStack stack = new SlimefunItemStack(
                "MOLTEN_" + Util.getID(ore),
                Material.LAVA_BUCKET,
                "&6Molten " + ChatUtils.removeColorCodes(ItemUtils.getItemName(ore))
            );
            LiquidMetal.addOre(ore, stack);
            metals.add(new LiquidMetal(stack, ore));
        }

        new Melter(Items.CATEGORY, Items.MELTER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.HEATING_COIL.item(), SlimefunItems.HEATING_COIL.item(), SlimefunItems.HEATING_COIL.item(),
            SlimefunItems.HEATING_COIL.item(), SlimefunItems.ELECTRIFIED_CRUCIBLE_3.item(), SlimefunItems.HEATING_COIL.item(),
            SlimefunItems.HEATING_COIL.item(), SlimefunItems.HEATING_COIL.item(), SlimefunItems.HEATING_COIL.item()
        }).register(this);

        new Solidifier(Items.CATEGORY, Items.SOLIDIFIER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.COOLING_UNIT.item(), SlimefunItems.COOLING_UNIT.item(), SlimefunItems.COOLING_UNIT.item(),
            SlimefunItems.COOLING_UNIT.item(), SlimefunItems.FREEZER_2.item(), SlimefunItems.COOLING_UNIT.item(),
            SlimefunItems.COOLING_UNIT.item(), SlimefunItems.COOLING_UNIT.item(), SlimefunItems.COOLING_UNIT.item()
        }).register(this);

        new SpraySolidifier(Items.CATEGORY, Items.SPRAY_SOLIDIFIER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.HEATING_COIL.item(), Items.SOLIDIFIER.item(), SlimefunItems.HEATING_COIL.item(),
            new ItemStack(Material.IRON_NUGGET), SlimefunItems.COOLING_UNIT.item(), new ItemStack(Material.IRON_NUGGET),
            SlimefunItems.REINFORCED_PLATE.item(), SlimefunItems.REINFORCED_PLATE.item(), SlimefunItems.REINFORCED_PLATE.item()
        }).register(this);

        new Mixer(Items.CATEGORY, Items.MIXER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.CARBONADO.item(), SlimefunItems.HEATING_COIL.item(), SlimefunItems.CARBONADO.item(),
            SlimefunItems.HEATING_COIL.item(), Items.MELTER.item(), SlimefunItems.HEATING_COIL.item(),
            SlimefunItems.CARBONADO.item(), SlimefunItems.HEATING_COIL.item(), SlimefunItems.CARBONADO.item()
        }).register(this);

        new Centrifuge(Items.CATEGORY, Items.CENTRIFUGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.REINFORCED_ALLOY_INGOT.item(), new ItemStack(Material.BOWL), SlimefunItems.REINFORCED_ALLOY_INGOT.item(),
            new ItemStack(Material.BOWL), SlimefunItems.ELECTRIC_DUST_WASHER_3.item(), new ItemStack(Material.BOWL),
            SlimefunItems.REINFORCED_ALLOY_INGOT.item(), new ItemStack(Material.BOWL), SlimefunItems.REINFORCED_ALLOY_INGOT.item()
        }).register(this);

        new Crystallizer(Items.CATEGORY, Items.CRYSTALLIZER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.COOLING_UNIT.item(), new ItemStack(Material.BOWL), SlimefunItems.COOLING_UNIT.item(),
            new ItemStack(Material.BOWL), Items.SOLIDIFIER.item(), new ItemStack(Material.BOWL),
            SlimefunItems.COOLING_UNIT.item(), new ItemStack(Material.BOWL), SlimefunItems.COOLING_UNIT.item()
        }).register(this);

        new SlimefunItem(Items.CATEGORY, Items.SLAG, Solidifier.RECIPE_TYPE, new ItemStack[]{
            LiquidMetal.getLiquids().get(Items.SLAG.item()).item(), null, null,
            null, null, null,
            null, null, null,
        }).register(this);

        metals.sort((o1, o2) -> ChatUtils.removeColorCodes(ItemUtils.getItemName(o1.getItem()))
            .replace(" Ingot", "")
            .replaceAll("\\(\\d+-Carat\\)", "")
            .compareToIgnoreCase(ChatUtils.removeColorCodes(ItemUtils.getItemName(o2.getItem()))
                .replace(" Ingot", "")
                .replaceAll("\\(\\d+-Carat\\)", "")));

        for (LiquidMetal metal : metals) {
            metal.register(this);
        }

        RecipeType.GRIND_STONE.register(new ItemStack[]{Items.SLAG.item()}, SlimefunItems.SIFTED_ORE.item());

        MixerCategory.INSTANCE.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static Liquid getInstance() {
        return instance;
    }

}
