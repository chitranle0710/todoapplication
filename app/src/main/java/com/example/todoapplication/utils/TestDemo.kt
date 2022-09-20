package com.example.todoapplication.utils

class TestDemo {

    private val isEven = IntInterface {
        it % 2 == 0
    }

    fun main() {
        val isEvent = object : IntInter {
            override fun accept(i: Int): Boolean {
                return i % 2 == 0
            }
        }

        isEvent.accept(10)
        isEven.accept(8)
    }

    fun interface IntInterface {
        fun accept(i: Int): Boolean
    }
}

interface IntInter {
    fun accept(i: Int): Boolean
}

class TestDemo2 {
    fun main() {
        val isEvent = object : IntInter {
            override fun accept(i: Int): Boolean {
                return i / 2 == 0
            }
        }

        isEvent.accept(10)
    }
}