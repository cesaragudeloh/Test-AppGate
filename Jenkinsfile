pipeline {
    agent any

    stages {
		stage('Delete Workspace') {
				steps {
					echo 'Deleting workspace'
					cleanWs()
				}
		}

        stage('Get Project') {
            steps {
                echo 'Clonning repository'
                git branch: 'trunk', url: 'https://github.com/cesaragudeloh/TestAppGate.git'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'gradlew.bat clean test aggregate --info' //run a gradle task on Windows
            }
        }

         stage('Publish Report') {
            steps {
                echo 'Publishing Serenity BDD Report'
                archiveArtifacts artifacts: '**/serenity/**', followSymlinks: false
            }
        }

         stage('Send Notification') {
            steps {
                echo 'Sending Email Notification'
                mail bcc: '', body: 'A functional test has been execute on a Jenkins pipeline. For more information login on Jenkins.', cc: '', from: '', replyTo: '', subject: 'Functional Test Execute on Jenkins', to: 'cesar.agudelo.h@gmail.com'
            }
        }
    }

}