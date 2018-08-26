package com.github.atmcarmo

class NodeAgent {

    def execute(body) {
        Jenkins.instance.jenkins.node("master") {
            body()
        }
    }
}
