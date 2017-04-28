pipeline {

	// Build-Ausführung auf Master
	agent {
		label "master"
	}
	
	// Build-Parameter
	parameters {
		booleanParam(name: 'DEPLOY', defaultValue: false, description: 'Soll am Ende ausgeliefert werden?')
	}
	
	// Global Tool Konfiguration
	tools {
		maven "M3"
		jdk "Java 1.8"
	}
	
	// Definition von Umgebungsvariablen
	environment {
		projectDir = "com.godyo.mathema.campus.demo";
	}
	
	// Optionen
	options {
		// Nicht mehrere Builds des Projektes parallel laufen lassen
		disableConcurrentBuilds()
		// Aufheben der letzten 5 Builds
		buildDiscarder(logRotator(numToKeepStr: '5'))
		// Timeout nach einer Stunde
		timeout(time: 1, unit: 'HOURS')
	}
	
	// Stages-Sektion
	stages {
		stage("Build") {
			steps {
				// Maven-Aufruf ohne Tests
				sh "mvn -f ${projectDir}/pom.xml -e clean install -DskipTests"
				sh "cp -r ${projectDir}/target/jfx/native/mathemaDemo output/"
			}
		}
		stage("Test") {
			steps {
				// Nur Maven Junit-Tests ausfuehren
				sh "mvn -f ${projectDir}/pom.xml test"
				// Aufzeichnung der Test-Resultate
				junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'
			}
		}
		stage("Deploy") {
			when {
				// Nur Ausfuehren, wenn Parameter gesetzt und der Build bisher erfolgreich war
				expression {params.DEPLOY && currentBuild.result.equals("SUCCESS")}
			}
			steps {
				sh "cp -r 'output/**' 'C:/Users/Manuel/Desktop/MathemaCampus2017/Deployment'"
			}
		}
	}
	
	// Post-Build-Sektion
	post {
		success {
			archiveArtifacts artifacts: "output/**"
		}
	}
}
