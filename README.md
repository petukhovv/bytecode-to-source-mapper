# bytecode-to-source-mapper
Mapping JVM-bytecode files (.class files) to corresponding Kotlin source code files

## Program use

The program extracts meta information from .class files.

Based on the received source file name and the package name, the program searches required file in the specified directory with source code files.

Package names are extracted from the source code files using the following regular expression:
```
(?:^|\\s|;)package (?<package>(?:\\.?\\w+)+)(?:\\s|;|$)
```

Before package name extracting from the file, all comments and strings are deleted.

### Program arguments

* `-d` or `--repos_directory`: path to folder with repositories grouped by Github username.

Also you can edit main.kt and change input parameters to classesDirectory and sourcesDirectory (single mode).
Then you will have to use [RunnerByDirs](https://github.com/PetukhovVictor/bytecode-to-source-mapper/blob/master/src/main/kotlin/org/jetbrains/bytecodetosourcemapper/RunnerByDirs.kt).

### How to run

To run program you must run `main` function in `main.kt`, not forgetting to set the program arguments.

Also you can run jar file (you can download from the [release assets](https://github.com/PetukhovVictor/bytecode-to-source-mapper/releases)):
```
java -jar ./bytecode-to-source-mapper-0.1.jar -d ./repos
```
