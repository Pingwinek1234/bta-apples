package net.morgana.appleleaves.mixin;

import net.minecraft.block.TransparentBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(net.minecraft.block.LeavesBlock.class)
public class LeavesBlockMixin extends TransparentBlock {

    protected LeavesBlockMixin(int id, int textureId, Material material, boolean renderSides) {
        super(id, textureId, material, renderSides);
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck)
    {
        if (world.isRemote)
            return;

        if (world.random.nextInt(200) == 1
                && (meta & 1) == 0) // Oak Leaves only
        {
            dropStack(world, x, y, z, new ItemStack(Item.APPLE.id, 1, 0));
            return;
        }

        super.dropStacks(world, x, y, z, meta, luck);
    }
}
