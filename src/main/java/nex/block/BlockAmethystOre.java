/*
 * NetherEx
 * Copyright (c) 2016-2018 by MineEx
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nex.block;

import lex.block.BlockLibEx;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nex.NetherEx;
import nex.init.NetherExItems;

import java.util.Random;

public class BlockAmethystOre extends BlockLibEx
{
    public BlockAmethystOre()
    {
        super(NetherEx.instance, "amethyst_ore", Material.ROCK);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return NetherExItems.AMETHYST_CRYSTAL;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand)
    {
        if(fortune > 0)
        {
            int i = rand.nextInt(fortune + 2) - 1;

            if(i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(rand) * (i + 1);
        }
        else
        {
            return this.quantityDropped(rand);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        return MathHelper.getInt(rand, 2, 5);
    }
}
