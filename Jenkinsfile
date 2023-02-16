pipeline {
  agent any
  tools {
    maven 'Maven'
    jdk 'Java11'
  }
  stages {
        stage('build-src-code') { 
            steps {
              sh "mvn clean install"
            }
        }
    }
}
