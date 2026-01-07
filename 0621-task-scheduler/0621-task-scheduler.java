class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int f_max = 0;
        for (int f : map.values()) {
            f_max = Math.max(f_max, f);
        }

        int count_max = 0;
        for (int f : map.values()) {
            if (f == f_max) count_max++;
        }

        int intervals = (f_max - 1) * (n + 1) + count_max;
        return Math.max(intervals, tasks.length);
    }
}
