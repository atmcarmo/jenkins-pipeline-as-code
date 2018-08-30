# Shared library - pipeline as code

This code was used in a demo for these events:
- [DevOps Porto Meetup #16](https://www.meetup.com/pt-BR/devopsporto/events/250525943/)
- [Lisboa Quality Talks](https://www.eventbrite.com.br/e/lisboa-quality-talks-farfetch-tickets-49041793324)

## Disclaimer

This code is for demonstration purposes only, and some no-so-beatiful options were taken for the ease of demonstrating. It has not so secure options in Jenkins pipeline and Jenkins docker image. If you wish to run this in production, please review and apply the best security practices.

## Purpose

The objective of this repo is to be used in a demonstration. The idea is to have a pipeline defined as code, called a shared pipeline, that is going to be used in an application. That application has a _pipeline.yml_ file that represents the configuration of the pipeline for this application. The shared library is going to interpret this file and create a Jenkins pipeline for this application. It could create as much pipelines for as much applications as needed, that's why it's called "Shared Library"
## Content of this repository

This repo contains 3 different things:
- The Jenkins shared library written in Groovy
- The Jenkins docker image definition so that you can run a ready to go Jenkins container.
- A dummy application, containing the _pipeline.yml_ file which will be interpreted by the pipeline.

Ideally these 3 things should be in 3 separate repositories, but I've joined them into a single repo so that it's easier to demonstrate.

## Jenkins shared library

Please read Jenkins [documentation](https://jenkins.io/doc/book/pipeline/shared-libraries/) for this before starting.

Shared libraries are a way of defining a common library groovy code that is used by all pipelines in Jenkins. My idea is for this pipeline to interpret a configuration file, named _pipeline.yml_, that is present in every application repository (in this case it is in this very same repo). When the shared library interprets the yml file, it will generate the pipeline, by creating the stages, based on that file defintion.

Folders `src` and `vars` define this shared library.

The Jenkins docker image comes with the shared library preconfigured for all jobs/pipelines for Multibranch (with defaults) projects.

## Jekins docker image

This is under the `jenkins-docker` folder.

Represents a docker image named `atmcarmo/jenkins` based on the jenkins image with:
- some plugins installed
- shared library configured
- a Multibranch (with defaults) project configured

### How to start Jenkins

A Makefile was created for convenience.

`make build && make run` will both build the docker image and run the container.

You can access Jenkins on `http://localhost:8080` with username `admin` and password `password`.

### Start running the pipeline

The first time you open up Jenkins, you should go inside the project and click "Scan Multibranch with defaults now", or simply access http://localhost:8080/job/atmcarmo-pipeline/build?delay=0. This will trigger the scan of the repository for this project.

## Dummy application

This is under the `app-pipeline-example` folder.

This dummy application contains the `pipeline.yml` file with the pipeline configuration. By changing this file, you will trigger a new different configuration for your pipeline.
