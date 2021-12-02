package com.bobsystem.algorithms.alg;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 整理自小灰的推文：
 *   https://mp.weixin.qq.com/s/2vCnAOidBHu8y8MCMgBLTA
 *
 * 贪心算法
 *   解决经典的部分背包问题。
 *   贪心算法可以寻求总是的局部最优解。
 *
 *
 * 一个简单的场景：
 *   一个背包的容积是 10，有几个物品，价值和体积分别是：9与4、3与6、1与3、6与2、5与5。
 *   问装入哪几样物品可以让背包内的价值更大？可以放入一个物品的部分。
 *
 * 分析：
 *   以上 5 个物品分别使用代号 a、b、c、d、e。
 *   先放入价值最大的 a、d、c，容积剩余 1，接着该放入哪个的一部分呢？
 *   这时应该有个评分标准。
 *
 *   得出它们的性价比是最优解。
 *   a = 9 / 4 = 2.5
 *   b = 3 / 6 = 0.5
 *   c = 1 / 3 = 0.33
 *   d = 6 / 2 = 3
 *   e = 5 / 5 = 1
 *
 *   性价比从大到小排列：d、a、e、b、c。
 *   所以答案是：放入 d、a、0.8 * e。
 *
 *   最大价值 = 6 + 9 + 0.8 * 5 = 19。
 */
public class GreedyAlg {

    public double calc(int sumVolume, Thing... things) {
        // calc rate
        List<Map.Entry<Thing, Double>> list = new ArrayList<>();
        for (Thing thing : things) {
            list.add(new AbstractMap.SimpleEntry<>(thing, thing.value / thing.volume));
        }
        // sort
        list.sort((left, right) -> (int)((right.getValue() - left.getValue()) * 1000));
        System.out.println(list);
        double value = 0;
        for (Map.Entry<Thing, Double> entry : list) {
            Thing thing = entry.getKey();
            if (sumVolume > thing.volume) {
                value += thing.value;
                sumVolume -= thing.volume;
                System.out.println("装入了 100% 的物品 " + thing.name);
                if (sumVolume == 0) break;
            }
            else {
                double rate = sumVolume / thing.volume;
                value += thing.value * rate;
                System.out.printf("装入了 %.1f%% 的物品 %s%n", rate * 100, thing.name);
                break;
            }
        }
        return value;
    }

    public static class Thing {

        private final String name;
        private final double value;
        private final double volume;

        public Thing(String name, double value, double volume) {
            this.name = name;
            this.value = value;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return new StringBuilder(50)
                .append("Thing{")
                .append("name='").append(name).append('\'')
                .append(", value=").append(value)
                .append(", volume=").append(volume)
                .append('}').toString();
        }
    }
}
