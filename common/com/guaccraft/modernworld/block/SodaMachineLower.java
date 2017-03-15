package com.guaccraft.modernworld.block;

import com.guaccraft.modernworld.ModernWorld;
import com.guaccraft.modernworld.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SodaMachineLower extends Block {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected static final AxisAlignedBB MACHINE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	
	public SodaMachineLower() {

		super(Material.IRON); // May not want to specify the material here
		setHardness(4.0f);
		setResistance(10.0f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(ModernWorld.tabAppliances);
	}

	public void addRecipes() {

		// Recipe: sides & top of iron blocks, button in middle (stone or wooden),
		// dispenser at bottom
		GameRegistry.addShapedRecipe(new ItemStack(this), "iii", "ibi", "idi", 'i', Blocks.IRON_BLOCK, 'b', Blocks.STONE_BUTTON, 'd', Blocks.DISPENSER);
		GameRegistry.addShapedRecipe(new ItemStack(this), "iii", "ibi", "idi", 'i', Blocks.IRON_BLOCK, 'b', Blocks.WOODEN_BUTTON, 'd', Blocks.DISPENSER);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MACHINE_AABB;
    }

	
	@Override
	public String getUnlocalizedName() {

		return Reference.RES_TILE + Reference.SODA_MACHINE_LOWER; // tile.sfmw:vending_machine
	}
	
	/*
	 *  TEST
	 *  Goal here is to open a custom menu for this vending machine with options to buy its contents
	 * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		if (!worldIn.isRemote)
			playerIn.sendMessage(new TextComponentString("You used the vending machine!"));
		
		return true;//super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

	/*
	 * Alerting the player that this was used, then returning the normal
	 * return.
	 */
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		//playerIn.sendMessage(new TextComponentString("You placed the vending machine!"));
		this.setDefaultFacing(worldIn, pos, state);
    }

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        //if (!worldIn.isRemote)
        //{
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            
            System.out.println("(setDefaultFacing) Enumfacing is " + enumfacing);

            if (enumfacing == EnumFacing.NORTH)
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH)
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST)
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST)
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        //}
    }
		
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

}
