# HalloweenDuo

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spigot 1.19.4](https://img.shields.io/badge/Spigot-1.19-orange?style=for-the-badge)

Petit plugin Halloween fait pour jouer en duo entre potes, sur Spigot 1.19.

Le principe est simple : tu fais `/friend <pseudo>` pour choisir ton allié, et après c'est un battle royale. Le dernier en vie gagne, ou si il reste juste un duo qui s'est choisi mutuellement, le duo gagne.

Au début tout le monde est TP au spawn, invincible 30 secondes, et la bouffe ne descend jamais. La regen naturelle est coupée donc les pommes et les potions comptent vraiment.

Il y a 14 coffres sur la map qui se re-remplissent tout seuls pendant la partie. Dedans tu peux trouver des armes basiques, des potions splash, des pommes d'or, et quelques conneries d'Halloween : truc qui aveugle tout le monde, qui ralentit, qui met des ténèbres, ou la citrouille qui colle un casque citrouille aux autres.

Attention à la neige, ça tue direct. Et quand vous êtes plus que 3 en vie, tout le monde brille, donc plus moyen de se cacher.

Commandes :
- `/friend <joueur>` pour choisir ton duo (5 min de cooldown si tu changes)
- `/debug start` et quelques trucs de test pour les OP

Pour build : `mvn clean package`, le jar sort dans `target/` et tu le mets dans `plugins/`.
