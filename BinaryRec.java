class BinaryRec {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,61,71,82,239};
        int target = 82;
        System.out.printf("idx: %d\narr[idx] = %d\n", binary(0, arr.length-1, target, arr), arr[binary(0, arr.length-1,target, arr)]);
    }

    static int binary(int low, int high, int x, int[] arr) {
        int mid = (low + high)/2;
        int lo = arr[low];
        int hi = arr[high];
        int mi = arr[mid];
        if (mi == x) return mid;
        if (x > hi || x < lo) return -1;

        if (x < mi) high = mid;
        if (x > mi) low = mid;

        return binary(low, high, x, arr);
    }
}