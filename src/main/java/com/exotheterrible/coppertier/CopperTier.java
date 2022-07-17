package com.exotheterrible.coppertier;

import com.exotheterrible.coppertier.item.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
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

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Copper Tier Initializing.");

        registerItems();

        LOGGER.info("Copper Tier Initialized!");
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

}
