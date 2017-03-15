package com.guaccraft.modernworld.handlers;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;

	public enum EnumDollarBillType implements IStringSerializable {
		
		ONE(0, "one", "one"),
		FIVE(1, "five", "five"),
		TEN(2, "ten", "ten"),
		TWENTY(3, "twenty", "twenty"),
		FIFTY(4, "fifty", "fifty"),
		HUNDRED(5, "hundred", "hundred");
	
		private static final EnumDollarBillType[] META_LOOKUP = new EnumDollarBillType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		
		
		private EnumDollarBillType(int meta, String name, String unlocalizedName){
			
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
		
		public static EnumDollarBillType byMetadata(int meta) {
			
	        if (meta < 0 || meta >= META_LOOKUP.length)
	        {
	            meta = 0;
	        }

	        return META_LOOKUP[meta];
	    }
		
		static {
	        
			for (EnumDollarBillType enumdollarbilltype : values()) {
	            
				META_LOOKUP[enumdollarbilltype.getMetadata()] = enumdollarbilltype;
	        }
	    }
}
