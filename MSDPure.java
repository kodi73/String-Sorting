package string;

public class MSDPure {
    private static final int R = 256;
    private static final int CUTOFF = 15;
    private static String[] aux;

    public static void sort(String[] a) {
        aux = new String[a.length];
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];

        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r <= R + 1; r++) 
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++) 
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }

    private static void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], d); j--) {
                String temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        int i = d;
        while (i < v.length() && i < w.length()) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
            i++;
        }

        return v.length() < w.length();
    }

    public static void main(String[] args) {
        String[] a = {
                        "she",
                        "sells",
                        "sea",
                        "shells",
                        "shore",
                        "the",
                        "by",
                        "sea"
                    };

        for (String s : a)
            System.out.print(s + " ");
        System.out.println();

        sort(a);
        for (String s : a)
            System.out.print(s + " ");
        System.out.println();

    }
}
