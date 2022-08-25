pipeline {
    agent any
    environment{
        PORT_HOST="8081"
        PORT_CONT="8088"
        IMAGE_TAG="devops-demo"
        CONTAINER_NAME="devops"
    }

    stages{
        stage('remove previous image if exists'){
            steps{
                sh 'docker rmi -f ${IMAGE_TAG} || true'
            }
        }
        stage('build image'){
            steps{
                sh 'docker build -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('remove previous container if exists'){
            steps{
                sh 'docker stop ${CONTAINER_NAME} || true'
            }
        }
        stage('run container'){
            steps{
                sh 'docker run -d -p ${PORT_HOST}:${PORT_CONT} --rm --name ${CONTAINER_NAME} ${IMAGE_TAG}'
            }
        }
    }
}