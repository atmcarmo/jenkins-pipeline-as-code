package com.github.atmcarmo

/**
 * Singleton with utility methods for pipeline.yml file handling.
 */
@Singleton
class PipelineBuildYaml {
    /**
     *  Relative path to yml file in target repository.
     *  Please not that in this example the pipeline code and app code (including pipeline.yml) are in the same repository, but they shouldn't.
     *  This path is the path for the yml file in the app repository.
     */
    static final def pipelineFile = "app-pipeline-example/pipeline.yml"

    /** Dummy command. */
    static final def defaultCommand = "echo running dummy step"

    /** If pipeline.yml file has unit tests defined. */
    def hasUnitTests = false
    /** Command for unit tests. */
    def unitTestsCommand
    /** If pipeline.yml file has UI tests defined. */
    def hasUiTests = false
    /** Number of seleniumgrid nodes defined. */
    def uiTestsSeleniumGridNodes
    /** Command for Ui tests. */
    def uiTestsSeleniumGridCommand

    /**
     * Parses the content of pipeline.yml file based on the pipeline file path.
     * @return
     */
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
