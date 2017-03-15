package com.guaccraft.modernworld.item;

import com.guaccraft.modernworld.ModernWorld;
import com.guaccraft.modernworld.Reference;
import com.guaccraft.modernworld.handlers.EnumVendingMachineType;
import com.guaccraft.modernworld.init.ModItems;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemVendingMachine extends Item {

	// -------------------------------------------------------------------------------------------------
	// 	Constructor 
	// -------------------------------------------------------------------------------------------------
	
	public ItemVendingMachine() {

		this.setUnlocalizedName("vending_machine");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(ModernWorld.tabAppliances);
	}

	// -------------------------------------------------------------------------------------------------
	// 	Register the items with the model (ModItems.initClient)
	// -------------------------------------------------------------------------------------------------
	
	public void registerItem(ItemModelMesher mesher) {
	
		ModelResourceLocation model = new ModelResourceLocation(Reference.RESOURCE_PREFIX + Reference.VENDING_MACHINE, "inventory");
		ModelLoader.registerItemVariants(this, model);
		mesher.register(this, 0, model);
	}
	
	// -------------------------------------------------------------------------------------------------
	// 	Overridden methods
	// -------------------------------------------------------------------------------------------------
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		
		return Reference.RES_ITEM + Reference.VENDING_MACHINE;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		if (!worldIn.isRemote) {
			
			playerIn.sendMessage(new TextComponentString("You used the vending machine item!"));
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	// -------------------------------------------------------------------------------------------------
	// 	Register the items, using the mesher and Item
	// -------------------------------------------------------------------------------------------------
	
	public void registerItemVendingMachines(ItemModelMesher mesher) {
		
		int amount = EnumVendingMachineType.values().length;
		
		// Create an arry to hold the models for each dollar bill variant
		ModelResourceLocation[] models = new ModelResourceLocation[amount];
		
		// Loop through the variants, adding each one to the array
		for (int i = 0; i < amount; ++i) {
		
			models[i] = new ModelResourceLocation(Reference.RESOURCE_PREFIX + Reference.VENDING_MACHINE + "_" + EnumVendingMachineType.byMetadata(i).getUnlocalizedName(), "inventory");
		}		
		
		// Register the variants, passing it the array
		ModelLoader.registerItemVariants(this, models); // "model" can be an array; or "model, model2" etc.
		
		// Register the meshes
		for (int i = 0; i < amount; ++i) {
			
			mesher.register(this, i, models[i]);
		}
	}
}
