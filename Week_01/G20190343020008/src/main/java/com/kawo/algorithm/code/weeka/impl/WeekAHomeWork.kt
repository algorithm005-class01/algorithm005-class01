package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAHomeWorkAgreement
import com.kawo.algorithm.code.weeka.util.MinStack
import com.kawo.algorithm.code.weeka.vo.Node
import java.util.*
import kotlin.math.max
import kotlin.math.min


class WeekAHomeWork : WeekAHomeWorkAgreement {

    override fun maxArea(height: Array<Int>): Int {
        /**初始化左边界为0*/
        var left = 0
        /**初始化右边界为最右坐标*/
        var right: Int = height.size - 1
        /**初始化结果为0*/
        var result = 0
        /**当左侧与右侧不相遇时执行以下操作*/
        while (left < right) {
            /**右坐标减去左坐标 获得矩形的长*/
            val w = right.minus(left)
            /**比较两根柱子 哪一根比较短就当作宽*/
            val h = min(height[left], height[right])
            /**相乘获得面积*/
            result = max(result, w * h)
            /**当左侧柱子比右侧柱子低时 柱子往内靠近一格 相反 右侧柱子往内靠近一格*/
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return result
    }

    override fun moveZeroes(nums: Array<Int>) {
        var j = 0
        /**循环把非零数字都移动到最前方*/
        for (num in nums) if (num != 0) {
            nums[j++] = num
        }
        /**循环把 数组size - 非零数字size 剩余的数组元素 重置为0*/
        for (i in j until nums.size) {
            nums[i] = 0
        }
    }

    /**
     * 递归完成非波拉契数列
     */
    override fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        } else if (n == 2) {
            return 2
        }
        return  climbStairs(n - 1) + climbStairs(n - 2)
    }

    override fun threeSum(nums: Array<Int>): List<List<Int>> {
        /**排序*/
        Arrays.sort(nums)
        /**初始化结果值*/
        val result = LinkedList<List<Int>>()
        /**外层循环 判断那两个数和他相加为）*/
        for (k in 0 until nums.size - 1) {
            /**初始化左坐标 为k+1*/
            var left = k + 1
            /** 初始化右坐标 为数组size -1*/
            var right = nums.size - 1
            /** 获取外层循环的Item数值*/
            var num = nums[k]
            /** 如果num==0 说明三个数都为正数 相加不会为0 */
            if (num > 0) break
            /** 如果k>0 并且k坐标的数字和k-1坐标数字一致 则则表示该数值已被计算 不必重复计算 跳过即可*/
            if (k > 0 && nums[k] == nums[k - 1]) continue
            /**当两侧不相遇时执行以下代码*/
            while (left < right) {
                /**计算三数之和*/
                var count = num + nums[left] + nums[right]
                /**和大于0时 说明右侧数字过大 把右侧相同的数字通过减下标的形式跳过*/
                if (count > 0) {
                    while (left < right && nums[right] == nums[--right]);
                    /**小于0时 说明左侧数字过小 把左侧相同的数字通过增加下标的形式跳过*/
                } else if (count < 0) {
                    while (left < right && nums[left] == nums[++left]);
                    /**结果匹配 过滤掉相同的数字*/
                } else {
                    result.add(listOf(num, nums[right], nums[left]))
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result
    }

    override fun reverseKGroup(head: Node, k: Int): Node {
        var pre :Node? = null
        var next :Node? = null
        var cur :Node? = head
        var check:Node? = head
        var can = 0
        var count = 0
        /**检查链表长度是否在k范围中*/
        while (can < k && check != null){
            check = check.next
            can +=1
        }
        /**如果链表长度在k范围，反转链表 相反字节返回原链表头*/
        return if(can == k){
            /** 当计数器还在k范围内 并且当前游标不为null*/
            while (count < k  && cur != null){
                next = cur.next /**下个节点赋值*/
                cur.next = pre /**当前节点下个节点赋值为上个节点*/
                pre = cur  /**上个节点赋值为当前节点*/
                cur = next /**把当前节点赋值为下个节点*/
                count ++ /**添加计数器*/
            }
            /**
             * 下个节点不为null时，继续递归反转
             */
            if(next != null){
                head.next = reverseKGroup(next,k)
            }
            return pre!!
        }else{
            head
        }
    }

    override fun detectCycle(head: Node): Node? {
        /**快指针*/
        var fast :Node? = head
        /**慢指针*/
        var slow :Node? = head
        /**循环查找环*/
        while (true) {
            /**如果链表中有值为空，证明此链表无环*/
            if (fast?.next == null) return null
            /**快指针指向当前节点的下下节点*/
            fast = fast?.next?.next
            /**慢指针 指向下一个节点*/
            slow = slow?.next
            /**当下个节点等于下一个证明链表有环 并退出循环*/
            if (fast == slow) break
        }
        /**重置快节点为首节点*/
        fast = head
        /**当快慢节点不同时 也就是首尾没有相交时 执行循环 一直到首尾相接时退出循环 这是快指针就是环的入口*/
        /**快节点走了 慢节点两倍的步数 当快节点设为开始节点时 两个节点再走一半距离两个节点就会相遇 相遇后fast节点就是环入口*/
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        /**返回环的入口节点*/
        return fast
    }

    override fun hasCycle(head: Node): Boolean {
        /**快指针*/
        var fast : Node? = head
        /**慢指针*/
        var slow : Node? = head
        /**当快指针为null 活着快指针的下个节点为null 则无环 反之进入循环校验*/
        while (fast != null || fast?.next == null){
            fast = fast?.next?.next
            slow = slow?.next
            /**快指针 慢指针相遇 该链表有环*/
            if(fast == slow){
                return true
            }
        }
        return false
    }


    override fun swapPairs(head: Node): Node {
        /**把头节点的下个节点置为新节点*/
        val newNode = head.next
        /**当新节点为null时直接返回head 代表剩余元素不足两个 无需反转*/
        if (newNode == null) {
            return head
        /**当新节点不为null时 把头节点的下一个节点重置为头节点的下下个节点 且把新节点的下个节点指向头节点 完成节点转制*/
        } else {
            head.next = newNode.next
            newNode.next = head
        }
        /**当下下个节点不为null时 继续转制剩余节点*/
        if (head.next != null) {
            head.next = swapPairs(head.next!!)
        }
        /**返回转制完成的头节点*/
        return newNode
    }

    override fun reverseList(head: Node): Node {
        /**设置当前坐标*/
        var cur = head
        /**当下个节点不为null时执行*/
        if(head.next != null){
            /**递归转制 下一个坐标*/
            cur = reverseList(head.next!!)
            /**添加反向链表节点*/
            head.next!!.next = head
            /**防止链表有环 置空正向链表节点 使链表结构变为反向*/
            head.next = null
        }
        return cur
    }

    override fun plusOne(digits: Array<Int>): Array<Int> {
        /**倒叙循环*/
        for (i in digits.size - 1 downTo 0) {
            /**每个数字先自增加一*/
            digits[i]++
            /**求余数 用此方法把值为10可以进一位的数字 变为0*/
            digits[i] = digits[i] % 10
            /**当处理完后 当有一位数字不为零时 代表此数组不满足增加新一位的要求 直接返回结果*/
            if (digits[i] !== 0) return digits
        }
        /**新建数组 位数为原数组位数加一 且默认值都为0 因为走到这一步 代表原数组加一后所有的位数均是0 需要新增加一位数组元素到数组头 且首位为1*/
        var digits = Array(digits.size + 1) {0}
        digits[0] = 1
        return digits
    }

    override fun twoSum(nums: Array<Int>, target: Int): Array<Int> {
        /**新建一个HashMap用来存储计算过的值*/
        val map = HashMap<Int, Int>()
        /**遍历计算*/
        for (i in 0 until nums.size) {
            /**获取目标值减去 当前数字的差*/
            val complement = target - nums[i]
            /**看计算过的数字是否有和差值相同的*/
            if (map.containsKey(complement)) {
                /**如果有相同的 从map中拿取坐标 和 当前数字坐标一起返回*/
                return arrayOf(map[complement]!!, i)
            }
            /**如果没有找到合适的值 把当前计算过的数值放到HashMap中缓存*/
            map[nums[i]] = i
        }
        return arrayOf()
    }

    override fun merge(nums1: Array<Int>, m: Int, nums2: Array<Int>, n: Int) {
        /**指向nums1的尾部*/
        var enda = m - 1
        /**指向nums2的尾部*/
        var endb = n - 1
        /**指向nums1尾部 遍历比较*/
        var len = m + n - 1
        while (enda >= 0 && endb >= 0) { // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = if (nums1[enda] > nums2[endb]) nums1[enda--] else nums2[endb--]
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, endb + 1)
    }

    override fun mergeTwoLists(l1: Node?, l2: Node?): Node? {
        /**1链表节点为空时返回2链表*/
        if (l1 == null) {
            return l2
        }
        /**2链表节点为空时返回1链表*/
        if (l2 == null) {
            return l1
        }
        return if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }

    override fun rotate(nums: Array<Int>, k: Int) {
        /**临时存储*/
        var temp: Int
        /**上一个*/
        var previous: Int
        /**遍历操作旋转*/
        for (i in 0 until k) {
            previous = nums[nums.size - 1]
            for (j in nums.indices) {
                temp = nums[j]
                nums[j] = previous
                previous = temp
            }
        }
    }

    override fun removeDuplicates(nums: Array<Int>): Int {
        /**如果长度为0 不删除*/
        if (nums.isEmpty()) return 0
        /**存储临时值 用来计算重复*/
        var k = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }

    override fun trap(height: Array<Int>): Int {
        val getMax = {height : Array<Int> -> Int
            var max = 0
            for (i in height.indices) {
                if (height[i] > max) {
                    max = height[i]
                }
            }
            max
        }
        var sum = 0
        /**遍历寻找最大高度*/
        val max = getMax(height)
        for (i in 1..max) {
            /**设置更新标记*/
            var isStart = false
            var temp_sum = 0
            for (j in height.indices) {
                if (isStart && height[j] < i) {
                    temp_sum++
                }
                if (height[j] >= i) {
                    sum += temp_sum
                    temp_sum = 0
                    isStart = true
                }
            }
        }
        return sum
    }

    override fun dequeTest() {
        com.kawo.algorithm.code.weeka.util.Deque(10)
    }

    override fun maxSlidingWindow(nums: Array<Int>, k: Int): Array<Int> {
        /**判断小概率事件*/
        if (nums.size < 2) return nums
        val queue: LinkedList<Int?> = LinkedList()
        val result = Array(nums.size - k + 1) {0}
        /**遍历数组*/
        for (i in nums.indices) {
            /**保证从大到小依次弹出*/
            while (!queue.isEmpty() && nums[queue.peekLast()!!] <= nums[i]) {
                queue.pollLast()
            }
            /**添加当前值对应下标*/
            queue.addLast(i)
            // 判断当前队列中队首的值是否有效
            if (queue.peek()!! <= i - k) {
                queue.poll()
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()!!]
            }
        }
        return result
    }

    override fun largestRectangleArea(heights: Array<Int>): Int {
        val stack = Stack<Int>()
        stack.push(-1)
        var maxArea = 0
        for (i in heights.indices) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) maxArea = maxArea.coerceAtLeast(heights[stack.pop()] * (i - stack.peek() - 1))
            stack.push(i)
        }
        while (stack.peek() != -1) maxArea = maxArea.coerceAtLeast(heights[stack.pop()] * (heights.size - stack.peek() - 1))
        return maxArea
    }

    override fun minStack() {
        MinStack()
    }
    private val map: HashMap<Char, Char> = object : HashMap<Char, Char>() {
        init {
            put('{', '}')
            put('[', ']')
            put('(', ')')
            put('?', '?')
        }
    }

    override fun isValid(s: String): Boolean {
        if (s.isNotEmpty() && !map.containsKey(s[0])) return false
        val stack: LinkedList<Char> = object : LinkedList<Char>() {
            init {
                add('?')
            }
        }
        for (c in s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c) else if (map[stack.removeLast()] !== c) return false
        }
        return stack.size == 1    }
}