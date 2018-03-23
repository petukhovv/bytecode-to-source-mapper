package org.jetbrains.bytecodetosourcemapper.structures

typealias LineNumberBounds = MutableSet<Pair<Int, Int>>

data class BytecodeFileMetaInfo(
        val packageName: String,
        val sourceFileName: String,
        val lineNumberBounds: LineNumberBounds
)