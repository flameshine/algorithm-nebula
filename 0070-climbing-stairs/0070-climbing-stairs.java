class Solution {

    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private static int climbStairs(int n, Map<Integer, Integer> memory) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (!memory.containsKey(n)) {
            memory.put(n, climbStairs(n - 1, memory) + climbStairs(n - 2, memory));
        }

        return memory.get(n);
    }
}