package net.yoloo.obsidian.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.yoloo.obsidian.ObsidianPlusMod;

public class ModItemsGroup {
    public static final ItemGroup OBSIDIAN = FabricItemGroupBuilder.build(new Identifier(ObsidianPlusMod.MOD_ID, "obsidian"),
            () -> new ItemStack(ModItems.OBSIDIAN_INGOT));
}
