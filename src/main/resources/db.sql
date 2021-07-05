
##### Tables and schemas ############
create schema if not exists test1;
create schema if not exists test2;

create table test1.city(id bigint, name varchar(200));
create table test2.city(id bigint, name varchar(200));

CREATE SEQUENCE "test1".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
CREATE SEQUENCE "test2".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;