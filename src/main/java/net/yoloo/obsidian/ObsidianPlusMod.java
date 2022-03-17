package net.yoloo.obsidian;

import net.fabricmc.api.ModInitializer;
import net.yoloo.obsidian.block.ModBlocks;
import net.yoloo.obsidian.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObsidianPlusMod implements ModInitializer {
	public static final String MOD_ID = "obsidian";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
