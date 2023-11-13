pipeline{
  agent any
  environment{
   PATH = "C:\\Program Files\\Maven\\apache-maven-3.6.2-bin\\apache-maven-3.6.2\\bin;C:\\Program Files\\Java\\jdk-17:$PATH"
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
         bat "mvn install"
       }
    }
  }
}