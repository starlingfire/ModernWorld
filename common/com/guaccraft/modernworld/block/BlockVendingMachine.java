package com.guaccraft.modernworld.block;

import com.guaccraft.modernworld.ModernWorld;
import com.guaccraft.modernworld.Reference;
import com.guaccraft.modernworld.handlers.EnumVendingMachineType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVendingMachine extends Block {

	//public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	//protected static final AxisAlignedBB MACHINE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	
	public BlockVendingMachine() {

		super(Material.IRON); // May not want to specify the material here
		setHardness(4.0f);
		setResistance(10.0f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(ModernWorld.tabAppliances);
	}
		
	public void addRecipes() {

		/*
		 *  Set ItemStack references for the recipe creation
		 */
		
		ItemStack ironBlock = new ItemStack(Blocks.IRON_BLOCK, 1); 			// Iron block 	  (i)
		ItemStack sign = new ItemStack(Blocks.WALL_SIGN, 1); 				// Sign			  (s)
		ItemStack dispenser = new ItemStack(Blocks.DISPENSER, 1); 			// Dispenser	  (d)
		ItemStack buttonStone = new ItemStack(Blocks.STONE_BUTTON, 1); 		// Stone button   (b)
		ItemStack buttonWood = new ItemStack(Blocks.WOODEN_BUTTON, 1); 		// Wooden button  (b)
		ItemStack redstoneBlock = new ItemStack(Blocks.REDSTONE_BLOCK, 1); 	// Redstone block (r)
		
		/*
		 *  Recipes for the vending machines
		 *  0 = beer
		 *  1 = soda
		 */
		
		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), "isi", "irb", "idi", 'i', ironBlock, 's', sign, 'd', dispenser, 'b', buttonStone, 'r', redstoneBlock);
		//GameRegistry.addShapedRecipe(new ItemStack(this, 1, 1), "isi", "irb", "idi", 'i', ironBlock, 's', sign, 'd', dispenser, 'b', buttonWood, 'r', redstoneBlock);
			
	}


	@Override
	public String getUnlocalizedName() {
		
		return Reference.RES_TILE + Reference.VENDING_MACHINE;  // tile.sfmw:vending_machine
	}
	
	/*
	public String getUnlocalizedName(ItemStack stack) {

		int i = stack.getMetadata();
		return Reference.RES_TILE + Reference.VENDING_MACHINE + "_" + EnumVendingMachineType.byMetadata(i).getUnlocalizedName(); // tile.sfmw:vending_machine_beer/soda
	}
	
	public String getUnlocalizedName(int i) {
		
		return Reference.RES_TILE + Reference.VENDING_MACHINE + "_" + EnumVendingMachineType.byMetadata(i).getUnlocalizedName();
	}
	*/
	
	/*
	 *  TEST
	 *  Goal here is to open a custom menu for this vending machine with options to buy its contents
	 * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		if (!worldIn.isRemote)
			playerIn.sendMessage(new TextComponentString("You used the vending machine!"));
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

	/*
	 * Alerting the player that this was used, then returning the normal
	 * return.
	 */
	
	/*
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		//playerIn.sendMessage(new TextComponentString("You placed the vending machine!"));
		this.setDefaultFacing(worldIn, pos, state);
    }
	*/
	
	/*
	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(PROPERTYFACING);
            
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

            worldIn.setBlockState(pos, state.withProperty(PROPERTYFACING, enumfacing), 2);
        }
    }
    */
		
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
	
	/*
	// create a list of the subBlocks available for this block, i.e. one for each colour
	// ignores facings, because the facing is calculated when we place the item.
	//  - used to populate items for the creative inventory
	// - the "metadata" value of the block is set to the colours metadata
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		  
		EnumVendingMachineType[] allVendingMachineTypes = EnumVendingMachineType.values();
		  
		for (EnumVendingMachineType vendingMachineType : allVendingMachineTypes) {
	      
			list.add(new ItemStack(itemIn, 1, vendingMachineType.getMetadata()));
		}
	}
	*/
	
	/*
	@Override
	public IBlockState getStateFromMeta(int meta) {
		  
		EnumFacing facing = EnumFacing.getHorizontal(meta);
		int vendingMachineTypeBits = (meta & 0x0c) >> 2; // 0x0c is hexadecimal, in binary 1100 - the upper two bits, corresponding to the colour
		EnumVendingMachineType vendingMachineType = EnumVendingMachineType.byMetadata(vendingMachineTypeBits);
		  
		  return this.getDefaultState().withProperty(PROPERTYFACING, facing);
	  }

	  @Override
	  public int getMetaFromState(IBlockState state) {
		  
		  EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
		  
		  int facingbits = facing.getHorizontalIndex();
		  
		  return facingbits;
	  }
	  */
	  
	  @Override
	  public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	  {
		  return state;
	  }
	  
	  /*
	  @Override
	  protected BlockStateContainer createBlockState()
	  {
	    return new BlockStateContainer(this, new IProperty[] {PROPERTYFACING});
	  }
	  */
	  
	  /*
	  public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
	        
		// Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	    // IBlockstate
	    		  
		  EnumVendingMachineType vendingMachineType = EnumVendingMachineType.byMetadata(meta);
		  // find the quadrant the player is facing
		  EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

	      //return getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
		  return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
	    }
		*/
}









