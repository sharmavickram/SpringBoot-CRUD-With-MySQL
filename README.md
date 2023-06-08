# springboot-crud-k8s
Run &amp; Deploy Spring Boot CRUD Application With MySQL on K8S
kubectl create -f mysql-deployment.yaml -n spring-k8s
persistentvolumeclaim/mysql-pv-claim created
deployment.apps/mysql created
service/mysql created

kubectl create -f mysql-secrets.yaml -n spring-k8s
secret/mysql-secrets created

kubectl get deploy -n spring-k8s
NAME               READY   UP-TO-DATE   AVAILABLE   AGE
hello-world        5/5     5            5           5d19h
mysql              1/1     1            1           6m

kubectl logs mysql-764dd667f-nxx57 -n spring-k8s

kubectl exec -it  mysql-764dd667f-nxx57 /bin/bash -n spring-k8s
kubectl exec [POD] [COMMAND] is DEPRECATED and will be removed in a future version. Use kubectl exec [POD] -- [COMMAND] instead.
bash-4.2# mysql -h mysql -u root -p
Enter password:

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| information_schema |
| sampledb              |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

docker build -t gcr.io/sprinboot-k8s/vikram-springboot-crud:v1 .
docker push gcr.io/sprinboot-k8s/vikram-springboot-crud:v1

unauthorized: You don't have the needed permissions to perform this operation, and you may have invalid credentials. To authenticate your request, follow the steps in: https://cloud.google.com/container-registry/docs/advanced-authentication
PS D:\data\SpringBoot-CRUD-With-MySQL> gcloud auth configure-docker