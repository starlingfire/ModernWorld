package com.guaccraft.modernworld;

import com.guaccraft.modernworld.init.ModBlocks;
import com.guaccraft.modernworld.init.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
		ModBlocks.init();
		ModItems.init();
	}
	
	public void init(FMLInitializationEvent event) {
		
		ModBlocks.initRecipes();
		ModItems.initRecipes();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
