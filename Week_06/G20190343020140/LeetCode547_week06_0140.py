#解法1 并查集 加了parent 数组和rank秩，路径压缩
class UnionFind:
    def __init__(self,n):
        self.count = n 
        self.parent = [i for i in range(n)]
        self.rank = [1 for i in range(n)]
    
    def get_count(self):
        return self.count
    
    def find(self,p):
        while p != self.parent[p]:
            self.parent[p] = self.parent[self.parent[p]]
            p = self.parent[p]
        return p 
    
    def is_connected(self,p,q):
        return self.find(p) == self.find(q)
    
    def union(self,p,q):
        p_root = self.find(p)
        q_root = self.find(q)
        print("p_root = j", p_root)
        print('q_root = i',q_root)
        if p_root == q_root:
            return 
        if self.rank[p_root] > self.rank[q_root]:
            self.parent[q_root] = p_root
        elif self.rank[p_root] < self.rank[q_root]:
            self.parent[p_root] = q_root
        else:
            self.parent[q_root] = p_root
            self.rank[p_root] += 1
        print("parent",self.parent)
        print("rank",self.rank)
        self.count -= 1
        print("count",self.count)

def findCircleNum(M):
    """
    :type M: List[List[int]]
    :rtype: int
    """
    m = len(M)
    print("m",m)
    union_find_set = UnionFind(m)
    for i in range(m):
        for j in range(i):
            if M[i][j] == 1:
                union_find_set.union(j,i)
    return union_find_set.get_count()

#解法2 BFS
class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        circlenum = 0 
        checkedFlg = [0] * len(M)
        queue =[]
        while (0 in checkedFlg):
            circlenum += 1
            newperson = checkedFlg.index(0)
            queue.append(newperson)
            checkedFlg[newperson] = 1
            while queue:
                cur = queue.pop()
                for i,v in enumerate(M[cur]):
                    if v == 1 and checkedFlg[i] == 0:
                        queue.append(i)
                        checkedFlg[i] = 1
        return circlenum

#解法3 DFS 染色法
class Solution(object):
    white = 1
    grey = 2
    black = 3
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        self.M = M
        n = len(M)
        self.colorMap = [self.white] * n 
        group = 0
        for i in range(n):
            if self.colorMap[i] == self.white:
                group += 1
                self.dfs(i)
        return group
    
    def dfs(self,i):
        self.colorMap[i] = self.grey
        for f,v in enumerate(self.M[i]):
            if v == 1 and self.colorMap[f] == self.white:
                self.dfs(f)
        self.colorMap[i] = self.black

