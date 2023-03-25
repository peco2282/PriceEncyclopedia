package com.github.peco2282.priceencyclopedia;

import com.github.peco2282.priceencyclopedia.config.ConfigHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings({"CommentedOutCode", "unused", "GrazieInspection"})
@Mod(PriceEncyclopedia.MODID)
public class PriceEncyclopedia {

  // Define mod id in a common place for everything to reference
  public static final String MODNAME = "PriceEncyclopedia";
  public static final String MODID = "priceencyclopedia";
  // Create a Deferred Register to hold Blocks which will all be registered under the "PriceEncyclopedia" namespace
  // public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();
  public ConfigHandler file;
  // Create a Deferred Register to hold Items which will all be registered under the "PriceEncyclopedia" namespace

  /**
   * public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
   * <p>
   * // Creates a new Block with the id "PriceEncyclopedia:example_block", combining the namespace and path
   * public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
   * // Creates a new BlockItem with the id "PriceEncyclopedia:example_block", combining the namespace and path
   * public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
   */
  public PriceEncyclopedia() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    // Register the commonSetup method for modloading
    modEventBus.addListener(this::commonSetup);
    /*
     // Register the Deferred Register to the mod event bus so blocks get registered
     BLOCKS.register(modEventBus);
     // Register the Deferred Register to the mod event bus so items get registered
     ITEMS.register(modEventBus);
     */
    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);

    // Register the item to a creative tab
    // modEventBus.addListener(this::addCreative);
  }

  public static Logger getLOGGER() {
    return LOGGER;
  }

  public static boolean isPlayingMammamia() {
    Minecraft mc = Minecraft.getInstance();
    ServerData data = mc.getCurrentServer();
    if (data == null) return false;
    return data.ip.contains("play.manmamiya");
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    if (FMLEnvironment.dist.isClient()) {
      file = ConfigHandler.getInstance();
      LOGGER.warn("get file instance.");
      file.load();
      KeyHandler.init();

      MinecraftForge.EVENT_BUS.register(this);
      MinecraftForge.EVENT_BUS.register(file);
      MinecraftForge.EVENT_BUS.register(new TooltipEvent());
    }
    // Some common setup code
    LOGGER.info("HELLO FROM COMMON SETUP");
    LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
  }

  /*
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
      if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
        event.accept(EXAMPLE_BLOCK_ITEM);
    }
  */
  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("HELLO from server starting");
  }

  // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
  @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      // Some client setup code
      LOGGER.info("HELLO FROM CLIENT SETUP");
      LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
  }
}
