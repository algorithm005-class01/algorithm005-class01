package com.kawo.algorithm.code.weeka.impl

import com.kawo.algorithm.code.weeka.agreement.WeekAExecAgreement
import com.kawo.algorithm.code.weeka.vo.Node
import com.kawo.algorithm.common.LOGGER
import com.kawo.algorithm.common.SpeedTimeStatistics
import com.kawo.algorithm.common.speed

class WeekAExec : WeekAExecAgreement {

    private val engine = WeekAHomeWork()

    override fun maxArea() = speed {
        LOGGER.info("11. 盛最多水的容器 执行完毕","预期结果 49 实际结果:${engine.maxArea(arrayOf(1,8,6,2,5,4,8,3,7))}");
    }

    override fun moveZeroes() = speed {
        var array = arrayOf(0,1,0,3,12)
        engine.moveZeroes(array)
        var string = ""
        for (i in array) {
            string += " $i"
        }
        LOGGER.info("283. 移动零 执行完毕","预期结果 [1,3,12,0,0] 实际结果:$string");
    }

    override fun climbStairs() = speed {
        LOGGER.info("70. 爬楼梯 执行完毕","预期结果 89 实际结果:${engine.climbStairs(10)}");
    }

    override fun threeSum() = speed {
        LOGGER.info("15. 三数之和"," 预期结果:[[-1, 2, -1], [-1, 1, 0]] 实际结果:${engine.threeSum(arrayOf(-1, 0, 1, 2, -1, -4))}");
    }

    override fun reverseKGroup() = speed {
        var start = Node(1)
        var temp : Node = start
        for (i in 2 .. 100){
            temp.next = Node(i)
            temp.next?.apply {
                temp = this
            }
        }
        LOGGER.info("25. K 个一组翻转链表","orginData 原始数据：${nodeToString(start)}")
        LOGGER.info("25. K 个一组翻转链表","orginData 反转后数据：${nodeToString(engine.reverseKGroup(start,5))}")
    }

    private fun nodeToString(node :Node):String{
        var orginData = ""
        var fortemp : Node? = node
        while (fortemp != null){
            orginData += " ${fortemp.data}"
            fortemp = fortemp.next
        }
        return orginData
    }

    override fun detectCycle() = speed {
        var node = Node(0)
        var node1 = Node(1)
        node.next = node1
        node1.next = node
        LOGGER.info("142. 环形链表 II","$node")
        LOGGER.info("142. 环形链表 II","${engine.detectCycle(node)}")
    }

    override fun hasCycle() = speed {
        var node = Node(0)
        var node1 = Node(1)
        node.next = node1
        node1.next = node
        LOGGER.info("141. 环形链表","$node")
        LOGGER.info("141. 环形链表","${engine.detectCycle(node)}")
    }

    override fun swapPairs() = speed {
        var start = Node(1)
        var temp : Node = start
        for (i in 2 .. 99){
            temp.next = Node(i)
            temp.next?.apply {
                temp = this
            }
        }
        LOGGER.info("24. 两两交换链表中的节点","orginData 原始数据：${nodeToString(start)}")
        LOGGER.info("24. 两两交换链表中的节点","orginData 反转后数据：${nodeToString(engine.swapPairs(start))}")
    }

    override fun reverseList() = speed {
        var start = Node(1)
        var temp : Node = start
        for (i in 2 .. 99){
            temp.next = Node(i)
            temp.next?.apply {
                temp = this
            }
        }
        LOGGER.info("206. 反转链表","orginData 原始数据：${nodeToString(start)}")
        LOGGER.info("206. 反转链表","orginData 反转后数据：${nodeToString(engine.reverseList(start))}")
    }

    override fun plusOne() = speed {
        var int = arrayOf(9,1,9,9)
        var string = ""
        engine.plusOne(int).forEach { i ->
            string += i
        }
        LOGGER.info("66. 加一","入参9199 计算结果：$string")
    }

    override fun twoSum() = speed {
        var int = arrayOf(9,1,2,3)
        var string = ""
        engine.twoSum(int,5).forEach { i ->
            string += i
        }
        LOGGER.info("66. 两数相加","入参9 1 2 3 结果为：$string")
    }

    override fun merge() = speed {
        var array1 = arrayOf(1,2,3,0,0,0)
        var array2 = arrayOf(2,5,6)
        var result = ""
        engine.merge(array1,3,array2,3)
        for (i in array1) {
            result += " $i"
        }
        LOGGER.info(" 21. 合并两个有序数组", "入参[1,2,3,0,0,0 [2,4,6]  3 3 结果为：${result}")
    }

    override fun mergeTwoLists() = speed {
        val n11 = Node(1)
        val n12 = Node(2)
        val n13 = Node(4)
        n11.next = n12
        n12.next = n13

        val n21 = Node(1)
        val n22 = Node(3)
        val n23 = Node(4)
        n21.next = n22
        n22.next = n23
        LOGGER.info(" 21. 合并两个有序链表", "入参[1,2,4] [1,3,4] 结果为：${engine.mergeTwoLists(n11,n21)}")
    }

    override fun rotate() = speed {
        var array = arrayOf(1,2,3,4,5,6,7)
        engine.rotate(array,3)
        var result = ""
        for (i in array) {
            result += " $i"
        }
        LOGGER.info(" 189. 旋转数组", "入参[1,2,3,4,5,6,7]  3  结果为：$result")
    }

    override fun removeDuplicates() = speed {
        val array = arrayOf(1,1,2)
        engine.removeDuplicates(array)
        var result = ""
        for (i in array) {
            result += " $i"
        }
        LOGGER.info("  26. 删除排序数组中的重复项", "入参[1,1,2]  结果为：$result")
    }

    override fun trap() = speed {
        LOGGER.info("  42. 接雨水", "入参[0,1,0,2,1,0,1,3,2,1,2,1]  结果为：${engine.trap(arrayOf(0,1,0,2,1,0,1,3,2,1,2,1))}")
    }

    override fun dequeTest() = speed {
        engine.dequeTest()
        LOGGER.info("641. 设计循环双端队列","执行完毕")
    }

    override fun maxSlidingWindow() = speed {
       var array = arrayOf(1,3,-1,-3,5,3,6,7)
       array = engine.maxSlidingWindow(array,3)
        var result = ""
        for (i in array) {
            result += " $i"
        }
        LOGGER.info("239. 滑动窗口最大值","入参 1,3,-1,-3,5,3,6,7  3  结果为$result")
    }

    override fun largestRectangleArea() = speed {
        val array = arrayOf(2,1,5,6,2,3)
        LOGGER.info("84. 柱状图中最大的矩形","入参 2,1,5,6,2,3  结果为${engine.largestRectangleArea(array)}")
    }

    override fun minStack() = speed {
        engine.minStack()
        LOGGER.info("155. 最小栈","执行完毕")
    }

    override fun isValid() = speed {
        LOGGER.info("20. 有效的括号","执行结果:${engine.isValid("(){}")}")
    }


    override fun exec() {
        maxArea()
        moveZeroes()
        climbStairs()
        threeSum()
        reverseKGroup()
        /**循环链表执行会死循环 暂时注释掉*/
        //detectCycle()
        //hasCycle()
        swapPairs()
        reverseList()
        plusOne()
        twoSum()
        merge()
        mergeTwoLists()
        rotate()
        removeDuplicates()
        trap()
        dequeTest()
        maxSlidingWindow()
        largestRectangleArea()
        minStack()
        isValid()
    }

}