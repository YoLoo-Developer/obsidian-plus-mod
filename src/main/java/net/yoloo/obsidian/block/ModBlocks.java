package net.yoloo.obsidian.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.yoloo.obsidian.ObsidianPlusMod;
import net.yoloo.obsidian.block.custom.*;
import net.yoloo.obsidian.item.ModItemsGroup;

public class ModBlocks {
    //Deepslate obsidian ore
    public static final Block DEEPSLATE_OBSIDIAN_ORE = registerBlock("deepslate_obsidian_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Obsidian ore
    public static final Block OBSIDIAN_ORE = registerBlock("obsidian_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Speed block
    public static final Block SPEED_BLOCK = registerBlock("speed_block",
            new SpeedBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Jump block
    public static final Block JUMP_BLOCK = registerBlock("jump_block",
            new JumpBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Obsidian Stairs Block
    public static final Block OBSIDIAN_STAIRS = registerBlock("obsidian_stairs",
            new ObsidianStairs(Blocks.OBSIDIAN.getDefaultState(),
                    FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Obsidian slab
    public static final Block OBSIDIAN_SLAB = registerBlock("obsidian_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Obsidian button
    public static final Block OBSIDIAN_BUTTON = registerBlock("obsidian_button",
            new ObsidianButton(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemsGroup.OBSIDIAN);
    //Obsidian plate
    public static final Block OBSIDIAN_PLATE = registerBlock("obsidian_plate",
            new ObsidianPlate(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemsGroup.OBSIDIAN);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ObsidianPlusMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(ObsidianPlusMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for " + ObsidianPlusMod.MOD_ID + " successfully");
    }
}
