# TP-2-ALGO-AVL


La classe « NodeAVL » représente les nœuds de l’arbre chaque nœud a pour attribut une hauteur « height » , une valeur « valueNode » et un fils Gauche et Droit « letf & rifht » .
Un constructeur  prenant en paramètre une valeur, il va créer un nœud avec pour filsG et filsD ayant pour valeur null, la valeur rentré en paramètre sera associé a la valeur du nœud et la hauteur sera égale a 1.
De plus des méthodes getter et setter de chaque attribut ont été implémenté afin de pouvoir recupperer les données du nœud.

La classe « TreeAVL » va représenter un un arbre de nœud, il aura en attribut une taille mais également une racine. Cette racine étant de type « NodeAVL »  il aura initialement pas de filsG ou filsD et une hauteur « height »  valant 1.
Méthode : 
Afin de supprimer ou ajouté un nœud à cet arbre nous avons implémenté la fonction « addOrDeleteNode », à l’affichage il nous sera simplement demandé de rentrer une valeur. Cette valeur si elle n’est pas présente sera ajouté et si elle est déjà présente dans l’arbre elle sera supprimé. Cela est la raison pour laquelle nous avons une méthode qui va effectuer deux actions ce qui est contraire au regle de programmation. Dans cette méthode nous allons voir si le nœud est present dans l’arbre avec la methode « isExisteNode(newNode) » s’il est présent on le retire avec la méthode « removeNode » et on équilibre avec « balanceTree ». Si le nœud n’est pas present il sera ajouté via la methode « addNode »  et équilibré toujours avec « balanceTree ».

La méthode « AddNode » prend deux paramètres un nœud actuel et le nœud a ajouter, on verifie si l’arbre est vide ou non, si il est bien vide nous allons créer une racine. S’il n’est pas vide nous allons voir si la valeur du nœud actuel est supérieur au fils Gauche  à la valeur du nouveau nœud, si c’est le cas et qu’il n’a pas de fils gauche nous lui en ajoutons un. Sinon on fait une récursion sur AddNode afin de parcourir l’arbre. Nous faisons pareil pour le Fils Droit

« removeNode »

« balanceTree »  va permettre de réequilibrer l’arbre apres lui avoir apporté une modification que ce soit un ajout ou une suppression. Il existe quatre possibilité de rééquilibrage.

L’affichage va s’effectuer via la methode « display » 
« isEmpty » une methode boolean qui renvoit vrai si l’arbre est vide et faux sinon.

« isExistNode » permet de savoir si une valeur est presente dans l’arbre ou non pour cela la methode prend en parametre un nœud avec une certaine valeur. IsExistNode va retourner un boolean de sorte que si l’arbre est null on retourne false. Si le fils gauche ou droit de la racine on la meme valeur alors cela retourne true, si la valeur du nœud rentré en parametre est inferieur au fils droit de la racine nous effectuons un appel recursif sur isExistNode avec en parametre sur le fils gauche de la racine. Sinon nous faisons de meme avec le fils Droit.

« getHeight » nous retourne simplement la hauteur de l’arbre 



 
