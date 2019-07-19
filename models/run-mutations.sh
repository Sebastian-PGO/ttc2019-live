#!/bin/bash

pushd random10
java -jar ../mutator.jar ../random10.docbook random10-single 50 1 42
java -jar ../mutator.jar ../random10.docbook random10-double 50 2 68
java -jar ../mutator.jar ../random10.docbook random10-triple 50 3 73
popd

pushd random100
java -jar ../mutator.jar ../random100.docbook random100-single 50 1 42
java -jar ../mutator.jar ../random100.docbook random100-double 50 2 68
java -jar ../mutator.jar ../random100.docbook random100-triple 50 3 73
popd

pushd random1000
java -jar ../mutator.jar ../random1000.docbook random1000-single 50 1 42
java -jar ../mutator.jar ../random1000.docbook random1000-double 50 2 68
java -jar ../mutator.jar ../random1000.docbook random1000-triple 50 3 73
popd
