/**
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private final Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<>();
        addAllItems(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void addAllItems(List<NestedInteger> list) {

        if (list.isEmpty()) {
            return;
        }

        for (var i : list) {
            if (i.isInteger()) {
                queue.add(i.getInteger());
            } else {
                addAllItems(i.getList());
            }
        }
    } 
}