package com.github.atmcarmo

@Singleton
class PipelineProperties {
    static def setProperties() {
        properties([
                [$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', daysToKeepStr: '15', numToKeepStr: '15', artifactNumToKeepStr: '15', artifactDaysToKeepStr: '15']]
        ])
    }
}
