-- SEQUENCE: public.users_seq

-- DROP SEQUENCE public.users_seq;

CREATE SEQUENCE public.users_seq;

ALTER SEQUENCE public.users_seq
    OWNER TO postgres;


-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    us_password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    us_email character varying(40) COLLATE pg_catalog."default" NOT NULL,
    us_id integer NOT NULL DEFAULT nextval('users_seq'::regclass),
    us_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (us_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;