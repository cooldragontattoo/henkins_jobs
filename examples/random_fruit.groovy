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
        stage('Random Word') {
            steps {
                script {
                def fruit = randomFruit()
                echo "Random fruit: ${fruit}"
                }
            }
        }
    }
}