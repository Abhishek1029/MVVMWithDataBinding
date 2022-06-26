package com.abhishek.mvvmwithdatabinding

import kotlinx.coroutines.*

fun main(){
   val abc= CoroutineScope(Dispatchers.IO).async{
    //   delay(3000)
       println("Abhishek")
    }

    CoroutineScope(Dispatchers.IO).launch {
     //   val xyx = abc.await()
        abc.join()
    }
    println("Pandey")
   // Thread.sleep(2000)

}