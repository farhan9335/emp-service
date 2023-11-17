currentBuild.displayName = "emp-service-#"+currentBuild.number
pipeline{
  agent any
  environment{
   echo "Inside env block"
   DOCKER_TAG = getDockerTage()
   echo "executed env block"
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
         bat "docker build -t farhan1985/emp-service:"+${DOCKER_TAG}+ " ."
         echo "Start Docker End..."
       }
    }
  }  
}

   def getDockerTage(){
    echo "started to execute getDockerTage"
    def tag = bat script:'git rev-parse Head',returnStdout:true
    echo "Execution done getDockerTage....."
    return tag
    
 }