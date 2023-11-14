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
  }
}