import com.geek.sf.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Leecode_144_0116 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        //截至条件
        if(root == null){
            return new ArrayList<>();
        }
        //process
        list.add(root.val);
        //下沉
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}