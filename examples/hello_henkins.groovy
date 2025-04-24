pipeline {
    options {
        skipDefaultCheckout()
    }
    agent {
        kubernetes {
            defaultContainer: 'testing'
            yaml '''
kind: Pod
spec: 
  containers:
  - name: testing
    image: python:3.8
    imagePullPolicy: Always
    command:
    - cat
    tty: true
'''    
        }
    }
    stages{
        stage('Greetings') {
            steps {
                echo 'Hello Henkins'
            }
        }
    }
}