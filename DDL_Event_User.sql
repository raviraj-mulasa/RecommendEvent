--DROP TABLE  IF EXISTS  public.Event;
CREATE TABLE public.event
(
  event_id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  start_time VARCHAR(2048),
  city VARCHAR(2048),
  state VARCHAR(2048),
  zip VARCHAR(2048),
  country VARCHAR(2048),
  lat FLOAT,
  lng FLOAT,
  c_1 INT,
  c_2 INT,
  c_3 INT,
  c_4 INT,
  c_5 INT,
  c_6 INT,
  c_7 INT,
  c_8 INT,
  c_9 INT,
  c_10 INT,
  c_11 INT,
  c_12 INT,
  c_13 INT,
  c_14 INT,
  c_15 INT,
  c_16 INT,
  c_17 INT,
  c_18 INT,
  c_19 INT,
  c_20 INT,
  c_21 INT,
  c_22 INT,
  c_23 INT,
  c_24 INT,
  c_25 INT,
  c_26 INT,
  c_27 INT,
  c_28 INT,
  c_29 INT,
  c_30 INT,
  c_31 INT,
  c_32 INT,
  c_33 INT,
  c_34 INT,
  c_35 INT,
  c_36 INT,
  c_37 INT,
  c_38 INT,
  c_39 INT,
  c_40 INT,
  c_41 INT,
  c_42 INT,
  c_43 INT,
  c_44 INT,
  c_45 INT,
  c_46 INT,
  c_47 INT,
  c_48 INT,
  c_49 INT,
  c_50 INT,
  c_51 INT,
  c_52 INT,
  c_53 INT,
  c_54 INT,
  c_55 INT,
  c_56 INT,
  c_57 INT,
  c_58 INT,
  c_59 INT,
  c_60 INT,
  c_61 INT,
  c_62 INT,
  c_63 INT,
  c_64 INT,
  c_65 INT,
  c_66 INT,
  c_67 INT,
  c_68 INT,
  c_69 INT,
  c_70 INT,
  c_71 INT,
  c_72 INT,
  c_73 INT,
  c_74 INT,
  c_75 INT,
  c_76 INT,
  c_77 INT,
  c_78 INT,
  c_79 INT,
  c_80 INT,
  c_81 INT,
  c_82 INT,
  c_83 INT,
  c_84 INT,
  c_85 INT,
  c_86 INT,
  c_87 INT,
  c_88 INT,
  c_89 INT,
  c_90 INT,
  c_91 INT,
  c_92 INT,
  c_93 INT,
  c_94 INT,
  c_95 INT,
  c_96 INT,
  c_97 INT,
  c_98 INT,
  c_99 INT,
  c_100 INT,
  c_other INT
);
CREATE UNIQUE INDEX "Event_id_uindex" ON public.Event (event_id);
CREATE INDEX "User_Event_id_uindex" ON public.Event (user_id);

--COPY public.Event FROM '/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/events.csv' DELIMITER ',' CSV HEADER;
-- commit;

-- DROP TABLE  IF EXISTS  public.user;
CREATE TABLE public."user"
(
  user_id BIGINT PRIMARY KEY,
  locale VARCHAR(32),
  birthyear INT,
  gender VARCHAR(32),
  joinedAt VARCHAR(2048),
  location VARCHAR(2048),
  timezone INT
);
CREATE UNIQUE INDEX "User_user_id_uindex" ON public."user" (user_id);
-- COPY public."user" FROM '/Users/ravirajmulasa/Documents/Certificate_in_MachineLearning/Advanced_Machine_Learning/RecommendationEngine/data/users.csv' DELIMITER ',' NULL '' CSV HEADER;

SELECT e.* FROM
  public.event e, public."user" u
WHERE e.user_id = u.user_id;

SELECT
  event_id,
  c_1 ,
  c_2 ,
  c_3 ,
  c_4 ,
  c_5 ,
  c_6 ,
  c_7 ,
  c_8 ,
  c_9 ,
  c_10 ,
  c_11 ,
  c_12 ,
  c_13 ,
  c_14 ,
  c_15 ,
  c_16 ,
  c_17 ,
  c_18 ,
  c_19 ,
  c_20 ,
  c_21 ,
  c_22 ,
  c_23 ,
  c_24 ,
  c_25 ,
  c_26 ,
  c_27 ,
  c_28 ,
  c_29 ,
  c_30 ,
  c_31 ,
  c_32 ,
  c_33 ,
  c_34 ,
  c_35 ,
  c_36 ,
  c_37 ,
  c_38 ,
  c_39 ,
  c_40 ,
  c_41 ,
  c_42 ,
  c_43 ,
  c_44 ,
  c_45 ,
  c_46 ,
  c_47 ,
  c_48 ,
  c_49 ,
  c_50 ,
  c_51 ,
  c_52 ,
  c_53 ,
  c_54 ,
  c_55 ,
  c_56 ,
  c_57 ,
  c_58 ,
  c_59 ,
  c_60 ,
  c_61 ,
  c_62 ,
  c_63 ,
  c_64 ,
  c_65 ,
  c_66 ,
  c_67 ,
  c_68 ,
  c_69 ,
  c_70 ,
  c_71 ,
  c_72 ,
  c_73 ,
  c_74 ,
  c_75 ,
  c_76 ,
  c_77 ,
  c_78 ,
  c_79 ,
  c_80 ,
  c_81 ,
  c_82 ,
  c_83 ,
  c_84 ,
  c_85 ,
  c_86 ,
  c_87 ,
  c_88 ,
  c_89 ,
  c_90 ,
  c_91 ,
  c_92 ,
  c_93 ,
  c_94 ,
  c_95 ,
  c_96 ,
  c_97 ,
  c_98 ,
  c_99 ,
  c_100 ,
  c_other
FROM public.event;

SELECT count(e.event_id)
FROM public.Event e;


DROP TABLE  IF EXISTS  public.user_friends;
CREATE TABLE public.user_friends
(
  user_id BIGINT NOT NULL,
  friend_user_id BIGINT NOT NULL
);
CREATE INDEX user_friends_user_id_index ON public.user_friends (user_id DESC);
CREATE INDEX user_friends_user_friend_id_index ON public.user_friends (friend_user_id DESC);
-- DROP INDEX public.user_friends_user_id_friend_id_index RESTRICT;
CREATE INDEX user_friends_user_id_friend_id_index ON public.user_friends ((CAST(user_id AS TEXT)||CAST(friend_user_id AS TEXT)));

SELECT count(*) FROM public.user_friends;

SELECT count(*)
FROM public.user_friends
WHERE user_id = 1501692306;

SELECT *
FROM public.user_friends
WHERE user_id = 1501692306;


DROP TABLE  IF EXISTS public.event_attendees;
CREATE TABLE public.event_attendees
(
  event_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  yes BOOLEAN DEFAULT FALSE  NOT NULL,
  no BOOLEAN DEFAULT FALSE  NOT NULL,
  maybe BOOLEAN DEFAULT FALSE  NOT NULL,
  invited BOOLEAN DEFAULT FALSE  NOT NULL
);
CREATE INDEX event_attendees_event_id_index ON public.event_attendees (event_id);
CREATE INDEX event_attendees_user_id_index ON public.event_attendees (user_id);
CREATE INDEX event_attendees_event_id_user_id_index ON public.event_attendees (event_id, user_id);

-- TRUNCATE TABLE public.event_attendees;