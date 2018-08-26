import jenkins.model.Jenkins;

// gets the groovy config provider
def groovyConfigProvider = org.jenkinsci.lib.configprovider.ConfigProvider.all().find { it.getProviderId() == "org.jenkinsci.plugins.configfiles.groovy.GroovyScript" }

// creates a new config (new managed file)
def config = groovyConfigProvider.newConfig("Jenkinsfile", "Jenkinsfile", "Shared Pipeline", "Pipeline { }")
groovyConfigProvider.save(config)