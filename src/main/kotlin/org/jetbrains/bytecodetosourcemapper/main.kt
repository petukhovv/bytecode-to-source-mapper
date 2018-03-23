package org.jetbrains.bytecodetosourcemapper

import com.xenomachina.argparser.ArgParser

fun main(args : Array<String>) {
    val parser = ArgParser(args)
    val classesDirectory by parser.storing("--classes_directory", help="path to folder with class files (with JVM-bytecode)")
    val sourcesDirectory by parser.storing("--sources_directory", help="path to folder with Kotlin source code files")

    Runner.run(classesDirectory, sourcesDirectory)
}