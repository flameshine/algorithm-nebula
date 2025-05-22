class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        var gasSum = 0;
        
        for (var g : gas) {
            gasSum += g;
        }

        var costSum = 0;

        for (var c : cost) {
            costSum += c;
        }

        if (gasSum < costSum) {
            return -1;
        }
        
        var total = 0;
        var position = 0;

        for (var i = 0; i < gas.length; i++) {
            
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                position = i + 1;
            }
        }

        return position;
    }
}