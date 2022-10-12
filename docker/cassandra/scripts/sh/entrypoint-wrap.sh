#!/bin/bash
set -m
exec /usr/local/bin/docker-entrypoint.sh "$@" &

if [[ ! -z "$CASSANDRA_KEYSPACE" && $1 = 'cassandra' ]]; then

  # replacing keyspace placeholder in keyspace.cql script to value from env variable - $CASSANDRA_KEYSPACE
  sed -e "s/\${CASSANDRA_KEYSPACE}/$CASSANDRA_KEYSPACE/" keyspace.cql > env-keyspace.cql
  sed -e "s/\${CASSANDRA_KEYSPACE}/$CASSANDRA_KEYSPACE/" schema.cql > env-schema.cql
  sed -e "s/\${CASSANDRA_KEYSPACE}/$CASSANDRA_KEYSPACE/" data.cql > env-data.cql

  start=`date +%s`
  until cqlsh -e "select cql_version from system.local"; do
    sleep 5
  done
  end=`date +%s`
  echo ">>>> cqlsh connected: ${end-start} seconds"

  cqlsh -f env-keyspace.cql;
  cqlsh -f env-schema.cql;
  cqlsh -f env-data.cql;
fi &
fg 1;