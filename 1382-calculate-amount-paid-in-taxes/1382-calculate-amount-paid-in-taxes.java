class Solution {

    public double calculateTax(int[][] brackets, int income) {
        
        double taxesPaid = 0;
        var remainingTaxableIncome = income;
        var taxedValue = 0;
        
        for (var bracket : brackets) {

            if (income <= 0) {
                break;
            }

            // brackets = [[3,50],[7,10],[12,25]], income = 10
            // 0: remainingTaxableIncome = 10, taxedValue = 0, taxesPaid = 0
            // 1: remainingTaxableIncome = 7, taxedValue = 3, taxesPaid = 1.5
            // 2: remainingTaxableIncome = 3, taxedValue = 7, taxesPaid = 1.9
            // 3: remainingTaxableIncome = 0, taxedValue = 10, taxesPaid = 2.65

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