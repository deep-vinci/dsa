class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        HashMap<Character, Integer> fr = new HashMap<>();
        int r;
        int m = 0;
        for (r = 0; r < s.length(); r++) {
            fr.put(s.charAt(r), fr.getOrDefault(s.charAt(r), 0) + 1);

            while (fr.get(s.charAt(r)) > 1) {
                fr.put(s.charAt(l),  fr.get(s.charAt(l)) - 1);
                l++;
            }

            m = Math.max(m, r-l+1);
        }

        System.out.println(fr);
        System.out.println(l);
        System.out.println(r);
        return m;
    }
}