package com.nomiceu.nomilabs.block;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"PointlessArithmeticExpression", "deprecation"})
public class BlockExcitationCoil extends BlockDirectional {

    private static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0 / 16.0, 4.0 / 16.0,
                                                                     4.0 / 16.0, 9.0 / 16.0,
                                                                     12.0 / 16.0, 12.0 / 16.0);

    private static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(7.0 / 16.0, 4.0 / 16.0,
                                                                     4.0 / 16.0, 16.0 / 16.0,
                                                                     12.0 / 16.0, 12.0 / 16.0);

    private static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(4.0 / 16.0, 4.0 / 16.0,
                                                                      0.0 / 16.0, 12.0 / 16.0,
                                                                      12.0 / 16.0, 9.0 / 16.0);

    private static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(4.0 / 16.0, 4.0 / 16.0,
                                                                      7.0 / 16.0, 12.0 / 16.0,
                                                                      12.0 / 16.0, 16.0 / 16.0);

    private static final AxisAlignedBB UP_AABB = new AxisAlignedBB(4.0 / 16.0, 0.0 / 16.0,
                                                                   4.0 / 16.0, 12.0 / 16.0,
                                                                   9.0 / 16.0, 12.0 / 16.0);

    private static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(4.0 / 16.0, 7.0 / 16.0,
                                                                     4.0 / 16.0, 12.0 / 16.0,
                                                                     16.0 / 16.0, 12.0 / 16.0);

	public BlockExcitationCoil(ResourceLocation rl, CreativeTabs tab) {
		super(Material.IRON);
        fullBlock = false;
		setSoundType(SoundType.METAL);
        setCreativeTab(tab);
		setRegistryName(rl);
        setHardness(5.0F);
        setResistance(5.0F);
        setLightLevel(1.0F);
        setHarvestLevel("pickaxe", 2);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}

    @Override
    public @NotNull IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withProperty(FACING, mirrorIn.mirror(state.getValue(FACING)));
    }

    @Override
    public @NotNull AxisAlignedBB getBoundingBox(IBlockState state, @NotNull IBlockAccess source, @NotNull BlockPos pos) {
        return switch (state.getValue(FACING)) {
            case UP -> UP_AABB;
            case DOWN -> DOWN_AABB;
            case EAST -> EAST_AABB;
            case WEST -> WEST_AABB;
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
        };
    }

    @Override
    public boolean isSideSolid(@NotNull IBlockState baseState, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EnumFacing side) {
        return false;
    }

    @Override
    public boolean isTopSolid(@NotNull IBlockState state){
        return false;
    }

    @Override
    public boolean isOpaqueCube(@NotNull IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(@NotNull IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos) {
        return false;
    }

    @Override
    public @NotNull BlockFaceShape getBlockFaceShape(@NotNull IBlockAccess worldIn, @NotNull IBlockState state, @NotNull BlockPos pos, EnumFacing face) {
        state = this.getActualState(state, worldIn, pos);
        return state.getValue(FACING) == face.getOpposite() ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean doesSideBlockRendering(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EnumFacing face){
        return false;
    }

    @Override
    public @NotNull IBlockState getStateForPlacement(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ, int meta, @NotNull EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }

    @Override
    public @NotNull IBlockState getStateFromMeta(int meta)
    {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(FACING, EnumFacing.byIndex(meta));
        return blockState;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return (state.getValue(FACING)).getIndex();
    }

    @Override
    public @NotNull BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }
}