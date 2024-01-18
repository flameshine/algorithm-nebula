package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * №752 Open the Lock
 *
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    public static void main(String... args) {

        var deadends = new String[] { "0201", "0101", "0102", "1212", "2002" };

        System.out.println(
            openLock(deadends, "0202")
        );
    }

    private static int openLock(String[] deadends, String target) {

        Map<String, Integer> deadendToIndex = new HashMap<>();

        for (var i = 0; i < deadends.length; i++) {
            deadendToIndex.put(deadends[i], i);
        }

        Set<String> seen = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        var level = 0;

        queue.offer("0000");

        while (!queue.isEmpty()) {
            var size = queue.size();
            while (size-- > 0) {
                var item = queue.poll();
                if (target.equals(item)) {
                    return level;
                }
                if (deadendToIndex.containsKey(item)) {
                    continue;
                }
                if (seen.contains(item)) {
                    continue;
                } else {
                    seen.add(item);
                }
                var builder = new StringBuilder(item);
                for (var i = 0; i < 4; i++) {
                    var digit = builder.charAt(i);
                    var str1 = item.substring(0, i) + (digit == '9' ? 0 : (digit - '0' + 1)) + item.substring(i + 1);
                    var str2 = item.substring(0, i) + (digit == '0' ? 9 : (digit - '0' - 1)) + item.substring(i + 1);
                    if (!seen.contains(str1) && !deadendToIndex.containsKey(str1)) {
                        queue.offer(str1);
                    }
                    if (!seen.contains(str2) && !deadendToIndex.containsKey(str2)) {
                        queue.offer(str2);
                    }
                }
            }
            ++level;
        }

        return -1;
    }
}