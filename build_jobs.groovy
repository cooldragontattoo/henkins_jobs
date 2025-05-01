//!groovy

// folders for jobs
folder('examples') {
    displayName('Examples')
    description('Some dummy jobs for Henkins testing')
}

folder('k8s') {
    displayName('K8s Jobs')
    description('Some dummy jobs for Henkins testing with K8s')
}

// job: Hello Henkins
pipelineJob('examples/hello_henkins') {
    displayName('Hello Henkins')
    description('A simple job that says hello.')
    definition{
        cpsScm {
            scm{
                git {
                    remote {
                        url('https://github.com/cooldragontattoo/henkins_jobs.git')
                    }
                    branch('*/main')
                }
                lightweight()
                scriptPath('examples/hello_henkins.groovy')
                }
        }
    }
}

// job: Random Fruit
pipelineJob('examples/random_fruit') {
    displayName('Random Fruit')
    description('A simple job that generates a random fruit.')
    definition{
        cpsScm {
            scm{
                git {
                    remote {
                        url('https://github.com/cooldragontattoo/henkins_jobs.git')
                    }
                    branch('*/main')
                }
                lightweight()
                scriptPath('examples/random_fruit.groovy')
                }
        }
    }
}

// job: Sleepy Time 
pipelineJob('examples/sleep_henkins') {
    displayName('Sleepy Time')
    description('A simple job that sleeps for an hour.')
    definition{
        cpsScm {
            scm{
                git {
                    remote {
                        url('https://github.com/cooldragontattoo/henkins_jobs.git')
                    }
                    branch('*/main')
                }
                lightweight()
                scriptPath('examples/sleep_henkins.groovy')
                }
        }
    }
}

// job: Test K8s
pipelineJob('k8s/test_k8s') {
    displayName('Test K8s')
    description('A simple job that gets the pods for the jenkins namespace  .')
    definition{
        cpsScm {
            scm{
                git {
                    remote {
                        url('https://github.com/cooldragontattoo/henkins_jobs.git')
                    }
                    branch('*/main')
                }
                lightweight()
                scriptPath('k8s/test_k8s.groovy')
                }
        }
    }
}
