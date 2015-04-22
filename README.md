Gymnaster
====

This is a sample web application deploying to AWS Elastic Beanstalk.
It helps you to publish web services written in Java EE :)
AWS Elastic Beanstalk supports GlassFish 4.1 on Docker, so you can easily customizing Application Server environment by adding `Dockerfile` in war archive and deploying by beanstalk-maven-plugin.

This sample web application is implemented by Java 8 and Java EE 7. And tested on Java SE Development Kit 8, Update 31 and GlassFish 4.1.

## Requirement

* AWS Account (This sample uses Elastic Beanstalk and RDS)
* Java SE Development Kit 8
* Maven 3

## Usage

### Prepare Elastic Beanstalk application

Launch Elastic Beanstalk Application setting following configuration.

* Application Name: gymnaster
* Environment: Web Server Environment
* Predefined configuration: GlassFish (Preconfigured - Docker)
* Additional Resources: Create an RDS DB Instance with this environment

It takes 10-15 min to launch.

### Prepare AWS ACCESS KEY and AWS SECRET KEY

* Create IAM user (recommended) who has policy "AWSElasticBeanstalkFullAccess"
* Use admin user

And generate access keys.

### Build and deploy to Elastic Beanstalk

    AWS_ACCESS_KEY=[YOUR AWS ACCESS KEY]
    AWS_SECRET_KEY=[YOUR AWS SECRET KEY]
    mvn clean package beanstalk:upload-source-bundle beanstalk:create-application-version beanstalk:update-environment

### Access to Application

Enter url `http://[YOUR SUB-DOMAIN NAME].elasticbeanstalk.com/` to Web Browser, so you can see Awesome Web Service pre-registration form :)

## Licence

[MIT](https://github.com/nagaseyasuhito/gymnaster/blob/master/LICENSE)

## Author

[nagaseyasuhito](https://github.com/nagaseyasuhito)

## See also

[beanstalk-maven-plugin](http://beanstalker.ingenieux.com.br/beanstalk-maven-plugin/)