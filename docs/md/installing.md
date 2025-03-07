<!--
  Copyright 2023, Gerwin Klein, Régis Décamps, Steve Rowe
  SPDX-License-Identifier: CC-BY-SA-4.0
-->

Installing and Running JFlex {#Installing}
============================

Installing JFlex
----------------

### Windows

To install JFlex on Windows, follow these three steps:

1.  Unzip the file you downloaded into the directory you want JFlex in.
    If you unzipped it to say `C:\`, the following directory structure
    should be generated:

```
    C:\jflex-$VERSION\
        +--bin\                        (start scripts)
        +--doc\                        (FAQ and manual)
        +--examples\
            +--byaccj\                 (calculator example for BYacc/J)
            +--cup-maven\              (calculator example for cup and maven)
            +--interpreter\            (interpreter example for cup)
            +--java\                   (Java lexer specification)
            +--simple\                 (example scanner with no parser)
            +--standalone-maven\       (a simple standalone scanner,
                                        built with maven)
            +--zero-reader\            (Readers that return 0 characters)
        +--lib\                        (precompiled classes)
        +--src\
            +--main\
                +--config\             (PMD source analyzer configuration)
                +--cup\                (JFlex parser spec)
                +--java\
                    +--jflex\          (source code of JFlex)
                        +--anttask\    (source code of JFlex Ant Task)
                        +--gui\        (source code of JFlex UI classes)
                        +--unicode\    (source code for Unicode properties)
                +--jflex\              (JFlex scanner spec)
                +--resources\          (messages and default skeleton file)
            +--test\                   (unit tests)
```

2.  Edit the file **`bin\jflex.bat`** (in the example it’s
    `C:\jflex-$VERSION\bin\jflex.bat`) such that

    -   **`JAVA_HOME`** contains the directory where your Java JDK is
        installed (for instance `C:\java`) and

    -   **`JFLEX_HOME`** the directory that contains JFlex (in the
        example: `C:\jflex-$VERSION`)

3.  Include the `bin\` directory of JFlex in your path. (the one that
    contains the start script, in the example: `C:\jflex-$VERSION\bin`).


### Mac/Unix with tar

To install JFlex on a Mac or Unix system, follow these two steps:

-   Decompress the archive into a directory of your choice with GNU tar,
    for instance to `/usr/share`:

    `tar -C /usr/share -xvzf jflex-$VERSION.tar.gz`

    (The example is for site wide installation. You need to be root for
    that. User installation works exactly the same way — just choose a
    directory where you have write permission)

-   Make a symbolic link from somewhere in your binary path to
    `bin/jflex`, for instance:

    `ln -s /usr/share/jflex-$VERSION/bin/jflex /usr/bin/jflex`

    If the Java interpreter is not in your binary path, you need to
    supply its location in the script `bin/jflex`.

You can verify the integrity of the downloaded file with the SHA1 checksum
available on the [JFlex download page](http://jflex.de/download.html). If you
put the checksum file in the same directory as the archive, and run:

`shasum --check jflex-$VERSION.tar.gz.sha1`

it should tell you

`jflex-$VERSION.tar.gz: OK`


Running JFlex
-------------

You run JFlex with:

`jflex <options> <inputfiles>`

It is also possible to skip the start script in `bin/` and include the
file `lib/jflex-$VERSION.jar` in your `CLASSPATH` environment
variable instead.

Then you run JFlex with:

`java jflex.Main <options> <inputfiles>`

or with:

`java -jar jflex-$VERSION.jar <options> <inputfiles>`

The input files and options are in both cases optional. If you don’t
provide a file name on the command line, JFlex will pop up a window to
ask you for one.

JFlex knows about the following options:

`-d <directory>`\
writes the generated file to the directory `<directory>`

`--encoding <name>`\
uses the character encoding `<name>` (e.g. `utf-8`) to read lexer
specifications and write java files.

`--skel <file>`\
uses external skeleton `<file>` in UTF-8 encoding. This is mainly for JFlex
maintenance and special low level customisations. Use only when you know what
you are doing! JFlex comes with a skeleton file in the `src` directory that
reflects exactly the internal, pre-compiled skeleton and can be used with the
`-skel` option.

`--nomin`\
skip the DFA minimisation step during scanner generation.

`--jlex`\
tries even harder to comply to JLex interpretation of specs.

`--dot`\
generate graphviz dot files for the NFA, DFA and minimised DFA. This
feature is still in alpha status, and not fully implemented yet.

`--dump`\
display transition tables of NFA, initial DFA, and minimised DFA

`--legacydot`\
dot (`.`) meta character matches `[^\n]` instead of\
`[^\n\r\u000B\u000C\u0085\u2028\u2029]`

`--verbose` or `-v`\
display generation progress messages (enabled by default)

`--quiet` or `-q`\
display error messages only (no chatter about what JFlex is currently
doing)

`--warn-<warning>`\
switch on warning type `<warning>`, where `<warning>` is one of
`unused`, `never-match`, `empty-match`, `cupsym-after-cup`, `unicode-too-long`,
`all`.

`--no-warn-<warning>`\
suppress warnings of type `<warning>`, where `<warning>` is one of
`unused`, `never-match`, `empty-match`, `cupsym-after-cup`, `unicode-too-long`,
`all`.

`--time`\
display time statistics about the code generation process (not very
accurate)

`--version`\
print version number

`--info`\
print system and JDK information (useful if you’d like to report a
problem)

`--unicodever <ver>`\
print all supported properties for Unicode version `<ver>`

`--help` or `-h`\
print a help message explaining options and usage of JFlex.

