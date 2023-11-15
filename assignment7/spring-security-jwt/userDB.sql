DROP DATABASE IF EXISTS userDB;
CREATE DATABASE userDB CHARACTER SET utf8 COLLATE utf8_general_ci;
use userDB;

CREATE TABLE `user` (
  `id` varchar(255)  NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` varchar(255)  NOT NULL,
  `remark` varchar(255) DEFAULT "",
  `authorities` varchar(255) DEFAULT "",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_role` (
  `user_id` varchar(255)  NOT NULL,
  `role_id` varchar(255)  NOT NULL,
 CONSTRAINT `PK` PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `FK1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `authority` (
  `role_id` varchar(255)  NOT NULL,
  `authority` varchar(255)  NOT NULL,
 CONSTRAINT `PK` PRIMARY KEY (`role_id`, `authority`),
  CONSTRAINT `FK3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user` (id,password) values ("user1","$2a$10$TP6cKCz2g26LKFF/CHMi9elunslE6HRloOsotmr0Nh2B1y6DkraAK");
insert into `user` (id,password) values ("user2","$2a$10$TP6cKCz2g26LKFF/CHMi9elunslE6HRloOsotmr0Nh2B1y6DkraAK");

insert into `role` (id,authorities) values ("admin","user/update,user/query");
insert into `role` (id,authorities) values ("guest","user/query");
insert into `user_role` (user_id,role_id) values ("user1","admin");
insert into `user_role` (user_id,role_id) values ("user2","guest");