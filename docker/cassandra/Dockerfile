FROM cassandra:latest

COPY scripts/cql/keyspace.cql /keyspace.cql
COPY scripts/cql/schema.cql /schema.cql
COPY scripts/cql/data.cql /data.cql

COPY scripts/sh/entrypoint-wrap.sh /entrypoint-wrap.sh

ENTRYPOINT ["/entrypoint-wrap.sh"]
CMD ["cassandra", "-f"]