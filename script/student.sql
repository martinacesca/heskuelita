-- SEQUENCE: public.student_seq

-- DROP SEQUENCE public.student_seq;

CREATE SEQUENCE public.student_seq;

ALTER SEQUENCE public.student_seq
    OWNER TO postgres;


-- Table: public.student2

-- DROP TABLE public.student2;

CREATE TABLE public.student2
(
    stu_id integer NOT NULL DEFAULT nextval('stu_seq'::regclass),
    stu_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    stu_last_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    stu_birthdate character varying COLLATE pg_catalog."default",
    stu_document_type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    stu_identification character varying COLLATE pg_catalog."default" NOT NULL,
    stu_phone character varying COLLATE pg_catalog."default" NOT NULL,
    stu_sex character varying COLLATE pg_catalog."default" NOT NULL,
    stu_city character varying(100) COLLATE pg_catalog."default" NOT NULL,
    stu_adress character varying(100) COLLATE pg_catalog."default" NOT NULL,
    stu_zipcode character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT student2_pkey PRIMARY KEY (stu_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.student2
    OWNER to postgres;