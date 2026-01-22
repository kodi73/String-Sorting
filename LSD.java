package string;

public class LSD {
    private static void sort(String[] a, int W) {
        int R = 26;
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++) 
                count[a[i].charAt(d) - 'a' + 1]++;
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++) 
                aux[count[a[i].charAt(d) - 'a']++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        String[] a = {"cat", "mat", "dog", "hat", "dom", "don", "rat", "vat", "run", "cut", "pot", "lot", "put", "rub", "tub", "sub", "dub", "jug", "rug", "mug", "bug", "yak"};
        int N = a.length;
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        sort(a, a[0].length());
        for (int i = 0; i < N; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
