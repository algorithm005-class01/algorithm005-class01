# 70. Climbing Stairs

# You are climbing a stair case. It takes n steps to reach to the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

# Note: Given n will be a positive integer.

# dic = {}

def climbStairs(n):
    """
    :type n: int
    :rtype: int
    """
    # result = 0
    # if n < 2:
    #     return 1
    # if dic.get(n):
    #     result = dic[n]
    # else:
    #     result = climbStairs(n - 1) + climbStairs(n - 2)
    # dic[n] = result
    # return result

    if n < 2:
        return 1
    f1, f2, f3 = 1, 2, 3
    for i in range(3, n+1):
        f3 = f1 + f2
        f1 = f2
        f2 = f3
    return f3

print(climbStairs(4))