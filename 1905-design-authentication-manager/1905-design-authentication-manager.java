class AuthenticationManager {

    private final Map<String, Integer> tokens;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.tokens = new HashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        
        if (!tokens.containsKey(tokenId) || tokens.get(tokenId) <= currentTime) {
            return;
        }

        tokens.put(tokenId, currentTime + timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        
        var count = 0;

        for (var v : tokens.values()) {
            if (v > currentTime) {
                ++count;
            }
        }

        return count;
    }
}