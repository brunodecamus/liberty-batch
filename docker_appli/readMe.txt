docker build -t liberty-batch .


docker run --name liberty-batch -d -p 9080:9080 liberty-batch
docker run --name liberty-batch -d -p 9080:9080 -p 9443:9443 liberty-batch
docker run --name liberty-batch -d -p 80:9080 -p 443:9443 liberty-batch



http://localhost:9000/adminCenter/
http://localhost:9000/ibm/api/
http://localhost:9000/ibm/adminCenter/explore-1.0/
http://localhost:9000/ibm/adminCenter/serverConfig-1.0/
http://localhost:9000/IBMJMXConnectorREST/
http://localhost:9000/ibm/adminCenter/javaBatch-1.0/
http://localhost:9000/liberty-batch-war/