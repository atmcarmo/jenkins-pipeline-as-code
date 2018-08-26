package com.github.atmcarmo

/**
 * Wrapper for Jenkins instance.
 */
@Singleton
class Jenkins {
    def jenkins

    static def setup(jenkins) {
        Jenkins.instance.jenkins = jenkins
    }
}
