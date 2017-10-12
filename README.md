# Common Archive Service

Microservice which purpose is to manage any kind of data backup or archiving including retention policy features, high ratio compression algorithms (LZMA2, etc.) and all related.

This is first service from Common Integration Microservices set I am working on where others are:
Transport Service - deliver any kind of data from any point to any other point, so implements every possible transport protocol mainly for file transport.
Audit Service - This service can be either embedded to others or be deployed independently, depends on architecture and implements Audit pattern, so is to be reused by all other services.
Data Conversion Service - provide a generic approach to convert data formats
etc.
Scheduler Service - as name suggest this service will provide centralized
Process Management Service - in brainstorming process
Data Persistence - This service is responsible to take any file in company delivered by Transport service and load it into database to process - supporting CSV, XML, JSON (RDBMS) and RDF(Tripple store or Graph database) files
and more will come

All microservices provide its own persistence layer in form of embedded PostgreSQL server which could be easily replaced by tartger infrastructure, provide both async and sync API to work with. These microservices are serving within our company as common data integration infrastructure and support business process exectuion. All services will be integrated in SpringBoot Admin and provide Vaadin based dashboards to work with. All services could be horizontally scalled either as are, or via Docker deployment included.

[![build status](http://ip-dev01.coreso.eu/gitlab/integration-platform/commons/common-archive-service/badges/master/build.svg)](http://ip-dev01.coreso.eu/gitlab/infrastructure/networking/bankai-proxy-server/commits/master)
[![coverage report](http://ip-dev01.coreso.eu/gitlab/integration-platform/commons/common-archive-service/badges/master/coverage.svg)](http://ip-dev01.coreso.eu/gitlab/infrastructure/networking/bankai-proxy-server/commits/master)

## Features
- Compress files within source folder older than specific time interval
- Move already compressed files or compress uncompressed files in source folder and move them into archive destination folder based on specific time interval
- Source and destination folders doesn't need to be equal from time perspective hierarchy - source folder could be based on daily files while destionation folder/archive is based on monthly level
- Support multiple types of compression with defaulting to 7z (LZMA2 based compression)
- Supports global and local (archive registry record) configuration
- Enable common REST API with Swagger 2 support
- Enable asynchronous interfaces based on ActiveMQ Artemis message broker
- Provide friendly web based user interface for configuration and management  
- Embedded PostgreSQL database, but could be easily reconfigured to use company central data store
- Implement in the moment its own scheduler, but later will integrate with Bankai Scheduler Service  

## Frameworks used:
- SpringBoot - Undertow server
- Spring Data
- Spring Data Rest
- Vaadin

## Packaging

Project packaging is based Apache Maven and following packages are supported:
- Docker
Docker image based on Alpine base image (the most minimalistic Docker image in the wild - starting at 5MB size!)
- RPM
Provide RHEL/CentOS packaging for smooth installation
- JAR (executable)
SpringBoot supports just installation via Linux symlinks either within INIT or SYSTEMD based systems
- EXE (not yet supported!!!)
Provide install as Windows service, based on winsw SpringBoot daemon

## Building

TODO - provide instruction how to build project with different requirement for target platform, all types build by default
  
 

