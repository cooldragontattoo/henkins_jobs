def jobName = 'build_henkins_jobs'

job (jobName) {
    description('Build Henkins Jobs')
    scm {
        git {
            remote {
                url('https://github.com/cooldragontattoo/henkins_jobs.git')
            }
            branch('*/main')
        }
    }
    steps {
        dsl {
            external('seed.groovy')
            removeAction('DELETE')
        }
    }
}