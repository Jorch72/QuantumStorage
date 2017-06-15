package QuantumStorage.init;

import QuantumStorage.api.QuantumStorageAPI;
import QuantumStorage.compat.CompatHandler;
import QuantumStorage.config.ConfigQuantumStorage;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import reborncore.common.util.RebornCraftingHelper;

/**
 * Created by Gigabit101 on 07/03/2017.
 */
public class ModRecipes
{
    public static void init()
    {
        RebornCraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.CRATE, 16),
                " W ",
                "WPW",
                " W ",
                'W', "plankWood",
                'P', new ItemStack(Items.PAPER));

        RebornCraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.UPGRADE, 1, 3),
                " W ",
                "WPW",
                " W ",
                'W', new ItemStack(Items.PAPER),
                'P', new ItemStack(Items.WATER_BUCKET));

        if (Loader.isModLoaded("refinedstorage"))
        {
            QuantumStorageAPI.addAltarRecipe(new ItemStack(Items.NETHER_STAR, 1), new ItemStack(CompatHandler.DISK, 1), ConfigQuantumStorage.defaultDiskTime);
        }
    }
}
