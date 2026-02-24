package egor201.trimtooltipsplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class TrimTooltipsPlus implements ClientModInitializer {
    public static final boolean IS_STACK_TRIMS_LOADED = FabricLoader.getInstance().isModLoaded("stacked_trims");

    @Override
    public void onInitializeClient() {
        // Init
    }
}
