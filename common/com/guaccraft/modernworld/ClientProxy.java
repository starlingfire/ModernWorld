package com.guaccraft.modernworld;

import com.guaccraft.modernworld.init.ModBlocks;
import com.guaccraft.modernworld.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
		super.init(event);
		
		// Create a mesher variable for when we initialize them below
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		// Register blocks and items
		ModBlocks.initClient(mesher);
		ModItems.initClient(mesher);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
		super.postInit(event);
	}
}
