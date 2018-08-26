package com.github.atmcarmo

/**
 * Base class for test stages.
 */
abstract class BaseTestStage implements PipelineExecutable {
    def executeStage

    abstract def testStage()
    abstract def getStageName()

    BaseTestStage(executeStage) {
        this.executeStage = executeStage
    }

    def execute() {
        if (executeStage) {
            new NodeAgent().execute() {
                Jenkins.instance.jenkins.stage(this.getStageName()) {
                    this.testStage()
                }
            }
        }
    }
}
