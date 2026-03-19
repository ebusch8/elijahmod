package com.elijah.elijahmod.item

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class HammerItem extends Item {

    public HammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, net.minecraft.world.entity.LivingEntity miner) {
        if (!level.isClientSide) {
            mine3x3(level, pos, miner);
        }
        return super.mineBlock(stack, level, state, pos, miner);
    }

    private void mine3x3(Level level, BlockPos center, net.minecraft.world.entity.LivingEntity miner) {
        // Loop through a 3×3 area centered on the block
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                BlockPos target = center.offset(x, 0, y);

                if (!target.equals(center)) {
                    BlockState state = level.getBlockState(target);

                    if (state.getDestroySpeed(level, target) >= 0) {
                        level.destroyBlock(target, true, miner);
                    }
                }
            }
        }
    }
}
