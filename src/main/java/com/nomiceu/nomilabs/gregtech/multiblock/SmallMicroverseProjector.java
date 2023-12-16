package com.nomiceu.nomilabs.gregtech.multiblock;

import com.cleanroommc.groovyscript.compat.mods.chisel.*;
import com.nomiceu.nomilabs.block.registry.LabsBlocks;
import com.nomiceu.nomilabs.gregtech.LabsRecipeMaps;
import com.nomiceu.nomilabs.gregtech.LabsTextures;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.BlockInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleCubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import team.chisel.Features;
import team.chisel.api.block.ChiselBlockFactory;
import team.chisel.api.carving.CarvingUtils;
import team.chisel.common.carving.Carving;
import team.chisel.common.init.BlockRegistry;

public class SmallMicroverseProjector extends MicroverseProjectorBase {
    public SmallMicroverseProjector(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, LabsRecipeMaps.SMALL_MICROVERSE_RECIPES);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CVC", "CCC")
                .aisle("CCC", "GDG", "CCC")
                .aisle("CSC", "CGC", "CCC")
                .where('S', selfPredicate())
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS)))
                .where('V', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('C', states(LabsBlocks.MICROVERSE_CASING.getDefaultState()).or(autoAbilities(true, true)))
                .where('D', states(Carving.chisel.getGroup(Blocks.DIAMOND_BLOCK.getDefaultState()).getVariations().get(4).getBlockState()))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return LabsTextures.MICROVERSE_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new SmallMicroverseProjector(this.metaTileEntityId);
    }
}
