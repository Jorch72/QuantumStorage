package QuantumStorage.block.qsu;

import QuantumStorage.CreativeTabQuantumStorage;
import QuantumStorage.QuantumStorage;
import QuantumStorage.client.GuiHandler;
import QuantumStorage.init.ModBlocks;
import QuantumStorage.tile.qsu.TileQuantumDsuMk3;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockQuantumDsuMk3 extends BlockDsu
{	
	public TileQuantumDsuMk3 dsu;

	public BlockQuantumDsuMk3(Material material) 
	{
		super(material);
		setBlockName("quantumdsumk3");
		setCreativeTab(CreativeTabQuantumStorage.instance);
		setHardness(2.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{
		if (!player.isSneaking())
			player.openGui(QuantumStorage.INSTANCE, GuiHandler.dsuMk3, world, x, y, z);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) 
	{
		return new TileQuantumDsuMk3();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block blockId, int meta)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te instanceof TileQuantumDsuMk3)
		{
			if (((TileQuantumDsuMk3) te).getStackInSlot(1) != null){
				float xOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float yOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float zOffset = world.rand.nextFloat() * 0.8F + 0.1F;
						
				ItemStack stacknbt = ((TileQuantumDsuMk3) te).getDropWithNBT();
				int amountToDrop = Math.min(world.rand.nextInt(21) + 10, stacknbt.stackSize);

				EntityItem entityitem = new EntityItem(world,
						x + xOffset, y + yOffset, z + zOffset,
						stacknbt.splitStack(amountToDrop));
				world.spawnEntityInWorld(entityitem);
			}
			else 
			{
				float xOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float yOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				float zOffset = world.rand.nextFloat() * 0.8F + 0.1F;
				ItemStack stack = new ItemStack(ModBlocks.QuantumDsuMk3);
				
				EntityItem entityitem = new EntityItem(world,
						x + xOffset, y + yOffset, z + zOffset, stack);
				world.spawnEntityInWorld(entityitem);
			}
		}
	}
}
