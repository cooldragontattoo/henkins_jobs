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
        stage('Sleepy Time') {
            steps {
                script {s
                    // sleep for 1 hour
                    for (int i = 1; i <= 720; i++) {
                        echo "Sleeping... second ${i * 5} of 3600"
                        sleep time: 5, unit: 'SECONDS'
                    }
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