package com.kawo.algorithm.common




/**
 * 检查算法耗时工具类
 * 仅用于同步测评
 */
class ConsumeTimeCheck private constructor(private var methodName:String) {


    /**
     * 伴生对象
     */
    companion object {

        /**
         * 构建工具类
         * @param methodName 具体方法名
         */
        fun create(methodName: String): ConsumeTimeCheck {
            return ConsumeTimeCheck(methodName)
        }

        /**
         * 初始化方法
         * 在程序入口调用
         * 避免第一次类加载耗时计入代码耗时中
         */
        fun init(){
            val methodName = "ConsumeTimeCheck 初始化成功 相关类已加载完毕"
            ConsumeTimeCheck.create(methodName).check {}
            SpeedTimeStatistics.reset()
        }

    }

    /**
     * 开始事时间
     */
    private var startTime: Long = 0

    /**
     * 方法开始前执行
     */
    fun begin() {
        startTime = System.nanoTime()
    }

    /**
     * 方法结束后之行
     */
    fun end() {
        val endTime = System.nanoTime()
        val result = endTime - startTime
        SpeedTimeStatistics.consume(result)
        LOGGER.info("ConsumeTimeCheck", "$methodName 方法执行结束 -耗时${String.format("%.4f",result * 0.000001)}毫秒")
    }

    /**
     * 快速check方法
     */
    fun check(block: () -> (Unit)) {
        begin()
        block()
        end()
    }

}

/**
 * 计时器
 */
object SpeedTimeStatistics{

    /**
     * 当前计时
     */
    private var currentSpeed : Long = 0

    /**
     * 消费时间
     */
    fun consume(time : Long){
        currentSpeed += time
    }

    /**
     * 获取总时间
     */
    fun getSpeedCount():Long{
        return currentSpeed
    }

    /**
     * 获取总时间字符串
     */
    fun getSpeedCountStr():String{
        return String.format("%.4f",currentSpeed * 0.000001)
    }

    /**
     * 打印总耗时
     */
    fun printSpeedCount(){
        LOGGER.info("ConsumeTimeCheck", "总耗时 : ${getSpeedCountStr()}毫秒")
        reset()
    }

    /**
     * 重置时间
     */
    fun reset(){
        currentSpeed = 0
    }

}

/**
 * 快速评测代码执行速度
 * 仅用于同步测评
 */
fun speed(block: () -> Unit){
    val methodName = "${Thread.currentThread().stackTrace[2].className}.${Thread.currentThread().stackTrace[2].methodName}"
    ConsumeTimeCheck.create(methodName).check(block)
}