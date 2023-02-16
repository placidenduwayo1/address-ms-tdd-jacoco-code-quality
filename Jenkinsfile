pipeline {
  agent any
  tools {
    maven 'Maven'
    jdk 'Java17'
  }
  stages {
        stage('Build') { 
            steps {
              sh "mvn -B -DskipTests clean package"
            }
        }
        stage('Test'){
          steps{
            sh "mvn test"
          }
          post{
            always{
               junit 'target/surefire-reports/*.xml'
            }
          }
        }
    }
}
