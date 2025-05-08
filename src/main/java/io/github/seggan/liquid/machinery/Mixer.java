package io.github.seggan.liquid.machinery;

import com.google.common.collect.BiMap;
import io.github.seggan.liquid.Items;
import io.github.seggan.liquid.Liquid;
import io.github.seggan.liquid.VanillaItems;
import io.github.seggan.liquid.objects.LContainer;
import io.github.seggan.liquid.objects.LiquidMetal;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

public class Mixer extends LContainer implements RecipeDisplayItem {

    public static final RecipeType RECIPE_TYPE = new RecipeType(
        new NamespacedKey(Liquid.getInstance(), "mixer"),
        Items.MIXER
    );


    public Mixer(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {
        BiMap<ItemStack, SlimefunItemStack> liquids = LiquidMetal.getLiquids();
        BiMap<ItemStack, SlimefunItemStack> crystals = LiquidMetal.getLiquidCrystals();
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item(),
                liquids.get(SlimefunItems.ZINC_INGOT.item()).item(), liquids.get(SlimefunItems.STEEL_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.HARDENED_METAL_INGOT.item()), 4).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.TIN_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.BRONZE_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.ZINC_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.BRASS_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.BRONZE_INGOT.item()).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.ALUMINUM_BRONZE_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.BRASS_INGOT.item()).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.ALUMINUM_BRASS_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item(),
                liquids.get(SlimefunItems.TIN_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.ALUMINUM_BRONZE_INGOT.item()), 3).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item(),
                liquids.get(SlimefunItems.ZINC_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.ALUMINUM_BRASS_INGOT.item()), 3).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.CARBONADO.item()).item(), liquids.get(VanillaItems.IRON_INGOT).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.STEEL_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT).item(), liquids.get(SlimefunItems.ALUMINUM_INGOT).item(),
                liquids.get(SlimefunItems.GOLD_12K.item()).item(), liquids.get(SlimefunItems.HARDENED_METAL_INGOT.item()).item(),
                liquids.get(SlimefunItems.LEAD_INGOT.item()).item(), liquids.get(SlimefunItems.STEEL_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.REINFORCED_ALLOY_INGOT.item()), 3).item(),
                new SlimefunItemStack(liquids.get(Items.SLAG.item()), 3).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(SlimefunItems.GOLD_12K.item()).item(),
                liquids.get(SlimefunItems.TIN_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.CORINTHIAN_BRONZE_INGOT.item()), 2).item(),
                liquids.get(Items.SLAG.item()).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.TIN_INGOT.item()).item(), liquids.get(SlimefunItems.LEAD_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.SOLDER_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.SILVER_INGOT.item()).item(), liquids.get(SlimefunItems.COPPER_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.BILLON_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.SILICON).item(), liquids.get(VanillaItems.IRON_INGOT).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.FERROSILICON.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.HARDENED_METAL_INGOT.item()).item(), liquids.get(VanillaItems.REDSTONE).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.REDSTONE_ALLOY.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COPPER_INGOT.item()).item(), liquids.get(VanillaItems.IRON_INGOT).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.NICKEL_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.NICKEL_INGOT.item()).item(), liquids.get(VanillaItems.IRON_INGOT).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.COBALT_INGOT.item()), 2).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.COBALT_INGOT.item()).item(), liquids.get(SlimefunItems.NICKEL_INGOT.item()).item(),
                liquids.get(SlimefunItems.ALUMINUM_INGOT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(liquids.get(SlimefunItems.MAGNESIUM_INGOT.item()), 3).item()
            }
        );
        registerRecipe(
            3,
            new ItemStack[]{
                liquids.get(SlimefunItems.MAGNESIUM_INGOT.item()).item(), crystals.get(SlimefunItems.SALT.item()).item()
            },
            new ItemStack[]{
                new SlimefunItemStack(crystals.get(SlimefunItems.MAGNESIUM_SALT.item()), 2).item()
            }
        );
    }

    @Nonnull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 2);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(CustomItemStack.create(
                new ItemStack(Material.LAVA_BUCKET, recipe.getInput().length),
                "&3Multiple Input Recipe")); // Can't exactly show all 9 items at once
            displayRecipes.add(recipe.getOutput()[0]); // Main output should be the first item
        }

        return displayRecipes;
    }

    @Override
    public int getInventoryType() {
        return 0;
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    @Override
    public int getEnergyConsumption() {
        return 64;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public String getMachineIdentifier() {
        return "MIXER";
    }

    @Override
    public int getCapacity() {
        return 128;
    }
}
