package net.mpunans.diddypack;

import net.fabricmc.api.ModInitializer;

import net.mpunans.diddypack.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diddypack implements ModInitializer {
	public static final String MOD_ID = "diddypack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}