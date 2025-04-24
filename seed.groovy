folder('examples') {
    displayName('Examples')
    description('Some dummy jobs for Henkins testing')
}


pipelineJob('examples/hello_henkins') {
    displayName('Hello Henkins')
    description('A simple job that says hello.')
    defintion{
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
