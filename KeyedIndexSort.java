package string;


public class KeyedIndexSort {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'd', 'e', 'a', 'b', 'a', 'b', 'a', 'c', 'd', 'e', 'j', 'k', 'r', 't', 'y', 'i', 'u', 's', 'e', 'x', 's', 'u', 'x'};
        System.out.println(a);
        sort(a);
        System.out.println(a);

    }

    public static void sort(char[] a) {
        int R = 26;
        int[] count = new int[R + 1];
        int N = a.length;
        char[] aux = new char[N];

        for (int i = 0; i < N; i++) 
            count[a[i] - 'a' + 1]++;
        for (int r = 0; r < R; r++) 
            count[r + 1] += count[r];
        for (int i = 0; i < N; i++) 
            aux[count[a[i] - 'a']++] = a[i];
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }
}
