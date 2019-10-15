# TP-2-ALGO-AVL

La classe « NodeAVL » représente les nœuds de l’arbre chaque nœud a pour attribut une hauteur « height » , une valeur « valueNode » et un fils Gauche et Droit « letf & rifht » .
Un constructeur  prenant en paramètre une valeur, il va créer un nœud avec pour filsG et filsD ayant pour valeur null, la valeur rentré en paramètre sera associé à la valeur du nœud et la hauteur sera égale à 1.
De plus des méthodes getter et setter de chaque attribut ont été implémenté afin de pouvoir récupérer les données du nœud.


La classe « TreeAVL » va représenter un arbre de nœud, il aura en attribut une taille mais également une racine. Cette racine étant de type « NodeAVL »  il aura initialement pas de filsG ou filsD et une hauteur « height »  valant 1.

Méthode : 
1) « addOrDeleteNode » afin de supprimer ou ajouté un nœud à cet arbre nous avons implémenté cette fonction, à l’affichage il nous sera simplement demandé de rentrer une valeur. Cette valeur si elle n’est pas présente sera ajouté et si elle est déjà présente dans l’arbre sera supprimé. Cela est la raison pour laquelle nous avons une méthode qui va effectuer deux actions ce qui est contraire aux règles de programmation  afin d’éviter de faire cela nous l’avons divisé en deux. Dans cette méthode nous allons voir si le nœud est présent dans l’arbre avec la méthode « isExisteNode(newNode) » s’il est présent on le retire avec la méthode « removeNode » et on équilibre avec « balanceTree ». Si le nœud n’est pas présent il sera ajouté via la méthode « addNode »  et équilibré toujours avec « balanceTree ».

2) La méthode « AddNode » prend deux paramètres un nœud actuel et le nœud à ajouter, on vérifie si l’arbre est vide ou non, s’il est bien vide nous allons créer une racine. S’il n’est pas vide nous allons voir si la valeur du nœud actuel est supérieur au fils Gauche à la valeur du nouveau nœud, si c’est le cas et qu’il n’a pas de fils gauche nous lui en ajoutons un. Sinon on fait une récursion sur « AddNode » afin de parcourir l’arbre. Nous faisons pareil pour le Fils Droit

3) « removeNode »

4) « balanceTree »  va permettre de rééquilibrer l’arbre après lui avoir apporté une modification que ce soit un ajout ou une suppression. Il existe quatre possibilité de rééquilibrage. «display » l’affichage va s’effectuer via cette méthode « isEmpty » une méthode booléen qui renvoi vrai si l’arbre est vide et faux sinon.

5) « isExistNode » permet de savoir si une valeur est présente dans l’arbre ou non pour cela la méthode prend en paramètre un nœud avec une certaine valeur. « IsExistNode » va retourner un booléen de sorte que si l’arbre est null on retourne false. Si le fils gauche ou droit de la racine ont la même valeur alors cela retourne true, si la valeur du nœud rentrée en paramètre est inférieur au fils droit de la racine nous effectuons un appel récursif sur « isExistNode » avec en paramètre le fils gauche de la racine. Sinon nous faisons de même avec le fils Droit.

6) «getHeight » nous retourne simplement la hauteur de l’arbre 



La classe « Main » va nous permettre d’effectuer des tests 
