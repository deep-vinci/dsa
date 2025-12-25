class Solution {

    public void reverse(char[] s, int l, int r) {
        if (l >= r) return;

        char t = s[l];
        s[l] = s[r];
        s[r] = t;

        reverse(s, l + 1, r - 1);
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        reverse(s, l, r);
    }
}
