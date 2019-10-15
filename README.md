# TP-2-ALGO-AVL

La classe « NodeAVL » représente les nœuds de l’arbre chaque nœud a pour attribut une hauteur « height » , une valeur « valueNode » et un fils Gauche et Droit « left & right » .
Un constructeur  prenant en paramètre une valeur, il va créer un nœud avec pour filsG et filsD ayant pour valeur null, la valeur rentrée en paramètre sera associé à la valeur du nœud et la hauteur sera égale à 1.
De plus des méthodes getter et setter de chaque attribut ont été implémenté afin de pouvoir récupérer les données du nœud.

La classe « TreeAVL » va représenter un arbre de nœud, il aura en attribut une racine. Cette racine étant du type « NodeAVL »  il n’aura initialement pas de filsG ou filsD et une hauteur « height »  valant 1. De plus un certain nombre de méthodes sont implémenté dans cette classe nous allons en faire le détail ci-dessous 

Méthode : 

1) « addOrDeleteNode » afin de supprimer ou ajouter un nœud à cet arbre nous avons implémenté cette fonction, à l’affichage il nous sera simplement demandé de rentrer une valeur. Cette valeur si elle n’est pas présente sera ajouté et si elle est déjà présente dans l’arbre sera supprimé. Cela est la raison pour laquelle nous avons une méthode qui va effectuer deux actions ce qui est contraire aux règles de programmation  afin d’éviter de faire cela nous l’avons divisé en deux. Dans cette méthode nous allons voir si le nœud est présent dans l’arbre avec la méthode « isExisteNode(newNode) » s’il est présent on le retire avec la méthode « removeNode » et on vérifie si c’est équilibré  avec « isBalanceTree » et l’effectue si ce n’est pas le cas. Si le nœud n’est pas présent il sera ajouté via la méthode « addNode »  et de même pour l’équilibrage.

 2) La méthode « AddNode » prend deux paramètres un nœud actuel et le nœud à ajouter, on vérifie si l’arbre est vide ou non, s’il est bien vide nous allons créer une racine. S’il n’est pas vide nous allons voir si la valeur du nœud actuel est supérieure au fils Gauche à la valeur du nouveau nœud, si c’est le cas et qu’il n’a pas de fils gauche nous lui en ajoutons un ; nous enlèverons un à la hauteur du nœud. Sinon on fait une récursion sur « AddNode » afin de parcourir l’arbre. Nous faisons pareil pour le Fils Droit

3) « removeNode »

4) « isBalanceTree »  va permettre de vérifier si l’arbre est bien  rééquilibrer après lui avoir apporté une modification que ce soit un ajout ou une suppression. Nous testons le poids de la différence du fils gauche et droit si celui-ci est inférieur à 1 alors il ne nécessite pas de rééquilibrage et retourne true  sinon il retourne false.

5) « balanceL&balanceR » 

6) « display » méthode d'affichage qui va pour cela utiliser un tas binaire, le noeud à l'index i aura son fils gauche et droit positionnés respectivement aux index i*2 et i*2+1. Le tas binaire sera de taille 2^Hauteur (et non 2^Hauteur-1 pour une simplicité lors de l'exécution des boucles). La fonction est composée de deux boucles, la première remplie le tableau de noeud et la seconde affiche les noeuds existants.

7) « isEmpty » une méthode booléen qui renvoie vrai si l’arbre est vide et faux sinon.

8) « isExistNode » permet de savoir si une valeur est présente dans l’arbre ou non pour cela la méthode prend en paramètre un nœud avec une certaine valeur. « IsExistNode » va retourner un booléen de sorte que si l’arbre est null on retourne false. Si le fils gauche ou droit de la racine a la même valeur alors cela retourne true, si la valeur du nœud rentrée en paramètre est inférieure au fils droit de la racine nous effectuons un appel récursif sur « isExistNode » avec en paramètre le fils gauche de la racine. Sinon nous faisons de même avec le fils Droit.


La classe « Main » va nous permettre d’effectuer des tests 
