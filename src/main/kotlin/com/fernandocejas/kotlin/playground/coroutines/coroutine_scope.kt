package com.fernandocejas.kotlin.playground.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch {
        delay(200L)
        println("Run from runBlocking")
    }

    coroutineScope { // Creates a new coroutine scope
        launch {
            delay(1000L)
            println("Run from new launch")
        }

        delay(100L)
        println("Run from coroutine scope") // This line will be printed before nested launch
    }

    println("Coroutine scope is over") // This line is not printed until nested launch completes
}

