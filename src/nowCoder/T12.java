package nowCoder;

/**
 * @Author Lyz
 * @Date: 2022/4/26 19:11
 * @Version 1.0
 * <p>
 * JZ12 矩阵中的路径
 * <p>
 * 描述
 * 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 数据范围：0 \le n,m \le 20\0≤n,m≤20 ,1\le len \le 25\1≤len≤25
 * 示例1
 * 输入：
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
 * 返回值：true
 * 示例2
 * 输入：
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcb"
 * 返回值： false
 */
public class T12 {
    public static boolean hasPath(char[][] matrix, String word) {
        // write code here
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix,words,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] matrix, char[] words, int i, int j, int k) {
        if (i >= matrix.length || i < 0 || j > matrix[0].length || j < 0 || matrix[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        // 把当前坐标值保存下来，为了最后复原
        char tem = matrix[i][j];
        // 修改当前坐标的值
        matrix[i][j] = '.';
        // 递归,四个方向
        boolean res = dfs(matrix,words,i+ 1, j, k + 1)
                || dfs(matrix,words,i, j + 1, k + 1)
                || dfs(matrix,words,i - 1, j, k + 1)
                || dfs(matrix,words,i, j - 1, k + 1);

        // 递归之后再把当前的左边复原
        matrix[i][j] = tem;
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'd'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String s = "abcced";
        System.out.println(hasPath(matrix, s));
    }
}
