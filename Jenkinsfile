currentBuild.displayName = "emp-service-#"+currentBuild.number
pipeline{
  agent any
  tools {
    // a bit ugly because there is no `@Symbol` annotation for the DockerTool
    // see the discussion about this in PR 77 and PR 52: 
    // https://github.com/jenkinsci/docker-commons-plugin/pull/77#discussion_r280910822
    // https://github.com/jenkinsci/docker-commons-plugin/pull/52
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
  }
  environment {
    DOCKER_CERT_PATH = credentials('id-for-a-docker-cred')
  }
  stages{
    stage("Checkout master branch from git"){
       steps{
         echo "checkout branch from git repository..."
       }
    }
    stage("Maven build"){
       steps{
         echo "maven build of branch..."
         bat "mvn clean install"
       }
    }
    stage("Docker Build"){
       steps{
         echo "Start Docker Build..."
         bat "docker version"
         bat "docker build -t farhan1985/emp-service:v1 ."
       }
    }
  }
  
 
}