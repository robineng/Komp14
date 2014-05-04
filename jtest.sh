#! /bin/sh

ant
java -cp mjc.jar mjc.JVMMain testfile.java -S
java -jar lib/jasmin.jar testclass.j
java testclass
rm testclass.class
