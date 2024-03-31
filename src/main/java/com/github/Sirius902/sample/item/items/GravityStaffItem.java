package com.github.Sirius902.sample.item.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GravityStaffItem extends Item {
    public GravityStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        // TODO: Make the game not super lag.
        // ChunkPos chunkPos = world.getChunk(pos).getPos();
        // for (int z = chunkPos.getStartZ(); z <= chunkPos.getEndZ(); z++) {
        //     for (int x = chunkPos.getStartX(); x <= chunkPos.getEndX(); x++) {
        //         collapsePillar(world, x, z);
        //     }
        // }

        collapsePillar(world, pos.getX(), pos.getZ());

        return ActionResult.SUCCESS;
    }

    private static void collapsePillar(World world, int x, int z) {
        for (int y = world.getBottomY(); y < world.getTopY(); y++) {
            BlockPos blockPos = new BlockPos(x, y, z);
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.getBlock() == Blocks.AIR) {
                continue;
            }

            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, blockPos, blockState);
            fallingBlockEntity.dropItem = false;
        }
    }
}
