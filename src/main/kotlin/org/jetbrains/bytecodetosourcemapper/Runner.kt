package org.jetbrains.bytecodetosourcemapper

import org.jetbrains.bytecodetosourcemapper.io.FileWriter
import org.jetbrains.bytecodetosourcemapper.mapping.BytecodeMetaInfoExtractor
import org.jetbrains.bytecodetosourcemapper.mapping.SourcesSearcher
import org.jetbrains.bytecodetosourcemapper.structures.BytecodeFileMetaInfo
import org.jetbrains.bytecodetosourcemapper.structures.BytecodeToSourceMapElement
import java.io.File

object Runner {
    private const val MAP_FILE_PATH = "./bytecode_to_source_map.json"

    fun run(classesDirectory: String, sourcesDirectory: String) {
        val bytecodeMetaInfoExtractor = BytecodeMetaInfoExtractor()
        val sourcesSearcher = SourcesSearcher(sourcesDirectory)
        val metaInfo = mutableMapOf<File, BytecodeFileMetaInfo>()
        val bytecodeSourceMap = mutableMapOf<File, BytecodeToSourceMapElement?>()

        BytecodeMetaInfoExtractor.walkClassesDirectory(classesDirectory) {
            metaInfo[it] = bytecodeMetaInfoExtractor.extract(it)
        }

        metaInfo.forEach {
            bytecodeSourceMap[it.key] = sourcesSearcher.search(it.value)
        }

        FileWriter.write(MAP_FILE_PATH, bytecodeSourceMap)
    }
}