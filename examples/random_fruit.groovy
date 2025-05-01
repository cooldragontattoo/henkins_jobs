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
        stage('Random Fruit') {
            steps {
                script {
                def fruit = randomFruit() // from the Henkins Shared Library
                echo "Random fruit: ${fruit}"
                }
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