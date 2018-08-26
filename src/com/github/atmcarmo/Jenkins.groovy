package com.github.atmcarmo

@Singleton
class Jenkins {
    def jenkins

    static def setup(jenkins) {
        Jenkins.instance.jenkins = jenkins
    }
}
