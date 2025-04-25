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
  serviceAccountName: jenkins-sa
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
}
