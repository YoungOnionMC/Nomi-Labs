package com.nomiceu.nomilabs.gregtech.multiblock;

import com.nomiceu.nomilabs.block.registry.LabsBlocks;
import com.nomiceu.nomilabs.gregtech.LabsRecipeMaps;
import com.nomiceu.nomilabs.gregtech.LabsTextures;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import team.chisel.common.carving.Carving;

public class LargeMicroverseProjector extends MicroverseProjectorBase {
    public LargeMicroverseProjector(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, LabsRecipeMaps.MEDIUM_MICROVERSE_RECIPES);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("         ", "         ", "  CCCCC  ", "  CVCVC  ", "  CCCCC  ", "  CVCVC  ", "  CCCCC  ", "         ", "         ")
                .aisle("         ", "  CGGGC  ", " CDDDDDC ", " GDDDDDG ", " GDDDDDG ", " GDDDDDG ", " CDDDDDC ", "  CGGGC  ", "         ")
                .aisle("  CCCCC  ", " CDDDDDC ", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", " CDDDDDC ", "  CCCCC  ")
                .aisle("  CGGGC  ", " CDDDDDC ", "CDDDDDDDC", "CDD   DDC", "CDD   DDC", "CDD   DDC", "CDDDDDDDC", " CDDDDDC ", "  CGGGC  ").setRepeatable(3)
                .aisle("  CCCCC  ", " CDDDDDC ", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", "CDDDDDDDC", " CDDDDDC ", "  CCCCC  ")
                .aisle("         ", "  CGGGC  ", " CDDDDDC ", " GDDDDDG ", " GDDDDDG ", " GDDDDDG ", " CDDDDDC ", "  CGGGC  ", "         ")
                .aisle("         ", "         ", "  CCSCC  ", "  CGGGC  ", "  CGGGC  ", "  CGGGC  ", "  CCCCC  ", "         ", "         ")
                .where('S', selfPredicate())
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS)))
                .where('V', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ENGINE_INTAKE_CASING)))
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
        return new LargeMicroverseProjector(this.metaTileEntityId);
    }
}

