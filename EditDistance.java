import java.util.*;


class EditDistance {
    public static int calcEditDistance(String s, String t) {
        String[] n = s.split("");
        String[] m = t.split("");
        int nLength = n.length+1;
        int mLength = m.length+1;
        int[][] d = new int[nLength][mLength];

        for (int i = 1; i < nLength; i++) {
            d[i][0] = i;
        }

        for (int j = 1; j < mLength; j++) {
            d[0][j] = j;
        }

        for (int j = 1; j < mLength; j++) {
            for (int i = 1; i < nLength; i++) {
                int insertion = d[i][j-1] + 1;
                int deletion = d[i-1][j] + 1;
                int match = d[i-1][j-1];
                int mismatch = d[i-1][j-1] + 1;

                if (n[i-1].equals(m[j-1])) {
                    d[i][j] = Math.min(insertion, Math.min(deletion, match));
                } else {
                    d[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
                }
            }
        }
        return d[nLength-1][mLength-1];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(calcEditDistance(s, t));
    }
}