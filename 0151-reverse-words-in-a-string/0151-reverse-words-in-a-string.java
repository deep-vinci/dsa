class Solution {
    public String reverseWords(String s) {
        String[] w = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(w));
        return String.join(" ", w);
    }
}