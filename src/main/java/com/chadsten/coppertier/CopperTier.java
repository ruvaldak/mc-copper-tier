package com.chadsten.coppertier;

import com.chadsten.coppertier.item.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperTier implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("coppertier");

    public static final SwordItem COPPER_SWORD = new SwordItem(CopperToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final ShovelItem COPPER_SHOVEL = new ShovelItem(CopperToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final CopperPickaxeItem COPPER_PICKAXE = new CopperPickaxeItem(CopperToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final CopperAxeItem COPPER_AXE = new CopperAxeItem(CopperToolMaterial.INSTANCE, 6.5F, -3.2F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final CopperHoeItem COPPER_HOE = new CopperHoeItem(CopperToolMaterial.INSTANCE, -1, -1.5F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final ArmorItem COPPER_HELMET = new ArmorItem(CopperArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final ArmorItem COPPER_CHESTPLATE = new ArmorItem(CopperArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final ArmorItem COPPER_LEGGINGS = new ArmorItem(CopperArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final ArmorItem COPPER_BOOTS = new ArmorItem(CopperArmorMaterial.INSTANCE, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final HorseArmorItem COPPER_HORSE_ARMOR = new HorseArmorItem(4, "copper", new FabricItemSettings().maxCount(1).group(ItemGroup.MISC));
    public static final LootTableItem[] LOOT_TABLE = {
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 5, CopperTier.COPPER_PICKAXE),
            new LootTableItem(LootTables.VILLAGE_TOOLSMITH_CHEST, 5, CopperTier.COPPER_PICKAXE),
            new LootTableItem(LootTables.IGLOO_CHEST_CHEST, 2, CopperTier.COPPER_AXE),
            new LootTableItem(LootTables.UNDERWATER_RUIN_SMALL_CHEST, 2, CopperTier.COPPER_AXE),
            new LootTableItem(LootTables.RUINED_PORTAL_CHEST, 2, CopperTier.COPPER_AXE),
            new LootTableItem(LootTables.VILLAGE_TOOLSMITH_CHEST, 5, CopperTier.COPPER_SHOVEL),
            new LootTableItem(LootTables.VILLAGE_TOOLSMITH_CHEST, 3, CopperTier.COPPER_HOE),
            new LootTableItem(LootTables.STRONGHOLD_CORRIDOR_CHEST, 4, CopperTier.COPPER_SWORD),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 4, CopperTier.COPPER_SWORD),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 4, CopperTier.COPPER_HELMET),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 4, CopperTier.COPPER_CHESTPLATE),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 4, CopperTier.COPPER_LEGGINGS),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 4, CopperTier.COPPER_BOOTS),
            new LootTableItem(LootTables.VILLAGE_WEAPONSMITH_CHEST, 3, CopperTier.COPPER_HORSE_ARMOR),
            new LootTableItem(LootTables.SIMPLE_DUNGEON_CHEST, 3, CopperTier.COPPER_HORSE_ARMOR),
    };

    public static void buildLootTables() {
        for (LootTableItem LOOT_ENTRY : LOOT_TABLE) {

            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && LOOT_ENTRY.id.equals(id)) {

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(LOOT_ENTRY.item).weight(LOOT_ENTRY.weight));


                    tableBuilder.pool(poolBuilder);
                }
            });
        }
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("[Copper Tier] Initialization started.");

        LOGGER.info("[Copper Tier] Item registration starting.");
        registerItems();
        LOGGER.info("[Copper Tier] Item registration complete.");

        LOGGER.info("[Copper Tier] Loot table modification starting.");
        buildLootTables();
        LOGGER.info("[Copper Tier] Loot table modification complete.");

        LOGGER.info("[Copper Tier] Initialization completed.");
    }

    private void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_sword"), COPPER_SWORD);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_axe"), COPPER_AXE);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_hoe"), COPPER_HOE);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_helmet"), COPPER_HELMET);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_boots"), COPPER_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("coppertier", "copper_horse_armor"), COPPER_HORSE_ARMOR);
    }

    public static class LootTableItem {
        public Identifier id;
        public int weight;

        public Item item;

        public LootTableItem(Identifier id, int weight, Item item) {
            this.id = id;
            this.weight = weight;
            this.item = item;
        }
    }
}
