package com.github.atmcarmo

/**
 * Base class for all stages.
 */
abstract class BaseStage {

    /** Gets the name of the stage. */
    abstract protected def getStageName()

    /** The stage code definition. */
    abstract protected def stage()

    /**
     * Executes code defined for this stage.
     */
    def execute() {
        new JenkinsNodeAgent().execute() {
            Jenkins.instance.jenkins.stage(this.getStageName()) {
                this.stage()
            }
        }
    }
}
