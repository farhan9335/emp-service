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
         echo "maven build of branch..."
         bat "mvn clean install"
       }
    }
    stage("Docker Build"){
       steps{
         echo "Start Docker Build..."
         echo "Docker Tag is --------> ${DOCKER_TAG}"
         bat "docker build -t farhan1985/emp-service:v5 ."
         echo "Start Docker End..."
       }
    }
  }  
}

   def getDockerTage(){
    echo "started to execute getDockerTage"
    def tag = bat(returnStdout: true, script: 'git rev-parse HEAD').trim()
    echo "Execution done getDockerTage.....${tag}"
    return tag
    
 }