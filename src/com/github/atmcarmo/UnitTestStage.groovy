package com.github.atmcarmo

import groovy.transform.InheritConstructors

@InheritConstructors
class UnitTestStage extends BaseStage {

    def stage() {
        Jenkins.instance.jenkins.sh(PipelineBuildYaml.instance.unitTestsCommand)
    }

    def getStageName() {
        return "Unit Tests"
    }
}
