class Solution {

    public boolean lemonadeChange(int[] bills) {
        
        var balance5 = 0;
        var balance10 = 0;

        for (var b : bills) {
            switch (b) {
                case 5 -> ++balance5;
                case 10 -> {
                    if (balance5 > 0) {
                        ++balance10;
                        --balance5;
                    } else {
                        return false;
                    }
                }
                case 20 -> {

                    if (balance5 > 0 && balance10 > 0) {
                        --balance5;
                        --balance10;
                    } else if (balance5 > 2) {
                        balance5 -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}