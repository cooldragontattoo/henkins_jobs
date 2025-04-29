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
                script {
                    for (int i = 1; i <= 720; i++) {
                        echo "Sleeping... second ${i * 5} of 3600"
                        sleep time: 5, unit: 'SECONDS'
                    }
                }
            }
        }
    }
}