package com.kotlin.baselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor(){
    private val activityStack : Stack<Activity> =Stack()

    companion object{
        val instance:AppManager by lazy {AppManager()}
    }
    //壓入Activity
    fun pushActivity(activity: Activity){
        activityStack.add(activity)
    }

    //出棧Activity
    fun popActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    //獲取棧頂activity
    fun getTopActivity(): Activity {
        return activityStack.lastElement()
    }

    // 清理所有Activity
    fun finishAllActivity(){
     for(activity in activityStack){
         activity.finish()
     }
     activityStack.clear()
    }

        //退出
    fun exitApp(context: Context){
            finishAllActivity()
            val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityManager.killBackgroundProcesses(context.packageName)
            System.exit(0)
        }
}