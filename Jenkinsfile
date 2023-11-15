currentBuild.displayName = "emp-service-#"+currentBuild.number
def getDockerTage(){
    def tag = bat script:'git rev-parse Head',returnStdout:true
    return tag
  }
pipeline{
  agent any
  environment{
   DOCKER_TAG = getDockerTage()
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
         bat "docker build -t farhan1985/emp-service:${DOCKER_TAG} ."
         echo "Start Docker End..."
       }
    }
    
  }
}