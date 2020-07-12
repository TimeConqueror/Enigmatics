package com.enigmatics;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.timeconqueror.timecore.api.TimeMod;

@Mod(Enigmatics.MODID)
public class Enigmatics extends TimeMod {
    public static final String MODID = "enigmatics";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
}
