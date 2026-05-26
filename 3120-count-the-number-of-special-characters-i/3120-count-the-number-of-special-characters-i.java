class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else if (Character.isUpperCase(ch)) {
                upper.add(Character.toLowerCase(ch));
            }
        }

        int count = 0;

        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }

        return count;
        
    }
}