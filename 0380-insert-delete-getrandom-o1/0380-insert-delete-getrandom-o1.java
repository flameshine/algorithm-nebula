class RandomizedSet {

    private final Map<Integer, Integer> valuesToIndices;
    private final List<Integer> values;
    private final Random random;

    public RandomizedSet() {
        this.valuesToIndices = new HashMap<>();
        this.values = new ArrayList<>();
        this.random = new Random(); 
    }
    
    public boolean insert(int val) {
        
        if (valuesToIndices.containsKey(val)) {
            return false;
        }

        valuesToIndices.put(val, values.size());

        values.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        
        if (!valuesToIndices.containsKey(val)) {
            return false;
        }

        var index = valuesToIndices.get(val);
        var last = values.get(values.size() - 1);

        values.set(index, last);
        valuesToIndices.put(last, index);
        values.remove(values.size() - 1);
        valuesToIndices.remove(val);

        return true;
    }
    
    public int getRandom() {
        var index = random.nextInt(values.size());
        return values.get(index);
    }
}