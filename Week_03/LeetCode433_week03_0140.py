#解法1： BFS 
class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        bank = set(bank)
        if end not in bank:
            return -1

        
        change = {'A':'TCG','T':'ACG','C':'ATG','G':'ATC'} #用哈希表处理基因的一次转换问题
        q = [(start,0)]

        while q:
            node, length = q.pop(0)
            if node == end:
                return length

            for i,s in enumerate(node):
                for j in change[s]:
                    new = node[:i]+ j + node[i+1:]  #基因变化的三种可能
                    if new in bank:
                        q.append((new,length+1))
                        bank.remove(new)       #把bank 里的基因序列去除掉，减少了遍历次数，也减少了重复转换的问题
        return -1

#解法2 BFS 但是用了validchange去验证基因是否只变化了一次，其他的是套用BFS 模板
class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        def validchange(start,object):
            changes = 0
            for i in range(len(start)):
                if start[i] != object[i]:
                    changes += 1
            return changes == 1
        
        queue = [(start,0)]
        visited = set()
        while queue:
            cur,steps =queue.pop(0)
            visited.add(cur)
            if cur == end:
                return steps
            for string in bank:
                if validchange(cur,string) and string not in visited:
                    queue.append([string,steps+1])
        return -1

#解法3: 用zip() 函数去比较两个基因， 如果只变化过一次，那就是所需的序列，其他的是BFS 模板
class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        queue = [(start,0)]
        visited = set()
        while queue:
            cur,steps =queue.pop(0)
            visited.add(cur)
            if cur == end:
                return steps
            for string in bank:
                if string not in visited and sum([s1 != s2 for s1,s2 in zip(string,cur)]) == 1:
                    queue.append([string,steps+1])
        return -1

