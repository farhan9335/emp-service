currentBuild.displayName = "emp-service-#"+currentBuild.number
pipeline{
  agent any
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