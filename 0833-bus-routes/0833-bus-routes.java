class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }

        var maxStop = Integer.MIN_VALUE;

        for (var route : routes) {
            for (var stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }

        if (maxStop < target || source > maxStop) {
            return -1;
        }

        var minBusesToReach = new int[maxStop + 1];

        Arrays.fill(minBusesToReach, routes.length + 1);

        minBusesToReach[source] = 0;

        var flag = true;

        while (flag) {

            flag = false;

            for (var route : routes) {

                var min = routes.length + 1;

                for (var stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }

                ++min;

                for (var stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }
        }

        return minBusesToReach[target] < routes.length + 1 ? minBusesToReach[target] : -1;
    }
}