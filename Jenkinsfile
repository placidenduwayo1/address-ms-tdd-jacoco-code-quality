pipeline {
  agent any
  tools {
    maven 'Maven'
    jdk 'Java17'
  }
  stages {
        stage('build-src-code') { 
            steps {
              sh "mvn -B -DskipTests clean package"
            }
        }
    }
}
