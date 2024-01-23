package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * №841 Keys and Rooms
 *
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {

    public static void main(String... args) {

        var rooms = List.<List<Integer>>of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        );

        System.out.println(
            canVisitAllRooms(rooms)
        );
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> keys = new HashSet<>();
        keys.add(0);

        Queue<Integer> roomsToVisit = new ArrayDeque<>();
        roomsToVisit.add(0);

        while (!roomsToVisit.isEmpty()) {
            int room = roomsToVisit.poll();
            for (var key : rooms.get(room)) {
                if (!keys.contains(key)) {
                    roomsToVisit.add(key);
                    keys.add(key);
                }
            }
        }

        return keys.size() == rooms.size();
    }
}