class Solution {

    public int minOperations(int[][] grid, int x) {
        
        List<Integer> all = new ArrayList<>();

        for (var row : grid) {
            for (var column : row) {
                all.add(column);
            }
        }

        var mod = all.get(0) % x;

        for (var n : all) {
            if (n % x != mod) {
                return -1;
            }
        }

        Collections.sort(all);

        var median = all.get(all.size() / 2);
        var operations = 0;

        for (var num : all) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}