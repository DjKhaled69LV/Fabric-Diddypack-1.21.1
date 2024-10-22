package net.mpunans.diddypack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.mpunans.diddypack.block.ModBlocks;
import net.mpunans.diddypack.item.ModItemGroups;
import net.mpunans.diddypack.item.ModItems;
import net.mpunans.diddypack.item.custom.Vape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diddypack implements ModInitializer {
	public static final String MOD_ID = "diddypack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ServerTickEvents.END_WORLD_TICK.register(Vape::tick);
	}
}