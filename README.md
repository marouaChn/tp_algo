# tp_algo
1 - le but de cet algorithme est d'imprimer toutes les subsets égales à s dans le vecteur e , donc ici nous allons utiliser une approche dynamique nous allons remplir la première colonne du tableau avec vraie car tous les sous-ensembles peuvent vérifier s=0 aprés ça nous allons remplir le tableau en utilisant ces équations : somme[i ][j] = (e[i] <= j) ? (somme[i-1][j] || somme[i-1][j-e[i]]) : somme[i - 1][j];

si la cellule de la dernière ligne et de la dernière colonne est fausse alors il n'y a pas de sous-ensemble sinon nous imprimerons la somme dans le chemin ascendant

2 - l'equation de récursive : somme[i ][j] = (e[i] <= j) ? (somme[i-1][j] ||somme[i-1][j-e[i]]): somme[i - 1][j];

3 - Domaines d'application : computer passwords: il existe un programme pour convertir un mot de passe normal de séquence de symboles en un tel sous-ensemble.) Au lieu d'avoir le mot de passe pour l'utilisateur, l'ordinateur conserve le total associé au sous-ensemble approprié. Lorsque l'utilisateur saisit le sous-ensemble, l'ordinateur teste si le total est correct. Il ne conserve pas d'enregistrement du sous-ensemble. Ainsi, l'emprunt d'identité n'est possible que si quelqu'un peut reconstruire le sous-ensemble.
