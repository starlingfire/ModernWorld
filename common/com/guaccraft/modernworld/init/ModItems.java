package com.guaccraft.modernworld.init;

import com.guaccraft.modernworld.Reference;
import com.guaccraft.modernworld.item.ItemDollarBill;
import com.guaccraft.modernworld.item.ItemVendingMachine;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

	public static final ItemVendingMachine vendingMachineItem = new ItemVendingMachine();
	public static final ItemDollarBill dollarBillItem = new ItemDollarBill();
	
	public static void init() {
	
		// Dollar bills
		dollarBillItem.setRegistryName(new ResourceLocation(Reference.MOD_ID, Reference.DOLLAR_BILL));
		GameRegistry.register(dollarBillItem);
	}
	
	public static void initRecipes() {
		
		dollarBillItem.addRecipes();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {
		
		dollarBillItem.registerItem(mesher);	
	}
	
}
