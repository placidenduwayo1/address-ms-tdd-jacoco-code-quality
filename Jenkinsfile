pipeline {
  agent any
  tools {
    maven 'MAVEN'
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
