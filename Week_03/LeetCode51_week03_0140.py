#解法1：回溯法+ 两种对角线分别是-(n-1)~(n-1), 0~2n-2 的范围，如果能放置皇后，就把列，两个对角线去掉，代码设置为1
#默认是以行放置皇后的，所以行不用操作。
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def could_place(row,col):
            return not (cols[col] + hill_diagnals[row-col] + dale_diagnals[row + col])
        
        def place_queen(row,col):
            queens.add((row,col))
            cols[col] = 1
            hill_diagnals[row-col] = 1
            dale_diagnals[row+col] = 1
        
        def remove_queen(row,col):
            queens.remove((row,col))
            
            cols[col] = 0
            hill_diagnals[row - col] = 0
            dale_diagnals[row + col] = 0

        def add_solution():
            Solution = []
            for _,col in sorted(queens):
                Solution.append('.'*col + 'Q' + '.'*(n-1-col))

            output.append(Solution)
        
        def backtrack(row = 0):
            for col in range(n):
                if could_place(row,col):
                    place_queen(row,col)
                    if row + 1 == n:     #遍历到最后一行，递归终止条件
                        add_solution()   #把这个结果加进去
                    else:
                        backtrack(row+1) #找不到，就回溯到下一行
                    remove_queen(row,col)
        
        cols = [0] * n
        hill_diagnals = [0] * (2 * n - 1)
        dale_diagnals = [0] * (2 * n - 1)
        queens = set()
        output = []
        backtrack()
        return output

#解法2 递归法，对解法一进行了简化
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def generateNqueens(queens,xy_dif,xy_sum):
            p =len(queens)
            if p == n:
                result.append(queens)
                return 
            for q in range(n):
                if q not in queens and p-q not in xy_dif and p+q not in xy_sum:
                    generateNqueens(queens+[q],xy_dif + [p-q],xy_sum + [p+q])
        result = []
        generateNqueens([],[],[])
        return [['.' * i + 'Q' + '.' * (n-1-i) for i in sol] for sol in result]


