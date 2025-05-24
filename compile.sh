#!/bin/bash

show_help() {
  cat << EOF
Usage: $0 [OPTION]

Options:
  -h, --help        Show this help message and exit.
  -e, --execute     Compile and then execute the wordle.jar file.

Description:
  This script compiles all Kotlin source files in the src/ directory into a runnable
  jar named wordle.jar.
  If -e or --execute is provided, the compiled jar will be executed.
  If no option is given, the script will only compile the sources.
  To execute the .jar file yourself, write "java -jar wordle.jar"
EOF
}

if [[ "$1" == "-h" || "$1" == "--help" ]]; then
  show_help
  exit 0
fi

if [ -f wordle.jar ]; then
  rm wordle.jar
fi

kotlinc ./src/*.kt -include-runtime -d wordle.jar

if [[ "$1" == "-e" || "$1" == "--execute" ]]; then
  java -jar wordle.jar
fi
