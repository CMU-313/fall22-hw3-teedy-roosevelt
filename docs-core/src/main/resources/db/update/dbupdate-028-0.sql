create memory table T_REVIEW ( REV_USERNAME_C varchar(36), REV_RATING_C integer, REV_REVIEWID_C varchar(36) not null, REV_USERID_C varchar(36), REV_DOCID_C varchar(36), REV_REVIEWERID_C varchar(36), REV_CREATEDATE_D date not null, REV_DELETEDATE_D date, primary key (REV_REVIEWID_C) );

insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Florentino Perez', 200, 'review1234', 'fperez', 'doc15', 'lmessi', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Leo Messi', 200, 'review1015', 'lmessi', 'doc10', 'fperez', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Leo Messi', 100, 'review107', 'lmessi', 'doc10', 'cronaldo', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Cristiano Ronaldo', 100, 'review715', 'cronaldo', 'doc7', 'fperez', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Cristiano Ronaldo', 150, 'review710', 'cronaldo', 'doc7', 'lmessi', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('John Doe', 5, 'review123', 'jdoe', 'doc5', 'fperez', NOW(), NOW());