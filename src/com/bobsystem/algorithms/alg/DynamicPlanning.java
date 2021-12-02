package com.bobsystem.algorithms.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * 整理自小灰的推文：
 *   https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg
 *
 * 动态规划
 *   Dynamic Planning 或 Dynamic Programming。
 *   是一种分阶段求解决策问题的数字思想，也应用于管理学、经济学、生物学。
 *
 * 面试题：
 *   有一截 10 级台阶的楼梯，每一步只能跨 1 级 或 2 级台阶。问有多少种走法。
 *
 * 分析：
 *   这个问题采用直觉上的组合排序也异常复杂。穷举的时间复杂度也是指数级的。
 *
 * 正确的思路：
 *   假设一个人已经剩最后一步就走完楼梯了，这时最后一步有两种情况，从第 9 级走一级 或 从第 8 级走两级。
 *   如果已知 1 到 8 级的走法有 x 种，1 到 9 级的走法有 y 种。
 *   所以 1 到 10 级的走法有 x + y 种。
 *
 *   这时的思路可以简化为一个表达式：F(10) = F(9) + F(8)。
 *   接着可以推断出 F(9) = F(8) + F(7)，F(8) = F(7) + F(6)。
 *
 *   剩余两级台阶时，有 2 种走法，F(2) = 2。
 *   剩余一级台阶时，有 1 种走法，F(1) = 1。
 *
 *   看上去，这个解法像极了 斐波那契数列公式。
 *   F(n) = F(n - 1) + F(n - 2)
 *
 *
 * 动态规划包含了 3 个重要的概念：最优子结构、边界、状态转移公式。
 *   F(10) = F(9) + F(8)
 *   F(10) 的最优子结构 F(9) + F(8)
 *
 *   F(2)、F(1) 是 F(10) 的边界。
 *   F(2) = 2
 *   F(1) = 1
 *
 *   F(n) = F(n - 1) + F(n - 2) 是状态转移方程，描述了阶段 与 下一阶段的关系。
 */
public class DynamicPlanning {

    public int calc(int tier) {
        //if (tier < 3) return tier;
        if (tier <= 3) return tier; // 按分析思路应该是 < 3，但可优化为 <= 3
        return calc(tier - 1) + calc(tier - 2);
    }

    /**
     * 优化一：使用备忘录算法，将计算结果缓存起来。
     *   此时的时间复杂度变为：o(n)；空间复杂度为：o(n - 2)
     */
    public int calcOptimization(int tier) {
        Map<Integer, Integer> cache = new HashMap<>();
        return calc_(tier, cache);
    }

    private Integer calc_(int tier, Map<Integer, Integer> cache) {
        if (tier <= 3) return tier;
        Integer result = cache.get(tier);
        if (result != null) return result;
        result = calc_(tier - 1, cache) + calc_(tier - 2, cache);
        cache.put(tier, result);
        return result;
    }

    /**
     * 不在使用公式 F(n) = F(n - 1) + F(n - 2)
     *   因为一个值等于前两个值的和，而第一个值是 1，第二个值是 2，
     *   所以从台阶第一级向上遍历
     * 放弃递归，性能最优
     */
    public int calcOptimization2(int tier) {
        int before2 = 1;
        int before1 = 2;
        int result = 0;
        for (int i = 3; i <= tier; ++i) {
            result = before1 + before2;
            before2 = before1;
            before1 = result;
        }
        return result;
    }

    /**
     * 有 5 座金矿，10 个工人，要求只有挖空与不挖两种选择且同时进行，问怎么安排工作，可以挖到更多的金？
     *
     *   设 mines 为各金矿的储备量
     *   设 workmen 为各金矿对应的工人数
     *   设 qty 为金矿的数量
     *   设 remainning 为总工人数 或 剩余工人数
     *
     * 5 座金矿的最优子结构是：
     *   10 个工人 挖 4 座金矿，与 7 个工人 挖 4 座金矿 + 第 5 座金矿的储备量 的较大值
     *   简化为公式：
     *     F(5, 10) = MAX( F(4, 10), F(4, 10 - workmen[4]) + mines[4] )
     * 边界为：
     *   if qty = 1 && remainning >= workmen[0]，公式为 F(qty, remainning) = mines[0]
     *   if qty = 1 && remainning < workmen[0]，公式为 F(qty, remainning) = 0
     *     只有一座矿时，要么挖空，要么工人数不够不挖。
     * 状态转移方程式为：
     *   if qty > 1 && remainning < workmen[qty - 1]，公式为 F(qty, remainning) = F(qty - 1, remainning)
     *     工人数不够时尝试挖前面的矿。qty - 1 是当前矿所需的人数。
     *   if qty > 1 && remainning >= workmen[qty - 1]，公式为
     *     F(qty, remainning) =
     *       MAX( F(qty - 1, remainning), F(qty - 1, remainning - workmen[qty - 1]) + mines[qty - 1] )
     *     工人数够时，判断是所有工人只挖前面的矿获得的金多，还是挖最后一座的同时，其余工人挖前面的矿获得的多。
     */
    public int calcMostGold(int[] mines, int[] workmen, int mineSeq, int remainingWorkmen) {
        if (mineSeq == 1) {
            return (remainingWorkmen >= workmen[0]) ?
                mines[0]
                : 0;
        }
        int prev = mineSeq - 1;
        if (remainingWorkmen < workmen[prev]) {
            return calcMostGold(mines, workmen, prev, remainingWorkmen);
        }
        return Math.max(
            calcMostGold(mines, workmen, prev, remainingWorkmen),
            calcMostGold(mines, workmen, prev, remainingWorkmen - workmen[prev]) + mines[prev]
        );
    }
}
