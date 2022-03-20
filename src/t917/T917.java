package t917;

/**
 * @Author Lyz
 * @Date: 2022/2/23 11:19
 * @Version 1.0
 *
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class T917 {

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        char[] arr = s.toCharArray();
        while (true) {
            while (left <= right && !Character.isLetter(arr[left])) {
                left++;
            }
            while (left <= right && !Character.isLetter(arr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }
    public void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        T917 t917 = new T917();
//        String s = "a-bC-dEf-ghIj";
        String s = "ab-cd";
        System.out.println(t917.reverseOnlyLetters(s));
    }
}
