FROM amazon/aws-eb-glassfish:4.1-jdk8-onbuild-3.5.1

EXPOSE 8080 4848 8181

ADD glassfish-start.sh /

RUN chmod 755 /glassfish-start.sh

# for H2 Database Engine
RUN wget -P $GLASSFISH_HOME/glassfish/domains/domain1/lib http://central.maven.org/maven2/com/h2database/h2/${com.h2database.h2.version}/h2-${com.h2database.h2.version}.jar

# for MySQL
RUN wget -P $GLASSFISH_HOME/glassfish/domains/domain1/lib http://central.maven.org/maven2/mysql/mysql-connector-java/${mysql.mysql-connector-java.version}/mysql-connector-java-${mysql.mysql-connector-java.version}.jar
