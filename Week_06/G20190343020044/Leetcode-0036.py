class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # init data
        rows = [{} for i in range(9)]
        columns = [{} for i in range(9)]
        boxes = [{} for i in range(9)]

        # validate a board
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.':
                    num = int(num)
                    box_index = (i // 3 ) * 3 + j // 3
                    
                    # count how many times this number has been used
                    rows[i][num] = rows[i].get(num, 0) + 1
                    if rows[i][num] > 1:
                        return False

                    columns[j][num] = columns[j].get(num, 0) + 1
                    if columns[j][num] > 1:
                        return False

                    boxes[box_index][num] = boxes[box_index].get(num, 0) + 1
                    if boxes[box_index][num] > 1:
                        return False
        return True
