def jobName = 'build_henkins_jobs'

job(jobName) {
    scm {
        git {
            remote {
                url 'https://github.com/cooldragontattoo/henkins_jobs.git'
                branch 'main'
            }
        }
    }
    steps {
        dsl {
            external('seed.groovy')
            removeAction('DELETE')
        }
    }
}