package com.github.atmcarmo

@Singleton
class PipelineBuildYaml {
    static final def pipelineFile = "app-pipeline-example/pipeline.yml"

    static final def defaultCommand = "echo running dummy step"

    def hasUnitTests = false
    def unitTestsCommand
    def hasUiTests = false
    def uiTestsSeleniumGridNodes
    def uiTestsSeleniumGridCommand

    static def parsePipelineYaml() {
        if (!Jenkins.instance.jenkins.fileExists(PipelineBuildYaml.pipelineFile)) {
            throw Exception("yaml file does not exist")
        }

        def file = Jenkins.instance.jenkins.readYaml(file: PipelineBuildYaml.pipelineFile)

        def unitSection = file['unit_tests']

        if (unitSection != null) {
            PipelineBuildYaml.instance.hasUnitTests = true
            PipelineBuildYaml.instance.unitTestsCommand = defaultCommand
        }

        def uiSection = file['ui_tests']
        if (uiSection != null) {
            PipelineBuildYaml.instance.hasUiTests = true
            PipelineBuildYaml.instance.uiTestsSeleniumGridNodes = uiSection.getAt("seleniumgrid_nodes")
            PipelineBuildYaml.instance.uiTestsSeleniumGridCommand = defaultCommand
        }
    }
}
