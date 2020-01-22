Trie树：又叫字典树，是一种多叉树，专门处理字符串匹配问题，比如词频统计。
Trie树的本质是将字符串的公共前缀合并在一起。
Trie树主要有2个操作，一个是将字符串集合构造成Trie树，时间复杂度为O(n)，另一个是在Trie树中查询一个字符串，时间复杂度为O(k)。
Trie树要求字符串中包含的字符集不能太大，要求的字符串前缀重合比较多，否则会
浪费很多的存储空间。
此外，Trie树用到了指针，通过指针链起来的数据块石不连续的，对缓存并不友好。
Trie树比较适合查找前缀匹配的字符串问题，比如搜索关键词的提示功能。
精确匹配查找适合用散列表或者红黑树来解决。
Trie树代码模板：
class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public TrieNode prefixWord(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch  = word.charAt(i);
            if(node.containsKey(ch))
                node = node.get(ch);
            else
                return null;
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = prefixWord(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = prefixWord(prefix);
        return node != null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private String val; //看场景是否需要存储根结点到叶子结点组成的字符串，加该数据成员可简化代码提高效率
    private final int R = 26;
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    } 

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }
}

并查集，使用场景：组团、配对问题，基本操作：
1）makeSet(s)：新建一个并查集，其中包含s个单元素集合
2）unionSet(x,y)：把元素x和元素y所在等集合合并，要求x和y的集合不相交
3）find(x)：找到元素x所在等集合的代表，该操作可用于判断两个元素是否位于
同一个集合

并查集代码模板：
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		if(p !=parent[p]) 
			find(parent[p]);
		return p;
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP != rootQ) {
			parent[rootP] = rootQ; 
			count--;
		}
	}
}

高级搜索：
初级搜索：DFS、BFS，指数级搜索空间，优化方向有不重复和剪枝
高级搜索：双向搜索、启发式搜索(A*搜索)
双向BFS搜索：2个set，每次都从个数少的set开始，可能需要互换2个set
启发式搜索：BFS搜索，队列使用优先级队列，定义优先级需要找到合适的估价函数，
估价函数h(n)是从结点n到目标结点路径到估计成本，估价函数常用曼哈顿距离或者
欧拉距离

AVL树和红黑树：
平衡二叉树有AVL树、红黑树、2-3树、B－树等
AVL树：平衡因子是它的左子树等高度减去它等右子树等高度，值有-1,0,1
有4种旋转操作：左左树－>右旋，右右树－>左旋，左右树－>左旋－>右旋
右左树－>右旋－>左旋。不足：结点需要存储额外信息，且调整次数频繁
红黑树：是一种近视平衡等二叉搜索树，它能确保任何一个结点等左右子树的
高度差小于两倍。特征如下：
1）每个结点要么红色，要么黑色
2）根结点是黑色
3）每个叶结点（NIL结点）是黑色的
4）不能有相邻的两个红色结点
5）从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
AVL树和红黑树的对比：
1）AVL树有更快的查找速度，因为它是更严格的平衡二叉搜索树
2）红黑树有更快的插入和删除速度，因为它是近似的平衡二叉搜索树
3）AVL树需要1个整型数据存储平衡因子，而红黑树只需1个位来存储结点类型
4）红黑树使用在很多语言大类库中，如map、multimap，而AVL树多用在数据库
，因为它需要更快的查询速度


