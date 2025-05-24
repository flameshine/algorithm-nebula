class Solution {

    public double calculateTax(int[][] brackets, int income) {
        
        double taxesPaid = 0;
        var remainingTaxableIncome = income;
        var taxedValue = 0;
        
        for (var bracket : brackets) {

            var taxableAmount = 0;

            if (remainingTaxableIncome > bracket[0] - taxedValue) {
                taxableAmount = bracket[0] - taxedValue;
            } else {
                taxableAmount = remainingTaxableIncome;
            }

            taxesPaid += taxableAmount * bracket[1] / 100D;
            taxedValue += taxableAmount;
            remainingTaxableIncome -= taxableAmount;
        }

        return taxesPaid;
    }
}