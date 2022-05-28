package com.fernandocejas.kotlin.playground.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Suspend function
//Suspend function is a function that could be started, paused, and resume.
//One of the most important points to remember about the suspend functions is that
//they are only allowed to be called from a coroutine or another suspend function.

fun main() = runBlocking { // this: CoroutineScope,run blocking,sequences
    println("hello")
    delay(1000L)
    println("world!")
//    Uncomment and try this
//    doWorld()
}

suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
    // "Hello" will be printed first, due to running non-blocking
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
