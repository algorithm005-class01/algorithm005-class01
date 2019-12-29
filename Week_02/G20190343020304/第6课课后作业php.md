### 课后第一题- 二叉树的中序遍历


给定一个二叉树，返回它的中序 遍历。

例:

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

```


方法一
运行超时
```php

class ColorNode {
        public $color;
        public $node;
        function __construct($a,$b){
            $this->node = $a;
            $this->color = $b;
        }
 }
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function inorderTraversal($root) {
        if($root == null){
            return $root;
        }

         $white = 0;
         $grey = 1;
         $ret = [];
         $ColorNode = new ColorNode($root,$white);
         $stack[] = [$ColorNode];
         while(!empty($stack)){
             $ColorNode = array_pop($stack);
             if($ColorNode->color == $white){
                if($ColorNode->node->right!==null ){
                    $stack[] = [$ColorNode->node->right=>$white];
                } 
                $stack[] = [$ColorNode->node=>$grey];
                if($ColorNode->node->left!==null ){
                    $stack[] = [$ColorNode->node->left=>$white];
                } 
             }else{
                 $ret[] = $ColorNode->node->val;
             }
         }
         return $ret;
    }
}
        
```



