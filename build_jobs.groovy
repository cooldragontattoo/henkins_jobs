def jobName = 'build_henkins_jobs'

job(jobName) {
    description('Build Jenkins Jobs')
    triggers {
        hudsonStartupTrigger{
            nodeParameterName("")
            label("")
            quietPeriod("0")
            runOnChoice("False")
        }
    }
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