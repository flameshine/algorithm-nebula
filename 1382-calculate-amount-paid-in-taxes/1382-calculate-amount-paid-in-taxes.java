class Solution {

    public double calculateTax(int[][] brackets, int income) {
        
        double taxesPaid = 0;
        var taxedValue = 0;
        
        for (var bracket : brackets) {

            var taxableAmount = 0;

            if (income > bracket[0] - taxedValue) {
                taxableAmount = bracket[0] - taxedValue;
            } else {
                taxableAmount = income;
            }

            taxesPaid += taxableAmount * bracket[1] / 100D;
            taxedValue += taxableAmount;
            income -= taxableAmount;
        }

        return taxesPaid;
    }
}