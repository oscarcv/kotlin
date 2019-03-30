package com.danger.runner.cmd

import platform.posix.system

class Cmd {
    private lateinit var name: String
    private lateinit var args: Array<out String>

    fun name(name: String) = apply {
        this.name = name
    }

    fun args(vararg args: String) = apply {
        this.args = args
    }

    fun exec() {
        exec(true)
    }

    fun exec(printCallLog: Boolean) {
        "$name ${args.joinToString(" ")}".apply {
            if(printCallLog) println("Executing $this...")
        }.also {
            system(it)
        }
    }
}