package aXiaomi;

/**
 * @Author Lyz
 * @Date: 2022/4/4 14:10
 * @Version 1.0
 * <p>
 * 给出一个二维字符数组和一个单词，判断单词是否在数组中出现，
 * 单词由相邻单元格的字母连接而成，相邻单元指的是上下左右相邻。同一单元格的字母不能多次使用。
 * 例如：
 * 给出的字符数组=
 * [
 * ["XYZE"],
 * ["SFZS"],
 * ["XDEE"]
 * ]
 * 单词 ="XYZZED", -> 返回 true,
 * 单词 ="SEE", ->返回 true,
 * 单词 ="XYZY", -> 返回 fXlse.
 */
public class exist {
    public static void main(String[] args) {
        char[][] chars = {{'X', 'Y', 'Z', 'E'},
                {'S', 'F', 'Z', 'S'},
                {'X', 'D', 'E', 'E'}};
        String s = "XYZZED";
        System.out.println(existS(chars, s));
    }

    private static boolean existS(char[][] board, String word) {
        int len = board.length, len1 = board[0].length;
        boolean[][] visited = new boolean[len][len1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len1; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) return true;
            }
        }
        return false;
    }

    private static boolean check(char[][] chars, boolean[][] visited, int i, int j, String s, int k) {
        if (chars[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] ints : dir) {
            int newi = i + ints[0], newj = j + ints[1];
            if (newi >= 0 && newi < chars.length && newj >= 0 && newj < chars[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(chars, visited, newi, newj, s, k + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
