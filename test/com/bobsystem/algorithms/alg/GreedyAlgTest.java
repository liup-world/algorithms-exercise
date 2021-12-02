package com.bobsystem.algorithms.alg;

import org.junit.Test;

public class GreedyAlgTest {

    @Test
    public void testCalc() {
        int volume = 10;
        GreedyAlg alg = new GreedyAlg();
        double value = alg.calc(
            volume,
            new GreedyAlg.Thing("a", 9, 4),
            new GreedyAlg.Thing("b", 3, 6),
            new GreedyAlg.Thing("c", 1, 3),
            new GreedyAlg.Thing("d", 6, 2),
            new GreedyAlg.Thing("e", 5, 5)
        );
        System.out.printf("容积为 %d 的包，可以装入的总价值为：%.1f", volume, value);
    }
}
