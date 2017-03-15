package com.guaccraft.modernworld.item;

import com.guaccraft.modernworld.ModernWorld;
import com.guaccraft.modernworld.Reference;
import com.guaccraft.modernworld.handlers.EnumDollarBillType;
import com.guaccraft.modernworld.handlers.EnumVendingMachineType;
import com.guaccraft.modernworld.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemDollarBill extends Item {

	// Constructor
	public ItemDollarBill() {

		this.setUnlocalizedName("dollar_bill");
		this.setMaxStackSize(50);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(ModernWorld.tabMoney);
	}

	/*
	 * Returns the unlocalized name of this item, accepting ItemStack so
	 * different names will be returned based on their damage or NBT
	 */

	public String getUnlocalizedName(ItemStack stack) {
		
		int i = stack.getMetadata();
		return Reference.RES_ITEM + Reference.DOLLAR_BILL + "_" + EnumDollarBillType.byMetadata(i).getUnlocalizedName();
	}
	
	public String getUnlocalizedName(int i) {
		
		return Reference.RES_ITEM + Reference.DOLLAR_BILL + "_" + EnumDollarBillType.byMetadata(i).getUnlocalizedName();
	}
	
	public void addRecipes() {

		/*
		 *  Set ItemStack references for the recipe creation
		 */
		
		ItemStack greenDye = new ItemStack(Items.DYE, 1, 2); 		// Cactus green
		ItemStack whiteDye = new ItemStack(Items.DYE, 1, 15); 		// Bone meal
		ItemStack goldNugget = new ItemStack(Items.GOLD_NUGGET, 1); // Gold nugget
		ItemStack string = new ItemStack(Items.STRING, 1); 			// String
		ItemStack paper = new ItemStack(Items.PAPER, 1); 			// Paper
		ItemStack dollarOne = new ItemStack(ModItems.dollarBillItem, 1, 0);		// One $1 bill 			
		ItemStack dollarFive = new ItemStack(ModItems.dollarBillItem, 1, 1);	// One $5 bill
		ItemStack dollarTen = new ItemStack(ModItems.dollarBillItem, 1, 2);		// One $5 bill
		ItemStack dollarTwenty = new ItemStack(ModItems.dollarBillItem, 1, 3);	// One $5 bill
		ItemStack dollarFifty = new ItemStack(ModItems.dollarBillItem, 1, 4);	// One $5 bill
		ItemStack dollarHundred = new ItemStack(ModItems.dollarBillItem, 1, 5);	// One $5 bill
		
		/*
		 *  Plural of the smaller bills for splitting larger bills. 
		 *  NOTE: The amounts are set so that you can only split down one level ($10 bill --> Two $5 bills)
		 */
		
		ItemStack dollarFiveOnes = new ItemStack(ModItems.dollarBillItem, 5, 0); 			
		ItemStack dollarTwoFives = new ItemStack(ModItems.dollarBillItem, 2, 1);
		ItemStack dollarOneTen = new ItemStack(ModItems.dollarBillItem, 1, 2);
		ItemStack dollarTwoTens = new ItemStack(ModItems.dollarBillItem, 2, 2);
		ItemStack dollarTwoTwenties = new ItemStack(ModItems.dollarBillItem, 2, 3);
		ItemStack dollarTwoFifties = new ItemStack(ModItems.dollarBillItem, 2, 4);
	
		/*
		 *  Make ten $1 with in-game items
		 */
		
		GameRegistry.addShapedRecipe(new ItemStack(this, 10, 0), "gwg", "sns", "ppp", 'g', greenDye, 'w', whiteDye, 'n', goldNugget, 'p', paper);
		
		/*
		 * Make larger bills with smaller denominations
		 */
		
		GameRegistry.addShapelessRecipe(dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		
		GameRegistry.addShapelessRecipe(dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarTen, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		
		GameRegistry.addShapelessRecipe(dollarTwenty, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarTwenty, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarTwenty, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarTwenty, dollarTen, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		GameRegistry.addShapelessRecipe(dollarTwenty, dollarFive, dollarFive, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTwenty, dollarTen);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTwenty, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTwenty, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTen, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTen, dollarTen, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTwenty, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTen, dollarTen, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTen, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTen, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarFifty, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive);
		
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarFifty);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarTwenty, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarTwenty, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarTwenty, dollarFive, dollarOne, dollarOne, dollarOne, dollarOne, dollarOne);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarTen, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTwenty, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTen, dollarTen, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTen, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarFifty, dollarTen, dollarTen, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTwenty, dollarTwenty);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTwenty, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTwenty, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTwenty, dollarFive, dollarFive, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTen, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTwenty, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTen, dollarTen, dollarTen, dollarTen, dollarTen, dollarTen);
		GameRegistry.addShapelessRecipe(dollarHundred, dollarTwenty, dollarTwenty, dollarTen, dollarTen, dollarTen, dollarTen, dollarTen, dollarFive, dollarFive);
	
		/*
		 * Make smaller bills out of larger denominations
		 * FIX: How to make one $10 and two $20 from a $50
		 */
		
		GameRegistry.addShapelessRecipe(dollarFiveOnes, dollarFive);
		GameRegistry.addShapelessRecipe(dollarTwoFives, dollarTen);
		GameRegistry.addShapelessRecipe(dollarTwoTens, dollarTwenty);
		GameRegistry.addShapelessRecipe(dollarTwoFifties, dollarHundred);
		
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		/*
		 * Alerting the player that this was used, then returning the normal return.
		 */

		if (!worldIn.isRemote) {
			
			playerIn.sendMessage(new TextComponentString("You flashed money!"));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	/*
	 * Register the items, using the mesher and Item 
	 */
	public void registerItem(ItemModelMesher mesher) {
		
		int amount = EnumDollarBillType.values().length;
		
		// Create an arry to hold the models for each dollar bill variant
		ModelResourceLocation[] models = new ModelResourceLocation[amount];
		
		// Loop through the variants, adding each one to the array
		for (int i = 0; i < amount; ++i) {
		
			models[i] = new ModelResourceLocation(Reference.RESOURCE_PREFIX + Reference.DOLLAR_BILL + "_" + EnumDollarBillType.byMetadata(i).getUnlocalizedName(), "inventory");
		}		
		
		// Register the variants, passing it the array
		ModelLoader.registerItemVariants(this, models); // "model" can be an array; or "model, model2" etc.
		
		// Register the meshes
		for (int i = 0; i < amount; ++i) {
			
			mesher.register(this, i, models[i]);
		}
	}
}
