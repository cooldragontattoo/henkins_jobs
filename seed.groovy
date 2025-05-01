def jobName = 'seed_henkins_jobs'

job(jobName) {
    description('Loads all the Jenkins jobs as defined in the build_jobs.groovy file of the henkins_jobs repo.')
    displayName('Seed Jenkins Jobs')
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
            external('build_jobs.groovy')
            removeAction('DELETE')
        }
    }
}