package nex.world;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkGenerator;
import nex.world.biome.BiomeProviderNether;
import nex.world.gen.ChunkProviderNether;

public class WorldProviderNether extends WorldProviderHell
{
    @Override
    public void createBiomeProvider()
    {
        biomeProvider = new BiomeProviderNether(worldObj.getSeed());
        isHellWorld = true;
        hasNoSky = true;
        setDimension(-1);
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderNether(worldObj);
    }
}