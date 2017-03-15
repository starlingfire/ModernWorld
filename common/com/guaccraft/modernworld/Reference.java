package com.guaccraft.modernworld;

public class Reference {
	
	/*
	 *  Mod-specific stuff 
	 */
	
	public static final String MOD_ID = "sfmw";
	public static final String NAME = "Starlingfire's Modern World";
	public static final String VERSION = "0.1";
	public static final String DEPENDENCEES = "required-after:forge@[13.20.0.2228,]"; /* Spelled wrong on purpose so as to not conflict */
	
	public static final String CLIENT_PROXY_CLASS = "com.guaccraft.modernworld.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.guaccraft.modernworld.CommonProxy";

	public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";
	public static final String RES_ITEM = "item."+ RESOURCE_PREFIX;
	public static final String RES_TILE = "tile."+ RESOURCE_PREFIX;
	
	/*
	 *  Items
	 */
						
	public static final String DOLLAR_BILL = "dollar_bill";
	public static final String DOLLAR_BILL_ONE = "dollar_bill_one";
	
	
	/*
	 *  Blocks
	 */
	
	public static final String VENDING_MACHINE = "vending_machine";
	public static final String VENDING_MACHINE_BEER = "vending_machine_beer";
	public static final String VENDING_MACHINE_SODA = "vending_machine_soda";
	public static final String SODA_MACHINE_LOWER = "soda_machine_lower";
	
}
