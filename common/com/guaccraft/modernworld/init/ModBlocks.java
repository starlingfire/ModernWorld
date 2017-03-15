package com.guaccraft.modernworld.init;

import com.guaccraft.modernworld.Reference;
import com.guaccraft.modernworld.block.BlockVendingMachine;
import com.guaccraft.modernworld.block.BlockVendingMachineOld;
import com.guaccraft.modernworld.block.SodaMachineLower;
import com.guaccraft.modernworld.handlers.EnumVendingMachineType;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks extends Blocks {

	// -------------------------------------------------------------------------------------------------
	// 	Blocks 
	// -------------------------------------------------------------------------------------------------
	
	public static BlockVendingMachine vendingMachineBlock;
	
	// -------------------------------------------------------------------------------------------------
	// 	Constructor 
	// -------------------------------------------------------------------------------------------------
	
	public static void init() {

		//beerMachineBlock = new BlockVendingMachine();
		//sodaMachineBlock = new BlockVendingMachine();
		
		// Create the block instance
		vendingMachineBlock = new BlockVendingMachine();
		
		// Set the registry name with a resource location (MOD_ID + Reference NAME)
		vendingMachineBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, Reference.VENDING_MACHINE));

		// Register the blocks with the game
		GameRegistry.register(vendingMachineBlock);
		
		// Register the item of the block with the game
		GameRegistry.register(new ItemBlock(vendingMachineBlock), new ResourceLocation(Reference.MOD_ID, Reference.VENDING_MACHINE));
		
	}

	public static void initRecipes() {
		
		// Will have to add recipes for ALL classes in com.guaccraft.modernworld.block
		//vendingMachineBlock.addRecipes();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {
		
		// Variables that will get reused
		
		Item item;
		ModelResourceLocation model;
		
		item = Item.getItemFromBlock(vendingMachineBlock);
		model = new ModelResourceLocation(Reference.RESOURCE_PREFIX + Reference.VENDING_MACHINE, "inventory");
		
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
