package com.kawo.algorithm.common

/**
 * 作业执行者
 */
open class WorkExector private constructor(){

    /**
     * 伴生对象
     */
    companion object{
        /**
         * 构造者
         */
        fun create():WorkExector{
            return WorkExector()
        }
    }

    /**
     * 初始化计时器
     */
    init {
        ConsumeTimeCheck.init()
    }

    /**
     * class对象列表
     */
    protected val classList = ArrayList<Class<*>>()

    /**
     * 注册作业执行器
     */
    inline fun <reified T : BaseExec> registerWork() : WorkExector{
        classList.add(T::class.java)
        return this
    }

    /**
     * 执行
     */
    fun exec(){
        for (clazz in classList) {
            (clazz.newInstance() as BaseExec).exec()
        }
        SpeedTimeStatistics.printSpeedCount()
    }






}