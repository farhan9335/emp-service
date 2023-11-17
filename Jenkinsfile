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
         bat "docker build -t farhan1985/emp-service:v4 ."
         echo "Start Docker End..."
       }
    }
  }  
}

   def getDockerTage(){
    echo "started to execute getDockerTage"
    script{
       def tag = bat(returnStdout:true,script:'git rev-parse Head') 
    }
    echo "Execution done getDockerTage.....${tag}"
    return tag
    
 }