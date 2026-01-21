class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int n = digits.length;
        int i = n-1;

        while(i >= 0) {
            if (digits[i] + c >= 10) {
                // System.out.printf("%d %d\n", digits[i]+c, i);
                digits[i] = 0;
                c = 1;
            } else {
                digits[i] = digits[i] + c;
                c = 0;
            }
            // System.out.println(Arrays.toString(digits));
            i--;

            // System.out.printf("%d %d\n", i, c);

            if (c == 1 && i < 0) {
                int narr[] = new int[n+1];
                narr[0] = c;
                for (int j = 1; j < narr.length; j++) {
                    narr[j] = digits[j-1];
                }

                return narr;
                // System.out.println(Arrays.toString(narr));
            }
        }
        // digits[n-1] += c;
        
        return digits;
    }
}