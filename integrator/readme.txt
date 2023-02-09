Retours sur le projet :

La plus grande majorité des problèmes rencontrés était liée à Mirth Connect. Nous ne maitrisions pas cet outil avant de commencer les cours et son utilisation demeure très complexe.
Nous avons néanmoins réussi à lancer une instance de mirth dans Docker créant en même temps la base de données.
Nous avons ensuite lancé le script joint permettant de mettre en place la configuration des channels.

En parallèle, nous avons créé différentes api comme demandé afin de créer, récupérer, modifier des patients et des séjours.
Pour cela, nous avons utilisé SpringBoot qui permet de créer une api REST. Un avantage de Spring est qu'il va créer les tables relatives aux objets déclarés (entités) si elles n'existent pas.
Dans le cas contraire, Spring va automatiquement faire le lien entre la table et les objets.
Nous avons donc créé deux objets : Sejour et Patient. Ces objets reprennent les caractéristiques demandées.
De plus, pour la génération des fichiers hl7, nous avons repris la bibliothèque suggérée dans le sujet, dans laquelle se trouvait également un objet Patient.
De ce fait, nous avons créé un mapper permettant de passer de notre objet Patient à celui de la librairie et vice-versa.

En ce qui concerne les travaux, ils ne sont tous pas terminés car nous avons passé une partie bien trop importante à la mise en place de mirth connect.
Malheureusement, cette partie n'est pas complétement fonctionnelle, mais nous étions proche du but. Nous savons bien générer un fichier hl7 en contactant l'api (via Postman).
Or, nous n'avons pas trouvé où et comment déposer ce fichier. Nous avons tenté de le faire manuellement dans le dossier mirth/hl7, mais le fichier n'a jamais été lu et son contenu ajouté en base.

Pour la partie Zuul, il semblerait que l'outil ne soit plus complétement supporté par Spring. Nous n'avons pas su l'ajouter dans les dépendances via spring.start ni après avec Maven.

En ce qui concerne la GUI, nous l'avons dockerisée mais elle n'est pas terminée ni liée aux api (nous attendions de finir zuul).

Les sujet sur les logs et git n'ont pas été abordés non plus, faute de temps.

Pour les apis, les routes essentielles sont créées. Binsûr, sur un projet d'entreprise nous aurions ajouté d'autres routes afin de les rendre plus fonctionnelles.

En revanche, nous avons pu prendre en main Docker afin de virtualiser différents services, afin de les faire cohabiter. Par exemple, nos apis virtualisées indépendemment arrivent bien à
contacter la bdd qui se trouve dans une autre virtualisation. Le sujet était très intéressant même si la partie mirth connect nous a mis grandement en difficulté alors que l'essence du tp ne reposait pas dessus, nous n'avons pas géré correctement la gestion du projet.


Pour lancer mirth, il suffit de suivre vos instructions
Pour lancer nos apis, nous avons créé des docker file. Il faut donc les build "docker build -t WSxx ." puis "docker run -p 808x:808x WSxx"
Il faur remplacer les x par le bon port et xx par le nom du webservice.
Pour 	WSQuery : 8081
		WSInsert : 8082
		WSHL7 : 8083
		
Pour lancer le GUI, nous utilisons une image existante de Docker dans laquelle nous précisons un volume comportant nos fichiers : "docker run -v xx:/var/www/html -p 9080:80 php:7.4-apache"
(remplacer xx par le chemin relatif vers le dossier du gui)
