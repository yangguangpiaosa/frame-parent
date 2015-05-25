drop tablespace mind including contents and datafiles;

CREATE TABLESPACE mind DATAFILE '%oracle_base%\oradata\data_mind.dbf' SIZE 20M REUSE AUTOEXTEND ON NEXT 5M MAXSIZE 200M;

DROP USER mind CASCADE;

CREATE USER mind IDENTIFIED BY mind;

ALTER USER mind DEFAULT TABLESPACE mind QUOTA UNLIMITED ON mind;
ALTER USER mind TEMPORARY TABLESPACE temp;
 
GRANT CONNECT,RESOURCE,DBA TO mind;

commit;