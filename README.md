Postgresql and Mysql drivers and datasources packaged as Galleon feature-pack
==============================================================================

NB: You must ensure that the WildFly configuration that you are composing with the following 
layers contains the dependencies needed by the layers to properly operate. As an example, the `jpa` or `cloud-profile` WildFly layers 
contain all the needed dependencies.

You can check this [Galleon maven project](https://github.com/wildfly/wildfly-s2i/wildfly-modules/jboss/container/wildfly/galleon/artifacts/opt/jboss/container/wildfly/galleon/definitions/cloud-profile-postgresql) 
that makes use of the `postgresql-datasource` layer with the WildFly `cloud-profile` to provision a custom WildFly server.

`postgresql-driver` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/postgresql-driver/layer-spec.xml) installs postgresql driver (for current version check in [pom.xml](pom.xml)) as JBOSS modules inside a WildFly server.
The driver is named `postgresql`.

`mysql-driver` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/mysql-driver/layer-spec.xml) install mysql driver (for current version check in [pom.xml](pom.xml)) as JBOSS modules inside a WildFly server.
The driver is named `mysql`.

`postgresql-datasource` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/postgresql-datasource/layer-spec.xml) creates a postgresql datasource.
The datasource is named `PostgreSQLDS`. JDBC URL can be configured at server execution time with the following env Variables:

* `POSTGRESQL_DATABASE`
* `POSTGRESQL_SERVICE_PORT`
* `POSTGRESQL_SERVICE_HOST`
* `POSTGRESQL_PASSWORD`
* `POSTGRESQL_USER`

The JNDI name of the datasource is: `java:jboss/datasources/${env.MYSQL_DATASOURCE:MySQLDS}`

`postgresql-default-datasource` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/postgresql-default-datasource/layer-spec.xml) sets the postgresql datasource as the 
ee subsystem default datasource.

`mysql-datasource` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/mysql-datasource/layer-spec.xml) creates a mysql datasource.
The datasource is named `MySQLDS`. JDBC URL can be configured at server execution time with the following env Variables:

* `MYSQL_DATABASE`
* `MYSQL_SERVICE_PORT`
* `MYSQL_SERVICE_HOST`
* `MYSQL_PASSWORD`
* `MYSQL_USER`

The JNDI name of the datasource is: `java:jboss/datasources/${env.POSTGRESQL_DATASOURCE:PostgreSQLDS}`

`mysql-default-datasource` layer
---------------------------------
This [layer](src/main/resources/layers/standalone/mysql-default-datasource/layer-spec.xml) sets the mysql datasource as the 
ee subsystem default datasource.