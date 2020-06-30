DROP TABLE IF EXISTS game;
CREATE TABLE public."game" (
	id SERIAL NOT NULL,
	"name" varchar NULL,
	"cost" decimal NULL,
	"category" varchar NULL,
	CONSTRAINT game_pk PRIMARY KEY (id)
); 
 INSERT INTO game(name,cost,category) values('GodOFWars',80,'Rol');
 INSERT INTO game(name,cost,category) values('FIFA20',78,'Sports');