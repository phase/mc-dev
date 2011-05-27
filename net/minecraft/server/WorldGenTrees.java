package net.minecraft.server;

import java.util.Random;

public class WorldGenTrees extends WorldGenerator {

    public WorldGenTrees() {}

    public boolean a(World world, Random random, int i, int j, int k) {
        int l = random.nextInt(3) + 4;
        boolean flag = true;

        if (j >= 1 && j + l + 1 <= 128) {
            int i1;
            int j1;
            int k1;
            int l1;

            for (i1 = j; i1 <= j + 1 + l; ++i1) {
                byte b0 = 1;

                if (i1 == j) {
                    b0 = 0;
                }

                if (i1 >= j + 1 + l - 2) {
                    b0 = 2;
                }

                for (j1 = i - b0; j1 <= i + b0 && flag; ++j1) {
                    for (k1 = k - b0; k1 <= k + b0 && flag; ++k1) {
                        if (i1 >= 0 && i1 < 128) {
                            l1 = world.a(j1, i1, k1);
                            if (l1 != 0 && l1 != Block.LEAVES.bc) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                i1 = world.a(i, j - 1, k);
                if ((i1 == Block.GRASS.bc || i1 == Block.DIRT.bc) && j < 128 - l - 1) {
                    world.a(i, j - 1, k, Block.DIRT.bc);

                    int i2;

                    for (i2 = j - 3 + l; i2 <= j + l; ++i2) {
                        j1 = i2 - (j + l);
                        k1 = 1 - j1 / 2;

                        for (l1 = i - k1; l1 <= i + k1; ++l1) {
                            int j2 = l1 - i;

                            for (int k2 = k - k1; k2 <= k + k1; ++k2) {
                                int l2 = k2 - k;

                                if ((Math.abs(j2) != k1 || Math.abs(l2) != k1 || random.nextInt(2) != 0 && j1 != 0) && !Block.p[world.a(l1, i2, k2)]) {
                                    world.a(l1, i2, k2, Block.LEAVES.bc);
                                }
                            }
                        }
                    }

                    for (i2 = 0; i2 < l; ++i2) {
                        j1 = world.a(i, j + i2, k);
                        if (j1 == 0 || j1 == Block.LEAVES.bc) {
                            world.a(i, j + i2, k, Block.LOG.bc);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}