pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }
    stages {
        stage("init") {
            steps {
                echo 'Init...'
            }
        }
        stage("build") {
            steps {
                echo "Building version ${NEW_VERSION} ..."
            }
        }
        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'dev'
                }
            }
            steps {
                echo 'Testing...'
            }
        }
        stage("deploy") {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
