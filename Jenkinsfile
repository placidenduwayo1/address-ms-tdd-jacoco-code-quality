pipeline {
  agent any
  tools {
    maven 'Maven'
    jdk 'JDK'
  }
  stages {
        stage('build-src-code') { 
            steps {
              sh "mvn clean install"
            }
        }
    }
}
