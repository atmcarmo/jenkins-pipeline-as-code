package com.github.atmcarmo

abstract class BaseTestStage implements PipelineExecutable {
    def executeStage = true

    abstract def testStage()
    abstract def getStageName()

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
