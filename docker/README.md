# How to <hr>

1. How to connect to cqlsh if cassandra running in docker?
   - <i>docker exec -it <container_name> cqlsh</i>


2. How to check version of cassandra and cql?
   - <i>show VERSION</i>
   - <i>select * from system.local</i>


3. How to check available keyspaces?
   - <i>describe keyspaces;</i>


4. How to check available tables?
   - <i>describe tables;</i>


5. How to check table properties?
   - <i>describe table <table_name>;</i>


6. How to check available nodes in cassandra cluster?
   - <i>docker exec -it cassandra nodetool -h localhost -p 7199 status</i>