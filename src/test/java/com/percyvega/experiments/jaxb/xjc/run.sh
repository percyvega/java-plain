#!/usr/bin/env bash

cd /c/PERCYVEGA/Workspaces/GitHubProjects/java-plain
xjc -d src/main/java -p com.percyvega.experiments.jaxb.xjc.generated src/main/java/com/percyvega/experiments/jaxb/xjc/book.xsd
