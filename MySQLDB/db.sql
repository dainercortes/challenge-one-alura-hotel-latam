-- Crea la base de datos
CREATE DATABASE alura_hotel; 
USE alura_hotel;

-- Crea la tabla reservas
CREATE TABLE reservas(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
valor FLOAT NOT NULL,
forma_pago VARCHAR(50)
)ENGINE=InnoDB; 

-- Crea la tabla huespedes
CREATE TABLE huespedes(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
apellido varchar(50) NOT NULL,
fecha_nacimiento DATE NOT NULL,
id_nacionalidad INT NOT NULL,
telefono VARCHAR(20),
id_reserva INT NOT NULL
)ENGINE=InnoDB; 

-- Crea la tabla nacionalidad
CREATE TABLE nacionalidad(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL
)ENGINE=InnoDB;

-- Crea la tabla administradores
CREATE TABLE administradores(
 usuario VARCHAR(45) NOT NULL PRIMARY KEY,
contraseña VARCHAR(45) NOT NULL
);


-- Creacion de llaves foraneas
-- relacion entre el huesped y la reserva
ALTER TABLE huespedes 
ADD CONSTRAINT fk_id_reserva
FOREIGN KEY (id_reserva)
REFERENCES reservas(id); 

-- relacion entre el huesped y su nacionalidad
ALTER TABLE huespedes 
ADD CONSTRAINT fk_id_nacionalidad
FOREIGN KEY (id_nacionalidad)
REFERENCES nacionalidad(id); 


-- Inserta todas las nacionalidades que se usaran por defecto
INSERT INTO nacionalidad(nombre) VALUES
('afgano-afgana'), ('alemán-alemana'), ('árabe-árabe'), ('argentino-argentina'), ('australiano-australiana'), ('belga-belga'), ('boliviano-boliviana'), ('brasileño-brasileña'), ('camboyano-camboyana'), ('canadiense-canadiense'), ('chileno-chilena'), ('chino-china'), ('colombiano-colombiana'), ('coreano-coreana'), ('costarricense-costarricense'), ('cubano-cubana'), ('danés-danesa'), ('ecuatoriano-ecuatoriana'), ('egipcio-egipcia'), ('salvadoreño-salvadoreña'), ('escocés-escocesa'), ('español-española'), ('estadounidense-estadounidense'), ('estonio-estonia'), ('etiope-etiope'), ('filipino-filipina'), ('finlandés-finlandesa'), ('francés-francesa'), ('galés-galesa'), ('griego-griega'), ('guatemalteco-guatemalteca'), ('haitiano-haitiana'), ('holandés-holandesa'), ('hondureño-hondureña'), ('indonés-indonesa'), ('inglés-inglesa'), ('iraquí-iraquí'), ('iraní-iraní'), ('irlandés-irlandesa'), ('israelí-israelí'), ('italiano-italiana'), ('japonés-japonesa'), ('jordano-jordana'), ('laosiano-laosiana'), ('letón-letona'), ('letonés-letonesa'), ('malayo-malaya'), ('marroquí-marroquí'), ('mexicano-mexicana'), ('nicaragüense-nicaragüense'), ('noruego-noruega'), ('neozelandés-neozelandesa'), ('panameño-panameña'), ('paraguayo-paraguaya'), ('peruano-peruana'), ('polaco-polaca'), ('portugués-portuguesa'), ('puertorriqueño-puertorriqueño'), ('dominicano-dominicana'), ('rumano-rumana'), ('ruso-rusa'), ('sueco-sueca'), ('suizo-suiza'), ('tailandés-tailandesa'), ('taiwanes-taiwanesa'), ('turco-turca'), ('ucraniano-ucraniana'), ('uruguayo-uruguaya'), ('venezolano-venezolana'), ('vietnamita-vietnamita');
