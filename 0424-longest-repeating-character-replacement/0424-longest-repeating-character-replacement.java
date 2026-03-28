class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int ans = 0;

        HashMap<Character, Integer> f = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            f.put(c, f.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, f.get(c));

            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                f.put(leftChar, f.get(leftChar) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
