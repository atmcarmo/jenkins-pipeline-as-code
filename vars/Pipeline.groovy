#!/usr/bin/groovy
import com.github.atmcarmo.CheckoutCode
import com.github.atmcarmo.Jenkins
import com.github.atmcarmo.NodeAgent
import com.github.atmcarmo.PipelineBuildYaml
import com.github.atmcarmo.PipelineProperties
import com.github.atmcarmo.UiTestStage
import com.github.atmcarmo.UnitTestStage

def call(body){
    //PipelineProperties.setProperties()

    Jenkins.setup(this)

    NodeAgent agent = new NodeAgent();
    agent.execute({
        new CheckoutCode().execute()

        if (PipelineBuildYaml.instance.hasUnitTests) {
            new UnitTestStage().execute()
        }

        if (PipelineBuildYaml.instance.hasUiTests) {
            new UiTestStage().execute()
        }
    })


}
