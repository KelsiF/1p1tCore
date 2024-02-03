package me.kelsi.utils;

import java.util.Random;

public class enchantRandomize {

    public static int chance;

    public static int randomize(int bound) {
        Random random = new Random();

        chance = random.nextInt(bound); // 0, 1, 2, 3, 4

        return chance;
    }


}
