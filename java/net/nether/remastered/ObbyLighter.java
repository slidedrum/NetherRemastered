package net.nether.remastered;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;

public class ObbyLighter extends Item{
    ArrayList<BlockState> ValidBlocks = new ArrayList<BlockState>();
    public ObbyLighter(Settings settings) {
        super(settings);
        ValidBlocks.add(main.OBBY_AMETHYST.getDefaultState());
        ValidBlocks.add(main.OBBY_COAL.getDefaultState());
        ValidBlocks.add(main.OBBY_COPPER.getDefaultState());
        ValidBlocks.add(main.OBBY_DEEP.getDefaultState());
        ValidBlocks.add(main.OBBY_DIAMOND.getDefaultState());
        ValidBlocks.add(main.OBBY_DRIPSTONE.getDefaultState());
        ValidBlocks.add(main.OBBY_EMERALD.getDefaultState());
        ValidBlocks.add(main.OBBY_GOLD.getDefaultState());
        ValidBlocks.add(main.OBBY_IRON.getDefaultState());
        ValidBlocks.add(main.OBBY_LAPIS.getDefaultState());
        ValidBlocks.add(main.OBBY_LAVA.getDefaultState());
        ValidBlocks.add(main.OBBY_MOSSY.getDefaultState());
        ValidBlocks.add(main.OBBY_REDSTONE.getDefaultState());
        ValidBlocks.add(main.OBBY_WATER.getDefaultState());
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient())
            return ActionResult.FAIL;
        System.out.println(context.getWorld().getBlockState(context.getBlockPos()).toString());
        Pair<BlockPos,Axis> ret = CheckForPortal(context.getBlockPos(), context.getWorld(),context.getPlayer());
        BlockPos pos = ret.getLeft();
        System.out.println(pos.toString());
        if (!pos.equals(new BlockPos(0,-65,0)));
        {
            System.out.println(pos.toString());
            context.getWorld().playSound(context.getPlayer(), context.getBlockPos(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, context.getWorld().getRandom().nextFloat() * 0.4F + 0.8F);
            CreatePortal(context.getWorld(), pos, ret.getRight());
            return ActionResult.SUCCESS;
        }
	}
    public void CreatePortal(World world, BlockPos pos, Axis axis){
        int z = 0;
        int x = 0;
        for (int w = -2; w <= -1; w++) {
            for (int y = -3; y <= -1; y++) {
                if (axis.equals(Axis.X))
                    x = w;
                else
                    z = w;
                BlockState blockState = (BlockState)Blocks.NETHER_PORTAL.getDefaultState().with(NetherPortalBlock.AXIS, axis);
                world.setBlockState(new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()+z), blockState, Block.NOTIFY_LISTENERS | Block.FORCE_STATE);
            }
        }
    }
    public Pair<BlockPos,Axis> CheckForPortal(BlockPos oldPos,World world,PlayerEntity player){
        //Generate 2d array east/west
        ArrayList<BlockState> FoundSoFar = new ArrayList<BlockState>();
        BlockPos pos = new BlockPos(0, -65,0);
        int[][] SpaceToCheck = new int[7][9];
        System.out.println("-----------------------------------");
        for (int x = -3; x <= 3; x++) {
            for (int y = -4; y <= 4; y++) {
                BlockPos NewPos = oldPos.up(y).east(x);
                BlockState found = (world.getBlockState(NewPos));
                if (found == null)
                    found = Blocks.AIR.getDefaultState();
                if (ValidBlocks.contains(found) || found.equals(Blocks.OBSIDIAN.getDefaultState()) || found.equals(Blocks.CRYING_OBSIDIAN.getDefaultState())){
                    if (!FoundSoFar.contains(found))
                        FoundSoFar.add(found);
                    SpaceToCheck[x+3][y+4] = 1;
                } else if (found != Blocks.AIR.getDefaultState() && found != Blocks.CAVE_AIR.getDefaultState() && found != Blocks.VOID_AIR.getDefaultState())
                {
                    SpaceToCheck[x+3][y+4] = 2;
                } else{
                    SpaceToCheck[x+3][y+4] = 0;
                }
            }
        }
        //Check array east/west
        int[][] Pattern = new int[4][5];//create valid pattern matrix
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 4; y++) {
                if (x ==  0 || x == 3 || y == 0 || y == 4){
                    Pattern[x][y] = 1;
                }else{
                    Pattern[x][y] = 0;
                }
            }
        }
        String out = "\n";//print pattern for debug
        Boolean valid = false;
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 4; y++) {
                //repeat untill we find a valid block
                if (SpaceToCheck[x][y] == 1){ //found a valid block
                    Boolean done = false;
                    pos = new BlockPos(oldPos.getX()+x,oldPos.getY()+y,oldPos.getZ());
                    for (int x2 = 0; x2 <= 3; x2++) {//check for valid pattern at xy
                        for (int y2 = 0; y2 <= 4; y2++) {
                            if (!(SpaceToCheck[x+x2][y+y2] == Pattern[x2][y2]))
                                done = true;
                            if (done)
                                break;
                        }
                        if (done)
                            break;
                    }
                    if (!done)
                        valid = true;
                }
                if (valid)
                    break;
            }
            if (valid)
                break;
        }
        System.out.println(FoundSoFar.size());
        out = "\n";
        for (int y = 8; y >= 0; y--) {
            for (int x = 0; x < 7; x++) {
                out = out+" "+SpaceToCheck[x][y];
            }
            out = out+"\n";
        }
        System.out.println(out);

        if (valid && FoundSoFar.size()>=10){
            world.playSound(player, pos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            //create portal east/west

            System.out.println("VALID PORTAL!!!");
            return new Pair<BlockPos,Axis>(pos,Axis.X);
        }
        //Generate 2d array north/south
        FoundSoFar = new ArrayList<BlockState>();
        SpaceToCheck = new int[7][9];
        for (int z = -3; z <= 3; z++) {
            for (int y = -4; y <= 4; y++) {
                BlockPos NewPos = oldPos.up(y).south(z);
                BlockState found = (world.getBlockState(NewPos));
                if (found == null)
                    found = Blocks.AIR.getDefaultState();
                if (ValidBlocks.contains(found) || found.equals(Blocks.OBSIDIAN.getDefaultState()) || found.equals(Blocks.CRYING_OBSIDIAN.getDefaultState())){
                    if (!FoundSoFar.contains(found))
                        FoundSoFar.add(found);
                    SpaceToCheck[z+3][y+4] = 1;
                } else if (found != Blocks.AIR.getDefaultState() && found != Blocks.CAVE_AIR.getDefaultState() && found != Blocks.VOID_AIR.getDefaultState())
                {
                    SpaceToCheck[z+3][y+4] = 2;
                } else{
                    SpaceToCheck[z+3][y+4] = 0;
                }
            }
        }
        out = "\n";
        for (int y = 8; y >= 0; y--) {
            for (int z = 0; z < 7; z++) {
                out = out+" "+SpaceToCheck[z][y];
            }
            out = out+"\n";
        }
        System.out.println(out+"\n north south");
        //Check array north/south
        valid = false;
        for (int z = 0; z <= 3; z++) {
            for (int y = 0; y <= 4; y++) {
                //repeat untill we find a valid block
                if (SpaceToCheck[z][y] == 1){ //found a valid block
                    Boolean done = false;
                    pos = new BlockPos(oldPos.getX(),oldPos.getY()+y,oldPos.getZ()+z);
                    for (int z2 = 0; z2 <= 3; z2++) {//check for valid pattern at xy
                        for (int y2 = 0; y2 <= 4; y2++) {
                            if (!(SpaceToCheck[z+z2][y+y2] == Pattern[z2][y2]))
                                done = true;
                            if (done)
                                break;
                        }
                        if (done)
                            break;
                    }
                    if (!done)
                        valid = true;
                }
                if (valid)
                    break;
            }
            if (valid)
                break;
        }
        System.out.println(FoundSoFar.size());
        

        if (valid && FoundSoFar.size()>=10){
            System.out.println("VALID PORTAL!!!");
            return new Pair<BlockPos,Axis>(pos,Axis.Z);
        }
        else
            return new Pair<BlockPos,Axis>(new BlockPos(0,-65,0),Axis.Z);
    }
}
