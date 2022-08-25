pipeline {
    agent any
    environment{
        PORT_HOST="8081"
        PORT_CONT="8088"
        IMAGE_TAG="devops-demo"
        CONTAINER_NAME="devops"
        DB_URL=credentials('DB_URL')
        DB_USER=credentials('DB_USER')
        DB_PASS=credentials('DB_PASS')
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
                sh 'docker run -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -d -p ${PORT_HOST}:${PORT_CONT} --name ${CONTAINER_NAME} ${IMAGE_TAG}'
            }
        }
    }
}