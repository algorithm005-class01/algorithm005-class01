package G20190343020064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 二叉树的序列化与反序列化
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-27 6:27 下午
 */
public class LeetCode_297_0064 {

    public static void main(String[] args) {
        LeetCode_297_0064 func = new LeetCode_297_0064();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = func.serialize(root);
        System.out.println(serialize);
        String[] split = serialize.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return this.serializeNode(root, "");
    }

    public String serializeNode(TreeNode root,String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serializeNode(root.left,str);
            str = serializeNode(root.right,str);
        }
        return str;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return this.deserializeNode(list);
    }

    public TreeNode deserializeNode(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        node.left = deserializeNode(data);
        node.right = deserializeNode(data);
        return node;
    }



}
