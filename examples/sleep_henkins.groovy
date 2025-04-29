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
                sleep 3600
            }
        }
    }
}