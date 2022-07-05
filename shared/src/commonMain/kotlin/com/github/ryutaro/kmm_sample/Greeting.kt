package com.github.ryutaro.kmm_sample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}