class TimeMap {

    private final Map<String, List<Entry>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if (!map.containsKey(key)) {
            return "";
        }

        var entries = map.get(key);
        var left = 0;
        var right = entries.size() - 1;

        while (left < right) {
            var middle = (left + right + 1) >>> 1;
            if (timestamp < entries.get(middle).timestamp()) {                 
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        var item = entries.get(left);

        return item.timestamp() <= timestamp ? item.value() : "";
    }

    private record Entry(String value, int timestamp) {}
}