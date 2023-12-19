# helidon-mp-example

Helidon MP application that uses the dbclient API with MySQL database.

## Build and run


With JDK21
```bash
mvn package
java -jar target/helidon-mp-example.jar
```
Try run using ```Main.java``` 

## Exercise the application

Basic:
```
curl -X GET http://localhost:8080/simple-greet
Hello World!
```


JSON:
```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```



## Try metrics

```
# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .
```



## Try health

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...

```


### Database Setup

Start your database before running this example.

Example docker commands to start databases in temporary containers:

MySQL:
```
docker run --rm --name mysql -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=pokemon \
    -e MYSQL_USER=user \
    -e MYSQL_PASSWORD=password \
    mysql:5.7
```



## Building the Docker Image

```
docker build -t helidon-mp-example .
```

## Running the Docker Image

```
docker run --rm -p 8080:8080 helidon-mp-example:latest
```

Exercise the application as described above.
                                

## Run the application in Kubernetes

If you don’t have access to a Kubernetes cluster, you can [install one](https://helidon.io/docs/latest/#/about/kubernetes) on your desktop.

### Verify connectivity to cluster

```
kubectl cluster-info                        # Verify which cluster
kubectl get pods                            # Verify connectivity to cluster
```

### Deploy the application to Kubernetes

```
kubectl create -f app.yaml                  # Deploy application
kubectl get pods                            # Wait for quickstart pod to be RUNNING
kubectl get service  helidon-mp-example         # Get service info
```

Note the PORTs. You can now exercise the application as you did before but use the second
port number (the NodePort) instead of 8080.

After you’re done, cleanup.

```
kubectl delete -f app.yaml
```
                                
