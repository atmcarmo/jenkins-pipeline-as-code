package com.github.atmcarmo

class DockerAgent {
    def jenkins

    DockerAgent(jenkins) {
        this.jenkins = jenkins
    }

    def execute(body) {
        this.jenkins.dockerNode(image: "jenkins/jnlp-slave") {
            body()
        }
    }
}
