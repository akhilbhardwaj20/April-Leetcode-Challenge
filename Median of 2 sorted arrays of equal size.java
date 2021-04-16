class Merge {

// TC - O(logn)
    private int median(int[] arr, int s, int e) {
        return (arr[(s + e) / 2] + arr[(s + e + 1) / 2]) / 2;
    }

    int find_median(int[] a, int[] b, int Sa, int Sb, int Ea, int Eb) {
        if (Ea - Sa <= 1)
            return (Math.max(a[Sa], b[Sb]) + Math.min(a[Ea], b[Eb])) / 2;
        int m1 = median(a, Sa, Ea);
        int m2 = median(b, Sb, Eb);
        if (m1 == m2)
            return m1;
        if (m1 > m2)
            return find_median(a, b, Sa, (Sb + Eb + 1) / 2, (Sa + Ea + 1) / 2, Eb);
        return find_median(a, b, (Sa + Ea + 1) / 2, Sb, Ea, (Sb + Eb + 1) / 2);
    }
}
