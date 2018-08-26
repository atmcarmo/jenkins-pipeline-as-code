package com.github.atmcarmo

class CheckoutCode extends BaseStage {

    def getStageName() {
        return "Checkout Code"
    }

    def stage() {
        def scm = Jenkins.instance.jenkins.scm
        Jenkins.instance.jenkins.checkout([
                $class                           : 'GitSCM',
                branches                         : scm.branches,
                doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                extensions                       : scm.extensions + [
                        [$class: 'CheckoutOption', timeout: 180],
                        [$class: 'CleanCheckout'],
                        [$class: 'SparseCheckoutPaths', sparseCheckoutPaths:[[$class:'SparseCheckoutPath', path:'app-pipeline-example/']]]
                ],
                userRemoteConfigs                : scm.userRemoteConfigs
        ])

        PipelineBuildYaml.parsePipelineYaml()
    }
}
