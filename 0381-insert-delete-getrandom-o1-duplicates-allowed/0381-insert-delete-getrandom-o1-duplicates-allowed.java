class RandomizedCollection {

    private final List<Integer> list;
    private final Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public boolean insert(int val) {

        map.putIfAbsent(val, new HashSet<>());

        list.add(val);

        map.get(val).add(list.size() - 1);

        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        var index = map.get(val).iterator().next();
        var last = list.getLast();
        
        list.set(index, last);

        map.get(val).remove(index);
        map.get(last).add(index);
        map.get(last).remove(list.size() - 1);

        list.removeLast();

        return true;
    }
    
    public int getRandom() {
        var index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}