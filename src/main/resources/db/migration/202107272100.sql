DROP TABLE IF EXISTS  public.private_key;

CREATE TABLE public.private_key (
	id varchar(255) NOT NULL,
	private_key varchar(2000) NULL,
	CONSTRAINT private_key_pkey PRIMARY KEY (id)
);
