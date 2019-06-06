multibranchPipelineJob("Graze C.Integration") {
    factory {
        workflowBranchProjectFactory {
            scriptPath('graze/jenkins-pipeline/Jenkinsfile')
        }
    }
    branchSources {
        git {
            id 'Graze'
            credentialsId("github")
            remote("https://github.com/Praqma/Malmoe-Internship.git")
        }
    }

    configure {
        def traitBlock = it / 'sources' / 'data' / 'jenkins.branch.BranchSource' / 'source' / 'traits'

        traitBlock << 'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}
    }

}