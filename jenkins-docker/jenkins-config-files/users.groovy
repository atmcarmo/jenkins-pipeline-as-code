import jenkins.model.Jenkins
import hudson.*
import hudson.security.*
import jenkins.*
import com.cloudbees.plugins.credentials.*

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def adminUsername = 'admin'
def adminPassword = 'password'
hudsonRealm.createAccount(adminUsername, adminPassword)

def instance = Jenkins.getInstance()
instance.setSecurityRealm(hudsonRealm)


def strategy = new hudson.security.FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

instance.save()