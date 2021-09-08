package net.nether.remastered;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;


public class main implements ModInitializer{
    
    public static final ItemGroup NETHEREM_ITEMGROUP = FabricItemGroupBuilder.build(new Identifier("netherem", "netherem_tab"),() -> new ItemStack(Items.NETHERRACK));
    
    private static final Identifier RUINED_PORTAL_CHEST_LOOT_TABLE_ID = new Identifier("minecrat:chests/ruined_portal");
    public void onInitialize(){
        registerBlocks();
        registerItems();
        registerCrafting();
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (LootTables.RUINED_PORTAL_CHEST.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(main.OBBY_LIGHTER));
        table.pool(poolBuilder);
            }
        });
    }

    private void registerCrafting() {

    }

    // -===- blocks -===-
    // - Obsidian Test -
    public static final Block OBBY_TEST = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_TEST_I = new BlockItem(OBBY_TEST, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Coal -
    public static final Block OBBY_COAL = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_COAL_I = new BlockItem(OBBY_COAL, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Copper -
    public static final Block OBBY_COPPER = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_COPPER_I = new BlockItem(OBBY_COPPER, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Diamond -
    public static final Block OBBY_DIAMOND = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_DIAMOND_I = new BlockItem(OBBY_DIAMOND, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Dripstone -
    public static final Block OBBY_DRIPSTONE = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_DRIPSTONE_I = new BlockItem(OBBY_DRIPSTONE, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Emerald -
    public static final Block OBBY_EMERALD = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_EMERALD_I = new BlockItem(OBBY_EMERALD, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Gold -
    public static final Block OBBY_GOLD = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_GOLD_I = new BlockItem(OBBY_GOLD, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Iron -
    public static final Block OBBY_IRON = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_IRON_I = new BlockItem(OBBY_IRON, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Lapis -
    public static final Block OBBY_LAPIS = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_LAPIS_I = new BlockItem(OBBY_LAPIS, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Lava -
    public static final Block OBBY_LAVA = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_LAVA_I = new BlockItem(OBBY_LAVA, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Mossy Cobblestone -
    public static final Block OBBY_MOSSY = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_MOSSY_I = new BlockItem(OBBY_MOSSY, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Portal Frame -
    public static final Block OBBY_PORTAL = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_PORTAL_I = new BlockItem(OBBY_PORTAL, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Redstone -
    public static final Block OBBY_REDSTONE = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_REDSTONE_I = new BlockItem(OBBY_REDSTONE, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Water -
    public static final Block OBBY_WATER = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_WATER_I = new BlockItem(OBBY_WATER, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Amethyst -
    public static final Block OBBY_AMETHYST = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_AMETHYST_I = new BlockItem(OBBY_AMETHYST, new Item.Settings().group(NETHEREM_ITEMGROUP));
    // - Obsidian Deepslate -
    public static final Block OBBY_DEEP = new Block(FabricBlockSettings.of(Material.METAL).strength(20, 1200).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL));
    public static final BlockItem OBBY_DEEP_I = new BlockItem(OBBY_DEEP, new Item.Settings().group(NETHEREM_ITEMGROUP));

    public static void registerBlocks(){
        // - Obsidian Test -c
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_test"), OBBY_TEST);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_test_i"), OBBY_TEST_I);
        // - Obsidian Coal -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_coal"), OBBY_COAL);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_coal_i"), OBBY_COAL_I);
        // - Obsidian Copper -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_copper"), OBBY_COPPER);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_copper_i"), OBBY_COPPER_I);
        // - Obsidian Diamond -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_diamond"), OBBY_DIAMOND);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_diamond_i"), OBBY_DIAMOND_I);
        // - Obsidian Dripstone -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_dripstone"), OBBY_DRIPSTONE);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_dripstone_i"), OBBY_DRIPSTONE_I);
        // - Obsidian Dripstone -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_emerald"), OBBY_EMERALD);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_emerald_i"), OBBY_EMERALD_I);
        // - Obsidian Gold -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_gold"), OBBY_GOLD);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_gold_i"), OBBY_GOLD_I);
        // - Obsidian Iron -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_iron"), OBBY_IRON);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_iron_i"), OBBY_IRON_I);
        // - Obsidian Lapis -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_lapis"), OBBY_LAPIS);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_lapis_i"), OBBY_LAPIS_I);
        // - Obsidian Lava -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_lava"), OBBY_LAVA);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_lava_i"), OBBY_LAVA_I);
        // - Obsidian Mossy Cobblestone -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_mossy"), OBBY_MOSSY);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_mossy_i"), OBBY_MOSSY_I);
        // - Obsidian Portal Frame -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_portal"), OBBY_PORTAL);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_portal_i"), OBBY_PORTAL_I);
        // - Obsidian Redstone -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_redstone"), OBBY_REDSTONE);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_redstone_i"), OBBY_REDSTONE_I);
        // - Obsidian Water -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_water"), OBBY_WATER);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_water_i"), OBBY_WATER_I);
        // - Obsidian Amethyst -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_amethyst"), OBBY_AMETHYST);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_amethyst_i"), OBBY_AMETHYST_I);
        // - Obsidian Deepslate -
        Registry.register(Registry.BLOCK, new Identifier("netherem", "obby_deep"), OBBY_DEEP);
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_deep_i"), OBBY_DEEP_I);
    }
    
    // -===- items -===-
    // - Obsidian Lighter -
    public static final ObbyLighter OBBY_LIGHTER = new ObbyLighter(new Item.Settings().group(NETHEREM_ITEMGROUP).maxCount(1));

    public static void registerItems(){
        // - Obsidian lighter -
        Registry.register(Registry.ITEM, new Identifier("netherem", "obby_lighter"), OBBY_LIGHTER);
    }
}
