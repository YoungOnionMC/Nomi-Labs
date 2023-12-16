package com.nomiceu.nomilabs.gregtech.multiblock.registry;

import com.nomiceu.nomilabs.gregtech.multiblock.*;
import com.nomiceu.nomilabs.util.RegistryNames;
import gregtech.common.metatileentities.MetaTileEntities;

public class LabsMultiblocks {

    public static SmallMicroverseProjector SMALL_MICROVERSE_PROJECTOR;
    public static MediumMicroverseProjector MEDIUM_MICROVERSE_PROJECTOR;
    public static LargeMicroverseProjector LARGE_MICROVERSE_PROJECTOR;

    public static void postInit() {
        MetaTileEntities.registerMetaTileEntity(32000, new MetaTileEntityGreenhouse(RegistryNames.makeLabsName("greenhouse"))); // Get a set id later, use 32000 for now
        SMALL_MICROVERSE_PROJECTOR = MetaTileEntities.registerMetaTileEntity(32001, new SmallMicroverseProjector(RegistryNames.makeLabsName("small_microverse")));
        MEDIUM_MICROVERSE_PROJECTOR = MetaTileEntities.registerMetaTileEntity(32002, new MediumMicroverseProjector(RegistryNames.makeLabsName("medium_microverse")));
        LARGE_MICROVERSE_PROJECTOR = MetaTileEntities.registerMetaTileEntity(32003, new LargeMicroverseProjector(RegistryNames.makeLabsName("large_microverse")));
    }
}
