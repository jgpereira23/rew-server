# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog_post (
  id                            bigint auto_increment not null,
  content                       TEXT not null,
  user_id                       bigint,
  comment_count                 bigint,
  constraint pk_blog_post primary key (id)
);

create table listing (
  id                            bigint auto_increment not null,
  street_name                   varchar(500) not null,
  street_number                 integer(11) not null,
  street_type                   varchar(2) not null,
  apt_number                    varchar(15) not null,
  city                          varchar(100) not null,
  state                         varchar(100) not null,
  zip_code                      integer(11) not null,
  description                   TEXT not null,
  bedrooms                      double(11) not null,
  bathrooms                     double(11) not null,
  home_square_feet              integer(11) not null,
  land_square_feet              integer(11) not null,
  sale_type                     varchar(100) not null,
  year_built                    integer(11) not null,
  market_date                   datetime(6)(20) not null,
  property_type                 varchar(100) not null,
  finished_basement             tinyint(1) default 0,
  price                         double(20) not null,
  is_active                     tinyint(1) default 0,
  constraint pk_listing primary key (id)
);

create table post_comment (
  id                            bigint auto_increment not null,
  blog_post_id                  bigint,
  user_id                       bigint,
  content                       TEXT,
  constraint pk_post_comment primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  email                         varchar(255) not null,
  sha_password                  varbinary(64) not null,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id)
);

alter table blog_post add constraint fk_blog_post_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_blog_post_user_id on blog_post (user_id);

alter table post_comment add constraint fk_post_comment_blog_post_id foreign key (blog_post_id) references blog_post (id) on delete restrict on update restrict;
create index ix_post_comment_blog_post_id on post_comment (blog_post_id);

alter table post_comment add constraint fk_post_comment_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_post_comment_user_id on post_comment (user_id);


# --- !Downs

alter table blog_post drop foreign key fk_blog_post_user_id;
drop index ix_blog_post_user_id on blog_post;

alter table post_comment drop foreign key fk_post_comment_blog_post_id;
drop index ix_post_comment_blog_post_id on post_comment;

alter table post_comment drop foreign key fk_post_comment_user_id;
drop index ix_post_comment_user_id on post_comment;

drop table if exists blog_post;

drop table if exists listing;

drop table if exists post_comment;

drop table if exists user;

