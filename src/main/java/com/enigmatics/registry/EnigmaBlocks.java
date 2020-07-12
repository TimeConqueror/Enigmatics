package com.enigmatics.registry;

import com.enigmatics.EnigmaGroup;
import com.enigmatics.Enigmatics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import ru.timeconqueror.timecore.registry.TimeAutoRegistrable;
import ru.timeconqueror.timecore.registry.deferred.DeferredBlockRegister;

public class EnigmaBlocks {
    @TimeAutoRegistrable
    private static final DeferredBlockRegister REGISTER = new DeferredBlockRegister(Enigmatics.MODID);

    public static final RegistryObject<Block> METEOR_BLOCK = REGISTER.regBlock("meteor_block", () -> new Block(Block.Properties.create(Material.ROCK)))
            .genDefaultStateAndModel()
            .regDefaultBlockItem(EnigmaGroup.INSTANCE)
            .endTyped();
}
