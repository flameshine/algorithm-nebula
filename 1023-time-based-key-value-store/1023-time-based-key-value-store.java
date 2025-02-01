class TimeMap {

    private final Map<String, List<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if (!map.containsKey(key)) {
            return "";
        }

        var data = map.get(key);
        var left = 0;
        var right = data.size() - 1;

        while (left < right) {
            var middle = (left + right + 1) >>> 1;
            if (timestamp < data.get(middle).timestamp()) {                 
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        var item = data.get(left);

        return item.timestamp() <= timestamp ? item.value() : "";
    }

    private record Data(String value, int timestamp) {}
}