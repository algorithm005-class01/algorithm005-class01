package com.kawo.algorithm.common

import java.util.*
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

/**
 * 日志操作接口
 */
interface LoggerAction{
    fun error(tag :String,message:String)

    fun debug(tag :String,message:String)

    fun info(tag :String,message:String)
}

/**
 * 日志配置接口
 */
interface LoggerConfig{
    fun addProcessor(processor: LoggerProcessor):LoggerConfig

    fun build():LoggerAction
}

/**
 * 日志处理接口
 */
interface LoggerProcessor{
    fun processor(type:LoggerType,tag: String, message: String)
}

/**
 * 日志类型枚举
 */
enum class LoggerType{
    Error,Debug,Info
}

/**
 * 日志实现
 */
class Logger : LoggerAction , LoggerConfig{

    /**
     * 伴生对象
     */
    companion object{

        /**
         * 构建者方法
         */
        fun builder():LoggerConfig{
            return Logger()
        }

    }

    /**
     * 私有构造方法 防止外部直接实例化
     */
    private constructor()

    /**
     * 处理器列表
     */
    private val processors  = ArrayList<LoggerProcessor>()

    /**
     * 添加处理器到Logger对象
     */
    override fun addProcessor(processor: LoggerProcessor):LoggerConfig{
        for (processor in this.processors) {
            if(processor::javaClass == processor::javaClass){
                throw IllegalStateException("处理器中已有该Logger对象,不可重复添加！")
            }
        }
        this.processors.add(processor)
        return this
    }

    /**
     * 构建方法
     */
    override fun build(): LoggerAction {
        return this
    }

    /**
     * 错误日志
     */
    override fun error(tag :String, message:String){
        processor(LoggerType.Error,tag,message)
    }

    /**
     * 调试日志
     */
    override fun debug(tag :String, message:String){
        processor(LoggerType.Debug,tag,message)
    }

    /**
     * 信息日志
     */
    override fun info(tag :String, message:String){
        processor(LoggerType.Info,tag,message)
    }

    /**
     * 处理方法
     */
    private fun processor(type:LoggerType,tag: String, message: String){
        for (processor in processors) {
            processor.processor(type,tag,message)
        }
    }

}

/**
 * 默认日志处理器
 */
class DefaultLoggerProcessor : LoggerProcessor{
    override fun processor(type: LoggerType, tag: String, message: String) {
        var head = if(type == LoggerType.Debug){"💙💙💙"}else if(type==LoggerType.Info){"💚💚💚"}else{"♥️♥️♥️️"}
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val date = Date()
        val timeString = sdf.format(date)
        println("   $head $timeString 【 TAG —— $tag 】 ===>>>  $message")
    }
}