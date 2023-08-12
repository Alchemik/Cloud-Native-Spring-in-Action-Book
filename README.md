minikube start

## Kubernetes tasks

### Minikube

* Start a local Kubernetes cluster
```bash
minikube start
```

* Stop the local Kubernetes cluster
```bash
minikube stop
```
* manually import image into local cluster (by default, minikube uses the Docker Hub registry to pull images, and it doesn’t have access to your local ones. Therefore, it will not find the image you built for the Catalog Service application)
```bash
minikube image load catalog-service:0.0.1-SNAPSHOT
```

### Kubectl

#### Create Deployment for application container

```bash
kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT
```

#### Create Service for application Deployment

```bash
kubectl expose deployment catalog-service --name=catalog-service --port=8080
```

###3 Port forwarding from localhost to Kubernetes cluster

```bash
kubectl port-forward service/catalog-service 8000:8080
```

#### Delete Deployment for application container

```bash
kubectl delete deployment catalog-service
```

#### Delete Service for application container

```bash
kubectl delete service catalog-service
```
