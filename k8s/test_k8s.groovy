@Library('Henkins Shared Library') _

pipeline {
    options {
        skipDefaultCheckout()
    }
    agent {
        kubernetes{
            defaultContainer 'alpine'
            yaml '''
kind: Pod
spec:
  serviceAccountName: jenkins-sa // the service account to use for this pod to access pod information 
  containers:
  - name: alpine
    image: alpine/k8s:1.29.15
    imagePullPolicy: IfNotPresent
    command:
    - cat
    tty: true
'''
        }
    }
    stages{
        stage('Get Jenkins Pods') {
            steps {
                sh 'kubectl get pods -o wide -n jenkins'
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
