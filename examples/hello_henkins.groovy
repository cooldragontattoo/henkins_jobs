@Library('Henkins Shared Library') _

pipeline {
    options {
        skipDefaultCheckout()
    }
    agent {
        kubernetes{
        }
    }
    stages{
        stage('Greetings') {
            steps {
                echo 'Hello Henkins'
            }
        }
    }
    post {
        always {
            script {
                kubeMetrics() // from the Henkins Shared Library
            }
        }
    }
}