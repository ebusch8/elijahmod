package com.elijah.elijahmod;

import com.elijah.elijahmod.item.HammerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "elijahmod");

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new HammerItem(new Item.Properties().durability(500)));

}

