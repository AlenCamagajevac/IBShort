# IBShort

HTTP service that serves shorten URLs

## Getting started 

Easiest way to start application is to build docker image. To start, first install Maven CLI and Docker CE,
then build the image.

### Install maven

Install Maven as specified in instructions at `https://maven.apache.org/install.html`.

### Install docker

Instal Docker CE as specified in instructions at `https://docs.docker.com/install/`.

### Clone repo and build image

To clone this repository run: 
```
git clone https://github.com/AlenCamagajevac/IBShort.git && cd IBShort
```

Build docker image by running:
```
mvn package docker:build
```

### Start application 

Start the application by running docker image
```
docker run -it -p 5000:8080 ibshort
```







