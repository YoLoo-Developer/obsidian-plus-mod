package net.yoloo.obsidian.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yoloo.obsidian.ObsidianPlusMod;
import net.yoloo.obsidian.item.custom.ObsidianPickaxe;
import net.yoloo.obsidian.item.custom.RadarItem;

public class ModItems {
    //Raw Obsidian
    public static final Item OBSIDIAN_RAW = registerItem("obsidian_raw",
            new Item(new FabricItemSettings().group(ModItemsGroup.OBSIDIAN)));
    //Obsidian Ingot
    public static final Item OBSIDIAN_INGOT = registerItem("obsidian_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.OBSIDIAN)));
    //Obsidian Nugget
    public static final Item OBSIDIAN_NUGGET = registerItem("obsidian_nugget",
            new Item(new FabricItemSettings().group(ModItemsGroup.OBSIDIAN)));
    //Radar
    public static final Item OBSIDIAN_RADAR = registerItem("obsidian_radar",
            new RadarItem(new FabricItemSettings().group(ModItemsGroup.OBSIDIAN).maxDamage(32)));
    //Pickaxe
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            new ObsidianPickaxe(ModToolMaterial.OBSIDIAN, 1, 0f,
                    new FabricItemSettings().group(ModItemsGroup.OBSIDIAN)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ObsidianPlusMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + ObsidianPlusMod.MOD_ID + " successfully");
    }
}
