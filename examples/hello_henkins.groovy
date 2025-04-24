pipeline {
    options {
        skipDefaultCheckout()
    }
    agent {
<<<<<<< HEAD
        kubernetes {           
        }
=======
        kubernetes {
            yaml '''
kind: Pod
metadata:
  name: testing
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
//         kubernetes {
//             defaultContainer: 'testing'
//             yaml '''
// kind: Pod
// spec: 
//   containers:
//   - name: testing
//     image: python:3.8
//     imagePullPolicy: Always
//     command:
//     - cat
//     tty: true
// '''    
//         }
>>>>>>> 30d10308ca57999a84101def9809199621d57377
    }
    stages{
        stage('Greetings') {
            steps {
                echo 'Hello Henkins'
            }
        }
    }
}