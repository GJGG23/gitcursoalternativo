PGDMP         5    	            {         	   DBCursosA    15.2    15.2                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16571 	   DBCursosA    DATABASE     ~   CREATE DATABASE "DBCursosA" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "DBCursosA";
                postgres    false                       0    0    DATABASE "DBCursosA"    COMMENT     G   COMMENT ON DATABASE "DBCursosA" IS 'Data base de cursos alternativos';
                   postgres    false    3353            ?            1255    16642 -   actualizacalificacion(integer, integer, real) 	   PROCEDURE     D  CREATE PROCEDURE public.actualizacalificacion(IN pidmateria integer, IN pidusuario integer, IN pcalificacion real)
    LANGUAGE plpgsql
    AS $$
BEGIN

UPDATE public.t_calificaciones
	SET calificacion = pcalificacion, fecha_registro = CURRENT_DATE
	WHERE id_t_materias = pidmateria and id_t_usuarios = pidusuario;
END 
$$;
 r   DROP PROCEDURE public.actualizacalificacion(IN pidmateria integer, IN pidusuario integer, IN pcalificacion real);
       public          postgres    false            ?            1255    16619 '   addcalificacion(integer, integer, real) 	   PROCEDURE     Q  CREATE PROCEDURE public.addcalificacion(IN idmateria integer, IN idusuario integer, IN calificacion real)
    LANGUAGE plpgsql
    AS $$
DECLARE
	mensaje varchar;
BEGIN

INSERT INTO public.t_calificaciones(
	id_t_materias, id_t_usuarios, calificacion, fecha_registro)
	VALUES (idmateria, idusuario, calificacion, CURRENT_DATE);
END 
$$;
 i   DROP PROCEDURE public.addcalificacion(IN idmateria integer, IN idusuario integer, IN calificacion real);
       public          postgres    false            ?            1255    16643 %   eliminacalificacion(integer, integer) 	   PROCEDURE     ?   CREATE PROCEDURE public.eliminacalificacion(IN pidmateria integer, IN pidusuario integer)
    LANGUAGE plpgsql
    AS $$
BEGIN

	DELETE FROM public.t_calificaciones
	WHERE id_t_materias = pidmateria and id_t_usuarios = pidusuario;
END 
$$;
 Y   DROP PROCEDURE public.eliminacalificacion(IN pidmateria integer, IN pidusuario integer);
       public          postgres    false            ?            1255    16647 &   readcalificaciones(integer, refcursor) 	   PROCEDURE     1  CREATE PROCEDURE public.readcalificaciones(IN idusuario integer, INOUT pcursor refcursor DEFAULT 'rs_resultone'::refcursor)
    LANGUAGE plpgsql
    AS $$                                                    
 BEGIN
 OPEN pcursor FOR 
		select  c.id_t_usuarios, a.nombre, a.ap_paterno, m.nombre,
		c.calificacion, TO_CHAR (c.fecha_registro, 'mm/dd/yyyy') as fecha
		from t_calificaciones c
		inner join t_materias m on c.id_t_materias = m.id_t_materias
		inner join t_alumnos a on c.id_t_usuarios = a.id_t_usuarios
		where c.id_t_usuarios = idusuario;
 END;
 $$;
 Y   DROP PROCEDURE public.readcalificaciones(IN idusuario integer, INOUT pcursor refcursor);
       public          postgres    false            ?            1259    16573 	   t_alumnos    TABLE     ?   CREATE TABLE public.t_alumnos (
    id_t_usuarios integer NOT NULL,
    nombre character varying(80),
    ap_paterno character varying(80),
    ap_materno character varying(80),
    activo integer DEFAULT 1 NOT NULL
);
    DROP TABLE public.t_alumnos;
       public         heap    postgres    false            ?            1259    16572    t_alumnos_id_t_usuarios_seq    SEQUENCE     ?   CREATE SEQUENCE public.t_alumnos_id_t_usuarios_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.t_alumnos_id_t_usuarios_seq;
       public          postgres    false    215                       0    0    t_alumnos_id_t_usuarios_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.t_alumnos_id_t_usuarios_seq OWNED BY public.t_alumnos.id_t_usuarios;
          public          postgres    false    214            ?            1259    16621    t_calificaciones    TABLE     ?   CREATE TABLE public.t_calificaciones (
    id_t_calificaciones integer NOT NULL,
    id_t_materias integer NOT NULL,
    id_t_usuarios integer NOT NULL,
    calificacion real,
    fecha_registro date
);
 $   DROP TABLE public.t_calificaciones;
       public         heap    postgres    false            ?            1259    16620 (   t_calificaciones_id_t_calificaciones_seq    SEQUENCE     ?   CREATE SEQUENCE public.t_calificaciones_id_t_calificaciones_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.t_calificaciones_id_t_calificaciones_seq;
       public          postgres    false    219                       0    0 (   t_calificaciones_id_t_calificaciones_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public.t_calificaciones_id_t_calificaciones_seq OWNED BY public.t_calificaciones.id_t_calificaciones;
          public          postgres    false    218            ?            1259    16581 
   t_materias    TABLE     ?   CREATE TABLE public.t_materias (
    id_t_materias integer NOT NULL,
    nombre character varying(80),
    activo integer DEFAULT 1 NOT NULL
);
    DROP TABLE public.t_materias;
       public         heap    postgres    false            ?            1259    16580    t_materias_id_t_materias_seq    SEQUENCE     ?   CREATE SEQUENCE public.t_materias_id_t_materias_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.t_materias_id_t_materias_seq;
       public          postgres    false    217                       0    0    t_materias_id_t_materias_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.t_materias_id_t_materias_seq OWNED BY public.t_materias.id_t_materias;
          public          postgres    false    216            s           2604    16576    t_alumnos id_t_usuarios    DEFAULT     ?   ALTER TABLE ONLY public.t_alumnos ALTER COLUMN id_t_usuarios SET DEFAULT nextval('public.t_alumnos_id_t_usuarios_seq'::regclass);
 F   ALTER TABLE public.t_alumnos ALTER COLUMN id_t_usuarios DROP DEFAULT;
       public          postgres    false    214    215    215            w           2604    16624 $   t_calificaciones id_t_calificaciones    DEFAULT     ?   ALTER TABLE ONLY public.t_calificaciones ALTER COLUMN id_t_calificaciones SET DEFAULT nextval('public.t_calificaciones_id_t_calificaciones_seq'::regclass);
 S   ALTER TABLE public.t_calificaciones ALTER COLUMN id_t_calificaciones DROP DEFAULT;
       public          postgres    false    218    219    219            u           2604    16584    t_materias id_t_materias    DEFAULT     ?   ALTER TABLE ONLY public.t_materias ALTER COLUMN id_t_materias SET DEFAULT nextval('public.t_materias_id_t_materias_seq'::regclass);
 G   ALTER TABLE public.t_materias ALTER COLUMN id_t_materias DROP DEFAULT;
       public          postgres    false    217    216    217                      0    16573 	   t_alumnos 
   TABLE DATA           Z   COPY public.t_alumnos (id_t_usuarios, nombre, ap_paterno, ap_materno, activo) FROM stdin;
    public          postgres    false    215   q+                 0    16621    t_calificaciones 
   TABLE DATA           {   COPY public.t_calificaciones (id_t_calificaciones, id_t_materias, id_t_usuarios, calificacion, fecha_registro) FROM stdin;
    public          postgres    false    219   ?+                 0    16581 
   t_materias 
   TABLE DATA           C   COPY public.t_materias (id_t_materias, nombre, activo) FROM stdin;
    public          postgres    false    217   ,,                  0    0    t_alumnos_id_t_usuarios_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.t_alumnos_id_t_usuarios_seq', 3, true);
          public          postgres    false    214                       0    0 (   t_calificaciones_id_t_calificaciones_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.t_calificaciones_id_t_calificaciones_seq', 9, true);
          public          postgres    false    218                        0    0    t_materias_id_t_materias_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.t_materias_id_t_materias_seq', 7, true);
          public          postgres    false    216            y           2606    16579    t_alumnos t_alumnos_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.t_alumnos
    ADD CONSTRAINT t_alumnos_pkey PRIMARY KEY (id_t_usuarios);
 B   ALTER TABLE ONLY public.t_alumnos DROP CONSTRAINT t_alumnos_pkey;
       public            postgres    false    215            }           2606    16626 &   t_calificaciones t_calificaciones_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.t_calificaciones
    ADD CONSTRAINT t_calificaciones_pkey PRIMARY KEY (id_t_calificaciones);
 P   ALTER TABLE ONLY public.t_calificaciones DROP CONSTRAINT t_calificaciones_pkey;
       public            postgres    false    219            {           2606    16587    t_materias t_materias_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.t_materias
    ADD CONSTRAINT t_materias_pkey PRIMARY KEY (id_t_materias);
 D   ALTER TABLE ONLY public.t_materias DROP CONSTRAINT t_materias_pkey;
       public            postgres    false    217            ~           2606    16627 4   t_calificaciones t_calificaciones_id_t_materias_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.t_calificaciones
    ADD CONSTRAINT t_calificaciones_id_t_materias_fkey FOREIGN KEY (id_t_materias) REFERENCES public.t_materias(id_t_materias);
 ^   ALTER TABLE ONLY public.t_calificaciones DROP CONSTRAINT t_calificaciones_id_t_materias_fkey;
       public          postgres    false    3195    217    219                       2606    16632 5   t_calificaciones t_calificaciones_id_t_materias_fkey1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.t_calificaciones
    ADD CONSTRAINT t_calificaciones_id_t_materias_fkey1 FOREIGN KEY (id_t_materias) REFERENCES public.t_materias(id_t_materias);
 _   ALTER TABLE ONLY public.t_calificaciones DROP CONSTRAINT t_calificaciones_id_t_materias_fkey1;
       public          postgres    false    219    3195    217               J   x?3??????t?/?<NC.#?????ļL????D???ļĔ?b??1?_~*?{~nj?GjP?0?????? ?         Q   x?U??? ??ы??????~;ܝ??9Tt4?֍4q???0?F?:?J;?R-???\ٝ???9M?o8*>LD/??         k   x?%?A?0??+???o???d?,A\9H|?N{???H??N?????0?Ǵ???ָ:z?Ԃ*0????7?<???e????l?C????L???X?́~?B_?"?     