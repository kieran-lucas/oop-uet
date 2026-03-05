#!/usr/bin/env bash

cd src || exit

javac *.java || {
    echo "Compile Error"
    exit 1
}

java Main