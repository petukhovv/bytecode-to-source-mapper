package org.jetbrains.bytecodetosourcemapper

import org.jetbrains.bytecodetosourcemapper.mapping.BytecodeMetaInfoExtractor
import org.jetbrains.bytecodetosourcemapper.structures.BytecodeFileMetaInfo
import java.io.File

object Runner {
    fun run(classesDirectory: String, sourcesDirectory: String) {
        val bytecodeMetaInfoExtractor = BytecodeMetaInfoExtractor()
        val metaInfo = mutableMapOf<File, BytecodeFileMetaInfo>()

        BytecodeMetaInfoExtractor.walkClassesDirectory(classesDirectory) {
            metaInfo[it] = bytecodeMetaInfoExtractor.extract(it)
        }
    }
}