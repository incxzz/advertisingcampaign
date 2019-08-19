drop table if exists campaign_ads;
drop table if exists ads_platforms;
drop table if exists campaigns;
drop table if exists advertisements;
drop table if exists platforms;
drop table if exists statuses;


create table platforms(id integer primary key,
                       name varchar(255) not null
                      );

create table statuses(id integer primary key,
                      name varchar(255) not null
                     );

create table campaigns(id identity primary key auto_increment,
                       name varchar(255) not null,
                       status integer,
                       start_date timestamp,
                       end_date  timestamp,
                       constraint fk_camp_status_id foreign key(status) references statuses(id)
                      );

create table advertisements(id identity primary key auto_increment,
                            name varchar(255) not null,
                            status integer,
                            assetUrl varchar(255),
                            constraint fk_ads_status_id foreign key(status) references statuses(id)
                           );

create table ads_platforms(ads integer not null,
                           platform integer not null,
                           constraint fk_ads_platf_ads_id foreign key(ads) references advertisements(id),
                           constraint fk_ads_platf_platf_id foreign key(platform) references platforms(id)
                          );

create table campaign_ads(campaign integer not null,
                          ads integer not null,
                          constraint fk_camp_ads_camp_id foreign key(campaign) references campaigns(id),
                          constraint fk_camp_ads_ads_id foreign key(ads) references advertisements(id)
                         );
