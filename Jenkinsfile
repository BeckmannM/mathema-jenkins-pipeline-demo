pipeline {

	agent {
		label "master"
	}
	
	tools {
		maven "M3"
	}
	
	environment {
		projectDir = "com.godyo.mathema.campus.demo"
	}
	
	options {
		disableConcurrentBuilds()
		buildDiscarder(logRotator(numToKeepStr: '5'))
		timeout(time: 1, unit: 'HOURS')
		timestamps()
	}
	
	stages {
		stage("Build") {
			steps {
				sh "mvn -f ${projectDir}/pom.xml -e clean install"
			}
		}
	}
	
	post {
		always {
			step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'manuel.beckmann@godyo.com', sendToIndividuals: false])
		}
		success {
			archiveArtifacts artifacts: "${projectDir}/target/**"
		}
	}
}