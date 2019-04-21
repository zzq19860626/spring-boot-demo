#!/usr/bin/env bash
mvn -Dmybatis.generator.overwrite=true -Dmybatis.generator.contexts=demo mybatis-generator:generate
