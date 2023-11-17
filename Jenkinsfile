currentBuild.displayName = "emp-service-#"+currentBuild.number
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
         bat "mvn clean install"
       }
    }
    stage("Docker Build"){
       steps{
         bat "docker build -t farhan1985/emp-service:${DOCKER_TAG} ."
       }
    }
  }  
}

   def getDockerTage(){
    def tag = bat(returnStdout: true, script:"@git rev-parse HEAD").trim()
    return tag
 }