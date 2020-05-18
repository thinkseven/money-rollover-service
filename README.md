# How to run the application

## run on direct host
***Notes: alias are already set***
```bash
run-svc
```
## run as docker container
***Notes: alias are already set***
```bash
run-svc-docker
```

## run below commands if no alias
```bash
export JAVA_8_HOME=$(/usr/libexec/java_home -v 1.8)
export JAVA_11_HOME=$(/usr/libexec/java_home -v 11.0)
export JAVA_13_HOME=$(/usr/libexec/java_home -v 13.0)
# set java jdk env
alias set-java8='export JAVA_HOME=$JAVA_8_HOME'
alias set-java11='export JAVA_HOME=$JAVA_11_HOME'
alias set-java13='export JAVA_HOME=$JAVA_13_HOME'

set-java13

# run directly
./mvnw clean install package &&
java -jar target/money-rollover-service*.jar

# run as docker container
docker build -t money-rollover-service/1.0.0 . &&
docker run --rm --publish 8080:8080 --name money-rollover-service money-rollover-service/1.0.0
```
