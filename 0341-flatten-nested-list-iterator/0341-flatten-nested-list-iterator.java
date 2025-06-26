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

    private final List<Integer> flattenedList;

    private int lastIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattenedList = new ArrayList<>();
        this.lastIndex = 0;
        addAllItems(nestedList);
    }

    @Override
    public Integer next() {
        return flattenedList.get(lastIndex++);
    }

    @Override
    public boolean hasNext() {
        return flattenedList.size() > lastIndex;
    }

    private void addAllItems(List<NestedInteger> list) {

        if (list.isEmpty()) {
            return;
        }

        for (var i : list) {
            if (i.isInteger()) {
                flattenedList.add(i.getInteger());
            } else {
                addAllItems(i.getList());
            }
        }
    } 
}