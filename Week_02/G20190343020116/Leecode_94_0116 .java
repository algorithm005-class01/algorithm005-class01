import com.geek.sf.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leecode_94_0116 {
    private ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //边界
        if(root == null){
            return new ArrayList<>();
        }
        //下沉
        inorderTraversal(root.left);
        //process
        list.add(root.val);
        //下沉
        inorderTraversal(root.right);
        return list;

    }
}