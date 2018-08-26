package com.github.atmcarmo

/**
 * Agent to execute builds in jenkins. For this setup, and for demonstration purposes, only master node is used.
 */
class JenkinsNodeAgent {

    /**
     * Executes code in master node.
     *
     * @param body the code to execute
     */
    def execute(body) {
        Jenkins.instance.jenkins.node("master") {
            body()
        }
    }
}
