package com.github.atmcarmo

import groovy.transform.InheritConstructors

@InheritConstructors
class UiTestStage extends BaseTestStage {

    def testStage() {
        Jenkins.instance.jenkins.sh(PipelineBuildYaml.instance.uiTestsSeleniumGridCommand)
        def numberOfcontainers = PipelineBuildYaml.instance.uiTestsSeleniumGridNodes


        Jenkins.instance.jenkins.sh("\$(which docker) pull elgalu/selenium")
        Jenkins.instance.jenkins.sh("\$(which docker) pull dosel/zalenium")
        Jenkins.instance.jenkins.sh("\$(which docker) run -d --rm --name zalenium -p 4444:4444 \\\n" +
                "    -v /var/run/docker.sock:/var/run/docker.sock \\\n" +
                "    -v /tmp/videos:/home/seluser/videos \\\n" +
                "    --privileged dosel/zalenium start --desiredContainers ${numberOfcontainers}")


        Jenkins.instance.jenkins.input(message: "Do a docker ps | grep zalenium | wc -l. Infrastructure created :)", submitter: "admin",)
        Jenkins.instance.jenkins.sh(PipelineBuildYaml.instance.uiTestsSeleniumGridCommand)

        Jenkins.instance.jenkins.sh("\$(which docker) run stop zalenium")

    }

    def getStageName() {
        return "Selenium Tests"
    }
}
