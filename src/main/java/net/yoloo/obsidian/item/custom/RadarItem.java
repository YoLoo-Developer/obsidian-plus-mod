package net.yoloo.obsidian.item.custom;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.yoloo.obsidian.block.ModBlocks;
import net.yoloo.obsidian.util.ModTags;

class Ore {
    int amount = 0;
    int distance = -1;
    int height = -1;
}

public class RadarItem extends Item {

    public RadarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.obsidian.radar_shift"));
        } else {
            tooltip.add(new TranslatableText("tooltip.obsidian.radar"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());

            Ore obsidianOre = new Ore();
            Ore diamondOre = new Ore();
            Ore lapisOre = new Ore();
            Ore goldOre = new Ore();
            Ore redOre = new Ore();
            Ore ironOre = new Ore();
            Ore copperOre = new Ore();

            for (int y = -15; y <= 16; y++) {
                for (int x = -15; x <= 16; x++) {
                    for (int z = -15; z <= 16; z++) {
                        BlockPos blockPos = positionClicked.add(x, y, z);
                        Block blockCurrent = context.getWorld().getBlockState(blockPos).getBlock();

                        //Obsidian
                        if (blockCurrent == ModBlocks.OBSIDIAN_ORE || blockCurrent == ModBlocks.DEEPSLATE_OBSIDIAN_ORE)
                            setInfoOre(obsidianOre, player.getPos(), blockPos);
                        //Diamond
                        else if (blockCurrent == Blocks.DIAMOND_ORE || blockCurrent == Blocks.DEEPSLATE_DIAMOND_ORE)
                            setInfoOre(diamondOre, player.getPos(), blockPos);
                        //Lapis
                        else if (blockCurrent == Blocks.LAPIS_ORE || blockCurrent == Blocks.DEEPSLATE_LAPIS_ORE)
                            setInfoOre(lapisOre, player.getPos(), blockPos);
                        //Gold
                        else if (blockCurrent == Blocks.GOLD_ORE || blockCurrent == Blocks.DEEPSLATE_GOLD_ORE)
                            setInfoOre(goldOre, player.getPos(), blockPos);
                        //Red
                        else if (blockCurrent == Blocks.REDSTONE_ORE || blockCurrent == Blocks.DEEPSLATE_REDSTONE_ORE)
                            setInfoOre(redOre, player.getPos(), blockPos);
                        //Iron
                        else if (blockCurrent == Blocks.IRON_ORE || blockCurrent == Blocks.DEEPSLATE_IRON_ORE)
                            setInfoOre(ironOre, player.getPos(), blockPos);
                        //Copper
                        else if (blockCurrent == Blocks.COPPER_ORE || blockCurrent == Blocks.DEEPSLATE_COPPER_ORE)
                            setInfoOre(copperOre, player.getPos(), blockPos);
                    }
                }
            }

            player.sendMessage(new LiteralText("§BRadar information: "), false);
            getInfoOre(player, "Obsidian", obsidianOre);
            getInfoOre(player, "Diamond", diamondOre);
            getInfoOre(player, "Lapis", lapisOre);
            getInfoOre(player, "Gold", goldOre);
            getInfoOre(player, "Redstone", redOre);
            getInfoOre(player, "Iron", ironOre);
            getInfoOre(player, "Copper", copperOre);
        }

        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void setInfoOre(Ore ore, Vec3d playerPos, BlockPos orePos) {
        ore.amount++;
        Double blockDist = Math.sqrt((playerPos.getX() - orePos.getX()) * (playerPos.getX() - orePos.getX())
                + (playerPos.getZ() - orePos.getZ()) * (playerPos.getZ() - orePos.getZ()));

        if (ore.distance < blockDist) {
            ore.distance = blockDist.intValue();
            ore.height = orePos.getY() - (int)playerPos.getY();
        }
    }

    private void getInfoOre(PlayerEntity player, String nameOre, Ore ore) {
        player.sendMessage(new LiteralText("§7" + nameOre + " §7ore " + "§2" + ore.amount + " blocks, " +
                "§7distance: " + "§7" + ore.distance  + "§7, " + "§7height: " + "§7" + ore.height), false);
    }
}
