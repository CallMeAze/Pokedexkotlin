# Project_4A_AM

## Présentation

Ce projet Pokedex est un projet de quatrième année d'école d'ingénieur. Cette application affiche des créatures issues de l'univers pokémon.

# Consignes respectées : 

- Appels à une **API REST** 
- Architecture **MVVM**
- Utilisation de **Retrofit 2**
- **Fonctions supplémentaires** :
  - Utilisation de **Glide**
  - Utlisation de **RxJava**
  - Utilisation de **Singleton**
  - Barre de recherche
  - Filtrage de la liste en fonction du type


# Fonctionnalités: 

## Ecran Home 

- Affiche la liste des pokémons avec une barre de recherche en haut de la page.

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/list_pokemon.PNG" width="250"/>   <img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/list_pokemon2.PNG" width="250"/>

## Ecran du détail du pokémon

Lorsque l'on clique sur un Pokemon une fenêtre donnant les détails de celui-ci s'affiche.
Sur cette fenêtre vous retrouverez : 

- L'affichage des différentes informations du pokémon cliqué
- Type, faiblesses, évolution précédente et prochaine évolution (Items à interactions) 
- Redirection en fonction de l'item cliqué :
	- Type, faiblesses : Affichage des Pokemons du type cliqué 
	- Evolution : Ouverture de l'écran détail du Pokemon cliqué

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/pokemon_detail_caterpie.PNG" width="250"/>

En cliquant sur metapod : 

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/pokemon_detail_metapod.PNG" width="250"/>

En cliquant sur Butterfree : 

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/pokemon_detail_butterfree.PNG" width="250"/>

## Filtres 

Affichage obtenu lorsque l'on clique sur le type ou les weaknesses de caterpie : 

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/pokemon_type_bug.PNG" width="250"/> <img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/pokemon_type_fire.PNG" width="250"/>

## Barre de Recherche

Lorsque vous cliquez sur la barre de recherche, il vous est possible de chercher un Pokemon spécifique ou bien contenant certaines lettres : 

<img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/search_bar.PNG" width="250"/> <img src ="https://github.com/CallMeAze/Project_4A_AM/blob/master/Img_github/search_bar2.PNG" width="250"/>
