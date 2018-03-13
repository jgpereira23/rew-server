# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table listing (
  id                            bigint auto_increment not null,
  street_name                   varchar(500) not null,
  street_number                 integer(11) not null,
  street_type                   varchar(5) not null,
  apt_number                    varchar(15) not null,
  city                          varchar(100) not null,
  state                         varchar(100) not null,
  zip_code                      varchar(11) not null,
  description                   TEXT not null,
  bedrooms                      double not null,
  bathrooms                     double not null,
  home_square_feet              integer(11) not null,
  land_square_feet              integer(11) not null,
  sale_type                     varchar(100) not null,
  year_built                    integer(11) not null,
  market_date                   varchar(255) not null,
  property_type                 varchar(100) not null,
  finished_basement             tinyint(1) default 0,
  price                         double not null,
  is_active                     tinyint(1) default 0,
  constraint pk_listing primary key (id)
);


# --- !Downs

drop table if exists listing;

