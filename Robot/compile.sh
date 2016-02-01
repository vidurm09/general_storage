#!/bin/bash
#Vidur Maheshwari
javac $1
dotJava=".java";
class=${1%$dotJava};
java "${class}";
rm -- *.class;