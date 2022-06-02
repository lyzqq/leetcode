package t1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Lyz
 * @Date: 2022/5/1 11:28
 * @Version 1.0
 */
public class T1305 {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        inOrder(root1, nums1);
        inOrder(root2, nums2);
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == nums1.size()) {
                res.addAll(nums2.subList(p2, nums2.size()));
                break;
            }
            if (p2 == nums2.size()) {
                res.addAll(nums1.subList(p1, nums1.size()));
                break;
            }
            if (nums1.get(p1) < nums2.get(p2)) {
                res.add(nums1.get(p1++));
            } else {
                res.add(nums2.get(p2++));
            }
        }
        return res;
    }

    private static void inOrder(TreeNode root, List<Integer> nums) {
        if (root != null) {
            inOrder(root.left, nums);
            nums.add(root.val);
            inOrder(root.right, nums);
        }
    }
   /* static List<Integer> res = new ArrayList<>();
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        addNum(root1);
        addNum(root2);
        Collections.sort(res);
        return res;
    }

    private static void addNum(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        addNum(root.left);
        addNum(root.right);
    }*/

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 4};
        Integer[] nums2 = {1, 0, 3};
        TreeNode root1 = TreeNode.convertArrToTree(nums);
        TreeNode root2 = TreeNode.convertArrToTree(nums2);
        System.out.println(getAllElements(root1, root2));
    }
}
