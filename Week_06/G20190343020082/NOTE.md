###学习笔记

- 单词搜索2时间复杂度分析
> 建立trie树 单词平均长度l，单词数n，复杂度O(ln)
>
> 遍历二维数组 数组大小i*j，去trie树中查询，平均l次判断，O(ijl)
>
>二者相加
 
- 双向BFS模板
```
while front:
   	node = front.pop() 
   	visited.add(node)
   
   	process(node) 
   	nodes = generate_related_nodes(node) 
   	front.push(nodes)
       
       if len(back) < len(front):
           front, back = back, front
```
