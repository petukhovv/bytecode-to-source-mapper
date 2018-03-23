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

## Output

At the output, the program creates a file `bytecode_to_source_map.json` in the repo folder (or parent directory of `classesDirectory` or `sourcesDirectory` if you use single mode).

Also the program appends `lineNumbers` (map of methods to line numbers in source files) to map file.

Map file example:
```
{
  "myname/myrepo/classes/net/headlezz/resdiff/BooleanResource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "<init>": {
        "first": 58,
        "second": 58
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/CLOptions.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/CLOptions.kt",
    "lineNumbers": {
      "printHelp": {
        "first": 23,
        "second": 24
      },
      "hasFlag": {
        "first": 26,
        "second": 26
      },
      "getOptionValue": {
        "first": 28,
        "second": 28
      },
      "<init>": {
        "first": 10,
        "second": 19
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/ColorResource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "<init>": {
        "first": 59,
        "second": 59
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/DimensionResource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "<init>": {
        "first": 61,
        "second": 61
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/IntegerResource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "<init>": {
        "first": 60,
        "second": 60
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/ResDiffKt$getFiles$1.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/ResDiff.kt",
    "lineNumbers": {
      "accept": {
        "first": 148,
        "second": 148
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/ResDiffKt.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/ResDiff.kt",
    "lineNumbers": {
      "main": {
        "first": 14,
        "second": 178
      },
      "printDiffNormal": {
        "first": 67,
        "second": 175
      },
      "printDiffInTable": {
        "first": 83,
        "second": 184
      },
      "getDifferencesForClass": {
        "first": 93,
        "second": 187
      },
      "getDifferences": {
        "first": 100,
        "second": 175
      },
      "genResourcePairs": {
        "first": 116,
        "second": 175
      },
      "getFiles": {
        "first": 146,
        "second": 190
      },
      "getResourcesFromFile": {
        "first": 157,
        "second": 182
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/ResdiffPackage.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/ResDiff.kt",
    "lineNumbers": {
      "genResourcePairs": {
        "first": 1,
        "second": 1
      },
      "getDifferences": {
        "first": 1,
        "second": 1
      },
      "getDifferencesForClass": {
        "first": 1,
        "second": 1
      },
      "getFiles": {
        "first": 1,
        "second": 1
      },
      "getResourcesFromFile": {
        "first": 1,
        "second": 1
      },
      "main": {
        "first": 1,
        "second": 1
      },
      "printDiffInTable": {
        "first": 1,
        "second": 1
      },
      "printDiffNormal": {
        "first": 1,
        "second": 1
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/Resource$Companion.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "fromElement": {
        "first": 16,
        "second": 26
      },
      "match": {
        "first": 31,
        "second": 37
      },
      "<init>": {
        "first": 14,
        "second": 14
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/Resource$Type.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {}
  },
  "myname/myrepo/classes/net/headlezz/resdiff/Resource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "match": {
        "first": 46,
        "second": 46
      },
      "matchIdent": {
        "first": 53,
        "second": 53
      },
      "getName": {
        "first": 6,
        "second": 6
      },
      "getValue": {
        "first": 7,
        "second": 7
      },
      "getType": {
        "first": 8,
        "second": 8
      }
    }
  },
  "myname/myrepo/classes/net/headlezz/resdiff/StringResource.class": {
    "file": "myname/myrepo/sources/danijoo-resdiff-0eda9db/src/main/kotlin/net/headlezz/resdiff/Resource.kt",
    "lineNumbers": {
      "<init>": {
        "first": 57,
        "second": 57
      }
    }
  }
}
```

### Program arguments

* `-d` or `--repos_directory`: path to folder with repositories grouped by Github username.

Also you can edit main.kt and change input parameters to `classesDirectory` and `sourcesDirectory` (single mode).
Then you will have to use [RunnerByDirs](https://github.com/PetukhovVictor/bytecode-to-source-mapper/blob/master/src/main/kotlin/org/jetbrains/bytecodetosourcemapper/RunnerByDirs.kt).

### How to run

To run program you must run `main` function in `main.kt`, not forgetting to set the program arguments.

Also you can run jar file (you can download from the [release assets](https://github.com/PetukhovVictor/bytecode-to-source-mapper/releases)):
```
java -jar ./bytecode-to-source-mapper-0.1.jar -d ./repos
```
