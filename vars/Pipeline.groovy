#!/usr/bin/groovy
import com.github.atmcarmo.CheckoutCode
import com.github.atmcarmo.Jenkins
import com.github.atmcarmo.PipelineBuildYaml

import com.github.atmcarmo.UiTestStage
import com.github.atmcarmo.UnitTestStage

def call(body){
    Jenkins.setup(this)

        new CheckoutCode().execute()

        if (PipelineBuildYaml.instance.hasUnitTests) {
            new UnitTestStage().execute()
        }

        if (PipelineBuildYaml.instance.hasUiTests) {
            new UiTestStage().execute()
        }


}
