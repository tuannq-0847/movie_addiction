package com.example.movieaddiction

import android.util.Log

object Karl {

    fun i(message: String, customTag: String = "") {
        if (BuildConfig.DEBUG) {
            val callerClass = Thread.currentThread().stackTrace[3]
            val methodName = callerClass?.methodName
            val fileName = callerClass?.className
            val lineOfCode = callerClass?.lineNumber
            Log.i(fileName, "[method: $methodName] [line: $lineOfCode] $message")
        }
    }

    fun e(message: String, throwable: Throwable, customTag: String = "") {
        if (BuildConfig.DEBUG) {
            val callerClass = Thread.currentThread().stackTrace[3]
            val methodName = callerClass?.methodName
            val fileName = callerClass?.className
            val lineOfCode = callerClass?.lineNumber
            Log.d(
                fileName,
                "[method: $methodName] [line: $lineOfCode] $message",
                throwable
            )
        }
    }

    fun d(message: String) {
        if(BuildConfig.DEBUG){
            Log.d(
                Thread.currentThread().stackTrace[3].fileName,
                "[method: ${Thread.currentThread().stackTrace[3].methodName}] [line: ${Thread.currentThread().stackTrace[3].lineNumber}] $message"
            )
        }
    }
}