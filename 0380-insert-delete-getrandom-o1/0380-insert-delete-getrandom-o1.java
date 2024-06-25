class RandomizedSet {

    private Map<Integer, Integer> valuesToIndices;
    private List<Integer> values;
    private Random random;

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
        var lastElement = values.get(values.size() - 1);

        values.set(index, lastElement);
        valuesToIndices.put(lastElement, index);
        values.remove(values.size() - 1);
        valuesToIndices.remove(val);

        return true;
    }
    
    public int getRandom() {
        var randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}