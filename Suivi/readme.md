Ce fichier contient et contiendra des remarques de suivi sur votre
projet tant sur la modélisation que sur la programmation. Un nouveau
suivi est indiqué par une nouvelle section datée.

Certaines remarques demandent des actions de votre part, vous les
repérerez par une case à cocher.

- []  Action (à réaliser) 

Merci de nous indiquer que vous avez pris en compte la remarque en
cochant la case. N'hésitez pas à écrire dans ce fichier et à nous
exposer votre point de vue.

- [x] Action (réalisée)
    - RÉPONSE et éventuelles remarques de votre part, 


# Suivi du lun. 17 janv. 2022 19:29:30
Sophie Chabridon

   Bon Travail. Vous avez bien rattrapé le retard pris la première semaine !
 
- [X] Mettre à jour les fichiers AUTHORS.txt et readme.md
en indiquant vos noms et prénoms complets !

- [X] Ne pas mettre d'espace ou caractère spécial dans les noms de fichier
ou de répertoire. C'est le cas pour : 
"Diagramme de cas d'utilisation de SmartTSI.png"

- [X] Vous avez des cas d'utilisation de "suppression" qui ne sont pas demandés
pour simplifier la programmation à suivre), mais pensez à ajouter les cas
d'utilisation pour lister les différents éléments (clients, transporteurs, envois...)
 
- [X] Lorsque vous voulez tester que les informations sur le client sont bien 
formées, il faut séparer l'identifiant, le nom et le prénom,  ce qui 
implique de revoir les pré-conditions et les tables de décision.

- [X] Lorsque vous voulez tester qu'un client ou un transporteur n'existe pas 
déjà, il faut le faire sur l'identifiant, au lieu des nom et prénom, ce qui 
implique de revoir les pré-conditions et les tables de décision.

- [X] Pour le cas d'utilisation "Prendre en charge un envoi", les post-conditions 
sont incomplètes. Ceci implique de compléter également la table de décision.
	- PAS TROUVÉES

- [X] Dans les tables de décision, vous avez choisi de mettre les valeurs 0 ou 1 
à la place de F (pour faux) et T (pour vrai) respectivement. Il peut y avoir 
confusion entre ces valeurs numériques et le nombre de tests à effectuer. Il est
donc préférable de garder la notation F ou T.

- [X]  Dans les tables de décision, vous avez prévu X lorsqu'il n'y a pas 
d'influence et finalement vous ne l'utilisez pas. Cette possibilité peut donc
être retirée.




# Suivi du mar. 25 janv. 2022 23:10:51
Elisabeth Brunet

Vous n'avez pas pushé votre travail. Dommage car je ne peux pas vous faire de retour.
 
 
---
# Suivi du lun. 31 janv. 2022 19:45:14
Sophie Chabridon

 Des points à revoir dans le diagramme de classes et il reste à compléter ce qui concerne le diagramme de machine à états.

 Pour rappel, vous trouverez les explications sur les messages de suivi sur : 
  https://gitlabens.imtbs-tsp.eu/enseignants.csc4102/csc4102-exemples/-/blob/master/Suivi/messages_pour_le_suivi.md

 
Diagramme de classes

- [X] DIAGCLAS-11-Énumération-et-association

- [X] La classe ÉtatEnvoi étant une énumération, elle ne possible pas d'attributs mais un ensemble de valeurs possibles
 
- [X] Une classe "Enumeration" ne doit pas être associée aux autres classses. Elle sera simplement utilisée pour définition un type d'attribut

- [X] Le prénom du transporteur est-il indispensable ? On considère des transporteurs professionnels avec un nom correspondant à leur raison sociale.

- [] Les associations entre Envoi, Prise en Charge, Client et Transporteur sont un peu complexes et pourraient peut-être être simplifiées


Diagramme de machine à états         

- [] DIAGMACHETATS-05-Pb-syntaxe-événement-condition-action
    Les transitions doivent comporter une action et non simplement le résultat de cette action

- [x] Dans le sprint1, on ne gère pas les incidents tels que la perte d'un envoi. Néanmoins, la transition pour perte permettant de revenir dans l'état en cours de livraison ne semble pas à sa place !

- L'invariant de la classe Envoi n'est pas encore complet



 
---
# Suivi du mar. 08 févr. 2022 15:27:15
Elisabeth Brunet

   Je ne vois aucun élément d'implémentation. En espérant que vous n'ayez juste pas pushé le code, je vous engage à ne pas prendre de retard.
 

------------------------------------
lun. 21 févr. 2022 16:27:01
Denis Conan
Bon travail, les principes sont globalement compris quelques points importants à revoir.

Cette évaluation est un retour détaillé sur chaque partie de l'étude de cas.

Prenez le temps de lire tous les commentaires et d'identifier un ordre de priorité pour les prendre en compte.

----

Pour rappel, vous trouverez les explications sur les messages à l'adresse suivante :
https://gitlabens.imtbs-tsp.eu/enseignants.csc4102/csc4102-exemples/-/blob/master/Suivi/messages_pour_le_suivi.md


**IMPORTANT : avez-vous résolu votre problème avec le modèle Modelio ? Si la dernière version du modèle n'est pas fonctionnelle alors récupérez une version précédente et faites le point sur ce qui est perdu : soit vous en discutez par courriel avec Élisabeth Brunet et Sophie Chabridon avant la prochaine séance soit on en discute en séance. Ici, discuter = dire ce que vous avez « perdu » et décider ce que vous devez « refaire », en indiquant explicitement dans le document de modélisation les parties non refaites.**


# Évaluation du logiciel livré à la fin du Sprint 1

## Modélisation du logiciel

### Spécification et préparation des tests de validation

#### Diagrammes de cas d'utilisation = a-

* [x] DIAGUC-02-Compréhension-étude-de-cas : quelle est la différence entre « réceptionner un envoi » et « accepter un envoi » ?

#### Préconditions et postconditions = b+

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : 

* [X] PREPOSTCOND-07-Cohérence-entre-cas-d-utilisation : ne pas utiliser nom et prénom du client, mais identifiant du client.

Cas d'utilisation « prendre en charge un envoi » : 

* [X] PREPOSTCOND-07-Cohérence-entre-cas-d-utilisation : à la fois identifiant du transporteur et nom du transporteur ?

* [X] PREPOSTCOND-02-Compréhension-étude-de-cas : terme « disponible pour la prise en charge » ne correspond pas au vocabulaire de l'étude de cas ; en l'occurrence, l'envoi ne doit pas être déjà livré.

#### Tables de décision des tests de validation = a-

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : 

* [X] TABLEDECTV-03-Incohérence-pré-post-conditions : nom et prénom *versus* identifiant

Cas d'utilisation « prendre en charge un envoi » : 

* [X] TABLEDECTV-06-Erreur-nombre-de-tests : « envoi avec ce code existant et disponible pour la prise en charge » = 2 car existence + non livré

### Conception préliminaire

#### Diagramme de classes = b

* [] DIAGCLAS-10-Erreur-multiplicité : les multiplicités sont globalement à revoir un peu partout.

* [] DIAGCLAS-20-Association-manquante-erreur-modélisation : attribut identifiantEnvoi dans SuiviEnvoi avec l'erreur de mettre un identifiant au lieu d'une référence.

#### Diagrammes de séquence = c+

Cas d'utilisation « ajouter un client » : à faire

Cas d'utilisation « déposer un envoi » :

* [] DIAGSEQ-10-Condition-garde-fragment : « envoi avec cet identifiant inexistant » est un appel récursif pour chercher l'envoi dans la collection des envois maintenues par la façade.

* [] DIAGSEQ-18-Nom-fragment : seq à la place de opt.

Cas d'utilisation « prendre en charge un envoi » : à faire

### Conception détaillée et préparation des tests unitaires

#### Raffinement du diagramme de classes = a/b/c

* [] RAFDIAGCLAS-06-Traduction-classe-d-association-manquante : vous ne devriez plus avoir de classe d'association.

* [] RAFDIAGCLAS-10-Visibilité-attribut-dans-diagramme-de-classes : classe Envoi, visibilité par erreur paquetage

#### Diagramme de machine à états et invariant = b

* [] DIAGMACHETATS-05-Pb-syntaxe-événement-condition-action : pas d'accolade

* [] DIAGMACHETATS-07-Formulation-événement-condition : « Prise en charge... » est un événement et n'est pas encadré par des crochets.

* [] Idem pour « réception confirmée ».

* [x] DIAGMACHETATS-02-Compréhension-étude-de-cas : le cahier des charges ne parle pas de confirmation de réception ; cela ne fait pas partie de la traçabilité.

* [x] DIAGMACHETATS-07-Formulation-événement-condition : aussitôt pris en charge, l'envoi peut être détruit ; cela contredit le cahier des charges qui demande que la traçabilité soit gardée, par exemple parce que la transmission de données étaient bloquée et qu'elles sont reçues plus tard.

* [] INV-03-Invariant-à-compléter : termes sur les attributs qui traduisent les associations autour de Envoi.

#### Tables de décision de tests unitaires = a

## Programmation

### Utilisation des outils de programmation

#### Module Maven et tests avec JUnit = a

### Programmation de la solution

#### Classes du diagramme de classes avec leurs attributs = a/b/c

* [] JAVA-06-Pb-traduction-association : classe Envoi.

* [] JAVA-06-Pb-traduction-association : classe Transporteur.

#### Méthodes des cas d'utilisation de base = b-

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : à compléter.

Cas d'utilisation « prendre en charge un envoi » : à compléter

### Cohérence entre le code et le modèle

#### Cohérences du code avec le diagramme de classes = b-

#### Cohérences du code avec les diagrammes de séquence de base = c

### Programmation et exécution des tests de validation et unitaires

#### Tests de validation de 3 cas d'utilisation = b

* [] JAVATEST-08-Test-en-erreur-a-l-execution

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : 

* [X] JAVATEST-09-Test-validation-sans-accès-à-l-intérieur : pas de new Envoi, ni de new Client. Revoyez le cours.

Cas d'utilisation « prendre en charge un envoi » : 

* [X] JAVATEST-09-Test-validation-sans-accès-à-l-intérieur : pas de new Envoi, ni de new Transporteur. Revoyez le cours.

#### Tests unitaires de méthodes d'une classe = a


 
---
# Suivi du mar. 22 mars 2022 11:30:05
Sophie Chabridon

Comme vous n'avez pas demandé de suivi sur des points précis, je fais un retour global mais rapide.

Pour la suite, je vous conseille de vous concentrer sur le cas d'usage UC2 avec l'ajout des sources IoT, important pour le sprint2.

Et n'oubliez pas venir au cours demain matin avant le TP, ce sera le dernier cours avec des éléments importants pour finaliser le sprint2.

Bonne continuation.

----

Pour rappel, vous trouverez les explications sur les messages à l'adresse suivante :
https://gitlabens.imtbs-tsp.eu/enseignants.csc4102/csc4102-exemples/-/blob/master/Suivi/messages_pour_le_suivi.md

* [] ECLIPSE-01-Formatage-et-qualité-du-code
Attention notamment au nommage des méthodes. Par exemple, dans la classe SmartTSI, la méthode "listerEnvoisLivre()" ne suit pas les mêmes règles de nommage que les autres méthodes de liste...

* [] JAVA-01-Classe-manquante
 Pour tout ce qui concerne l'ajout des sources IoT et l'enregistrement des données qu'elles transmettent. 

* [x] JAVATEST-08-Test-en-erreur-a-l-execution
 Plusieurs tests sont à finaliser.


# Évaluation du logiciel livré à la fin du Sprint 2

## Modélisation du logiciel

### Spécification et préparation des tests de validation

#### Diagrammes de cas d'utilisation =  b+

#### Préconditions et postconditions =  b

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : ok-

Cas d'utilisation « prendre en charge un envoi » : ok-

#### Tables de décision des tests de validation =  b

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : ok-

Cas d'utilisation « prendre en charge un envoi » : ok-

### Conception préliminaire

#### Diagramme de classes =  c

#### Diagrammes de séquence =  c

Cas d'utilisation « ajouter un client » : ko

Cas d'utilisation « déposer un envoi » : ok-

Cas d'utilisation « prendre en charge un envoi » : ko

### Conception détaillée et préparation des tests unitaires

#### Raffinement du diagramme de classes =  b

#### Diagramme de machine à états et invariant =  b

#### Tables de décision de tests unitaires =  b+

## Programmation du logiciel

### Utilisation des outils de programmation

#### Module Maven et tests avec JUnit = b

#### Documentation Javadoc et utilisation de Checkstyle = a

#### Qualité du code en utilisant SpotBugs =  a

### Programmation de la solution

#### Classes du diagramme de classes avec leurs attributs = b

#### Méthodes des cas d'utilisation de base = b-

Cas d'utilisation « ajouter un client » : ok 

Cas d'utilisation « déposer un envoi » : ok-

Cas d'utilisation « prendre en charge un envoi » : ok-

Cas d'utilisation « Accepter la livraison d'un envoi » : ok

Cas d'utilisation « Ajouter un enregistrement de données IoT » : ko

### Cohérence entre le code et le modèle

#### Cohérences du code avec le diagramme de classes = b

#### Cohérences du code avec les diagrammes de séquence de base = c

### Programmation et exécution des tests de validation et unitaires

#### Tests de validation des cas d'utilisation = b

Cas d'utilisation « ajouter un client » : ok

Cas d'utilisation « déposer un envoi » : ok-

Cas d'utilisation « prendre en charge un envoi » : ok-

Cas d'utilisation « Accepter la livraison d'un envoi » : ok-

Cas d'utilisation « Ajouter un enregistrement de données IoT » : ko

#### Tests unitaires de méthodes d'une classe = a-

### Patron de conception et idiome

#### Application d'idiomes JAVA = a-

Idiome « equals et hashCode » : ok

Idiome « toString » : ok-

#### Application de patrons de conception = c

Patron de conception « publier-souscire »

## Complétude du logiciel livré

#### Toutes les fonctionnalités des Sprints 1 et 2 = b

#### Code complètement documenté (hors classes de test) =  b

#### Toutes les phases de construction du logiciel en intégration continue = b



----

modélisation  = min(4.0, ((2 * 0.5) + (9 * 0.25) + (4 / 10) - (1 / 10)) * 4 / 7) = 2.02
                programmation, critères majeurs = (1.60 + 2.20) * 4 / 9 = 1.68
                programmation, critères mineurs =  (0 + .1) = .1
programmation = min(4.0, max(1.68 - .1, 0)) = 1.58
complétude    = min(1.0, ((0 * 0.5) + (3 * 0.25) + (0 / 10) - (0 / 10)) * 2 / 3) = .50
projet = 2.02 + 1.58 + .50 = 4.10


