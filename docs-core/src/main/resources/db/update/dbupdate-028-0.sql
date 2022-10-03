create memory table T_REVIEW ( REV_USERNAME_C varchar(36), REV_RATING_C integer, REV_REVIEWID_C varchar(36) not null, REV_USERID_C varchar(36), REV_DOCID_C varchar(36), REV_REVIEWERID_C varchar(36), REV_CREATEDATE_D date not null, REV_DELETEDATE_D date, primary key (REV_REVIEWID_C) );

insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Florentino Perez', 15, 'review1234', 'fperez', 'doc15', 'reviewerperson', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Leo Messi', 10, 'review10', 'lmessi', 'doc10', 'reviewerperson', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('Cristiano Ronaldo', 7, 'review7', 'cronaldo', 'doc7', 'reviewerperson', NOW(), NOW());
insert into T_REVIEW(REV_USERNAME_C, REV_RATING_C, REV_REVIEWID_C, REV_USERID_C, REV_DOCID_C, REV_REVIEWERID_C, REV_CREATEDATE_D, REV_DELETEDATE_D) values('John Doe', 5, 'review123', 'jdoe', 'doc5', 'reviewerperson', NOW(), NOW());