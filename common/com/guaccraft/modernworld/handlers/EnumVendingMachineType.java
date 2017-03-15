package com.guaccraft.modernworld.handlers;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;

	public enum EnumVendingMachineType implements IStringSerializable {
		
		BEER(0, "beer", "beer"),
		SODA(1, "soda", "soda");
	/*
		TEN(2, "ten", "ten"),
		TWENTY(3, "twenty", "twenty"),
		FIFTY(4, "fifty", "fifty"),
		HUNDRED(5, "hundred", "hundred");
	 */
		
		private static final EnumVendingMachineType[] META_LOOKUP = new EnumVendingMachineType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		
		
		private EnumVendingMachineType(int meta, String name, String unlocalizedName){
			
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
			
		}

		public int getMetadata() {
				
			return this.meta;
		}
			
		@Override
		public String getName() {
			
			return this.name;
		}
				
		public String getUnlocalizedName() {
			
			return this.unlocalizedName;
		}

		@Override
		public String toString() {
			
			return this.getUnlocalizedName();
		}
		
		public static EnumVendingMachineType byMetadata(int meta) {
			
	        if (meta < 0 || meta >= META_LOOKUP.length)
	        {
	            meta = 0;
	        }

	        return META_LOOKUP[meta];
	    }
		
		static {
	        
			for (EnumVendingMachineType enumvendingmachinetype : values()) {
	            
				META_LOOKUP[enumvendingmachinetype.getMetadata()] = enumvendingmachinetype;
	        }
	    }
}
