# TP Final architecture de logiciel
Déploiement PostMan à l'aide d'un MVC composer de deux Controller

TEST DEMO
insert : 
INSERT INTO AEROPORT (ID, CODE, VILLE) VALUES (1, 'YUL', 'Montreal');
INSERT INTO AEROPORT (ID, CODE, VILLE) VALUES (2, 'CDG', 'Paris');

INSERT INTO OPERATEUR (ID, CODE, NOM) VALUES (1, 'AC', 'Air Canada');
INSERT INTO OPERATEUR (ID, CODE, NOM) VALUES (2, 'AF', 'Air France');

INSERT INTO VOL (ID, NUMERO, ORIGINE_ID, DESTINATION_ID, DUREE) VALUES (1, 'AC870', 1, 2, 420);
INSERT INTO VOL (ID, NUMERO, ORIGINE_ID, DESTINATION_ID, DUREE) VALUES (2, 'AC301', 1, 2, 90);

créer l'offre :
http://localhost:8080/api/admin/offres/create?id=1&trajetId=1&operateurId=1&depart=2025-12-20&prixBase=299.99

update :
http://localhost:8080/api/admin/offres/update/1?trajetId=1&operateurId=1&depart=2025-12-25&prixBase=350.00

lire les offres : http://localhost:8080/api/admin/offres/all

supprimer l'offre : http://localhost:8080/api/admin/offres/delete/1
