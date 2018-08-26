package com.github.atmcarmo

abstract class BaseStage {
    abstract def getStageName()
    abstract protected def stage()

    def execute() {
        new NodeAgent().execute() {
            Jenkins.instance.jenkins.stage(this.getStageName()) {
                this.stage()
            }
        }
    }
}
