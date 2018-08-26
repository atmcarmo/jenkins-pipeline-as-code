import jenkins.model.Jenkins

def xmlStream = new FileInputStream("var/jenkins_home/init.groovy.d/config.xml");
Jenkins.instance.createProjectFromXML("atmcarmo-pipeline", xmlStream)
