-- begin DICTIONARIES_DICTIONARY
create table DICTIONARIES_DICTIONARY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255) not null,
    LOCALE_NAMES longvarchar,
    --
    primary key (ID)
)^
-- end DICTIONARIES_DICTIONARY
-- begin DICTIONARIES_DICTIONARY_VALUE
create table DICTIONARIES_DICTIONARY_VALUE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255) not null,
    LOCALE_NAMES longvarchar,
    DICTIONARY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DICTIONARIES_DICTIONARY_VALUE
-- begin DICTIONARIES_CUSTOMER
create table DICTIONARIES_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COUNTRY_ID varchar(36),
    TITLE varchar(255),
    --
    primary key (ID)
)^
-- end DICTIONARIES_CUSTOMER
