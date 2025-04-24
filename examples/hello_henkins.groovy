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
}