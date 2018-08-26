FROM jenkins/jenkins:lts

RUN /usr/local/bin/install-plugins.sh git workflow-aggregator pipeline-multibranch-defaults workflow-cps-global-lib discard-old-build pipeline-utility-steps
# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY jenkins-config-files/* /var/jenkins_home/init.groovy.d/

USER root
