class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        
        var letters = 0;

        for (var word : words) {

            if (word.length() + current.size() + letters > maxWidth) {

                for (var i = 0; i < maxWidth - letters; i++) {
                    var index = i % (current.size() - 1 > 0 ? current.size() - 1 : 1);
                    current.set(index, current.get(index) + " ");
                }

                var line = String.join("", current);

                result.add(line);
                current.clear();
                
                letters = 0;
            }

            current.add(word);

            letters += word.length();
        }

        var last = new StringBuilder();

        for (var i = 0; i < current.size(); i++) {
            
            last.append(current.get(i));

            if (i != current.size() - 1) {
                last.append(" ");
            }
        }

        while (last.length() < maxWidth) {
            last.append(" ");
        }

        result.add(last.toString());

        return result;
    }
}