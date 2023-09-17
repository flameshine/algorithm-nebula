package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №134 Gas Station
 *
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique.
 */
public class GasStation {

    public static void main(String... args) {

        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };

        System.out.println(
            canCompleteCircuit(gas, cost)
        );
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {

        var position = 0;
        var sum = 0;
        var total = 0;

        for (var i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                position = i + 1;
            }
        }

        total += sum;

        return total >= 0 ? position : -1;
    }
}