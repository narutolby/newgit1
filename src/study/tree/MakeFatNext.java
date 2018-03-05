package study.tree;

public class MakeFatNext {

    public int[][] makeFatNext(char[] s, char inf, char sup) {
        int n = s.length;
        int[][] next = new int[sup - inf + 1][n + 1];
        for (int i = 0; i < sup - inf + 1; i++){
            next[i][n] = n + 1;
        }
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = 0; j < sup - inf + 1; j++) next[j][i] = next[j][i + 1];
            next[s[i] - inf][i] = i + 1;
        }
        return next;
    }
}
