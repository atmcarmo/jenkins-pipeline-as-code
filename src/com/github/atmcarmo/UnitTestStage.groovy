package com.github.atmcarmo

import groovy.transform.InheritConstructors

@InheritConstructors
class UnitTestStage extends BaseTestStage {

    def testStage() {
        Jenkins.instance.jenkins.sh(PipelineBuildYaml.instance.unitTestsCommand)
    }

    def getStageName() {
        return "Unit Tests"
    }
}
