package string;

public class LongestRepeatedSubstring {
    public static String lrs(String s) {
        int N = s.length();

        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) 
            suffixes[i] = s.substring(i, N);

        ThreeWayStringQuicksort.sort(suffixes);

        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            int len = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
            if (len > lrs.length())
                lrs = suffixes[i].substring(0, len);
        }

        return lrs;
    }

    private static int longestCommonPrefix(String v, String w) {
        int min = v.length() < w.length() ? v.length() : w.length();
        int count = 0;

        for (int i = 0; i < min; i++) {
            if (v.charAt(i) != w.charAt(i)) return count;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aacaagtttacaagc";
        System.out.println("The longest common substring is: " + lrs(s));
    }
}
