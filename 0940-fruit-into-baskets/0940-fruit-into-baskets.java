class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int maxLen = 0, len = 0;
        int start = 0, end = 0;
        while(end < fruits.length) {
            if (f.containsKey(fruits[end])) {
                f.put(fruits[end], f.get(fruits[end]) + 1);
            } else {
                f.put(fruits[end], 1);
            }
            
            

            while(f.size() >= 3) {
                f.put(fruits[start], f.get(fruits[start]) - 1);
                if (f.get(fruits[start]) == 0) {
                    f.remove(fruits[start]);
                } 
                start++;
            }
            // if (f.size() == 3) {
            //     if (f.get(fruits[start]) <= 1) {
            //         f.remove(fruits[start]);
            //     } else {
            //         f.put(fruits[start], f.get(fruits[start] - 1));
            //     }
            //     start++;
            // }
            len = end - start + 1;
            if (maxLen < len) {
                maxLen = len;
            }
            end++;
        }


        return maxLen;
    }
}