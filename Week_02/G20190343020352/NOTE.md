学习笔记
```python
class RecursionTemplate(object):

    def recursion(self, para1, param2, ...):
        # recursion terminator
        # 递归终结条件
        if level > MAX_LEVEL:
            process result
            return

        # process logic in current level
        # 处理当前层逻辑
        process(level, data...)

        # drill down
        # 下探到下一层
        self.recursion(level + 1, p1, ...)

        # reverse the current level status if needed
        # 清理当前层
```
    
# 注意 (思维要点)
1. 不要进行人肉递归
2. 找到最近最简方法, 将其拆解成可重复解决的问题 -- 重复子问题
3. 数学归纳法思维