package com.guaccraft.modernworld;

import com.guaccraft.modernworld.init.ModBlocks;
import com.guaccraft.modernworld.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCEES)

public class ModernWorld {

	@Instance(Reference.MOD_ID)
	public static ModernWorld instance;
	
	@SidedProxy(clientSide = "com.guaccraft.modernworld.ClientProxy", serverSide = "com.guaccraft.modernworld.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		proxy.postInit(event);
	}
	
	public static CreativeTabs tabMoney = new CreativeTabs(Reference.RESOURCE_PREFIX + "tab_money"){
		
		@Override
		public ItemStack getTabIconItem() {
			
			return new ItemStack(ModItems.dollarBillItem);
		}
	};
	
	public static CreativeTabs tabAppliances = new CreativeTabs(Reference.RESOURCE_PREFIX + "tab_appliances"){
		
		@Override
		public ItemStack getTabIconItem() {
			
			return new ItemStack(ModBlocks.vendingMachineBlock);
		}
	};
}
