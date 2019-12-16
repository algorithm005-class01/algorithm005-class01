def trap(height):
    """
    :type height: List[int]
    :rtype: int
   
    1. O(n^2)
    result = 0
    for i in range(len(height)):
        left_min_height, right_min_height = 0, 0
        for j in range(i, len(height)):
            if height[j] > height[i] and height[j] > right_min_height:
                right_min_height = height[j]
        for j in range(i, -1, -1):
            if height[j] > height[i] and height[j] > left_min_height:
                left_min_height = height[j]
        if left_min_height != 0 and right_min_height != 0:
            result += (min(left_min_height, right_min_height)-height[i])
    return result
    """

    # 2. O(n)
    stack = []
    result, cur = 0, 0
    while cur < len(height):
        while len(stack) > 0 and height[cur] > height[stack[-1]]:
            top = stack[-1]
            stack.pop()
            if len(stack) == 0:
                break
            dis = cur - stack[-1] - 1
            bounded_height = min(height[cur], height[stack[-1]]) - height[top]
            result += dis * bounded_height
        stack.append(cur)
        cur += 1
    return result


if __name__ == "__main__":
    print(trap([2, 0, 2]) == 2)
    print(trap([0,1,0,2,1,0,1,3,2,1,2,1]) == 6)
