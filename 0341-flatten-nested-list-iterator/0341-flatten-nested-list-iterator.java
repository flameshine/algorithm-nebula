public class NestedIterator implements Iterator<Integer> {

    private final Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        addToStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            addToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }

    private void addToStack(List<NestedInteger> list) {
        for (var i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    } 
}