class StockSpanner {

    private final Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {

        var span = 1;

        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });

        return span;
    }
}