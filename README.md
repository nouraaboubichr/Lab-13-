# Exercice 1 - Sérialisation et Désérialisation

* Comprendre le mécanisme de **sérialisation et désérialisation** en Java.
* Utiliser **`ObjectOutputStream`** et **`ObjectInputStream`** pour écrire et relire des objets.
* La classe **`Employee`** implémente **`Serializable`** et contient les champs `id`, `name`, `salary` et `password`.
* Utiliser **`serialVersionUID`** pour gérer la version de la classe.
* Utiliser **`transient`** pour exclure le champ sensible `password` de la sérialisation.
* La classe **`SerializationUtil`** permet de sérialiser une `List<Employee>` dans **`employees.ser`** et de la désérialiser.
* Utiliser le **try-with-resources** pour fermer automatiquement les flux.
* Après désérialisation, le champ **`password`** n’est pas restauré et devient **`null`**.
* Gérer les exceptions **`IOException`** et **`ClassNotFoundException`**.
* Les extensions proposées concernent la sérialisation conditionnelle, les collections indexées, les flux NIO et le versionnage de la classe.

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040018.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040044.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040058.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 050915.png" />

# Exercice 2 - Sérialisation avancée avec Externalizable

* Découvrir l’interface **`Externalizable`** pour contrôler précisément la sérialisation.
* Implémenter les méthodes **`writeExternal`** et **`readExternal`** dans la classe `ChatMessage`.
* `ChatMessage` contient `user`, `message`, `timestamp` et un champ dérivé **`length`** marqué `transient`.
* Utiliser un **constructeur public sans argument**, obligatoire avec `Externalizable`.
* Ajouter une constante **`FORMAT_VERSION`** pour gérer l’évolution du format binaire.
* La classe **`ChatHistory`** permet de sauvegarder et charger une liste de `ChatMessage`.
* Lors de la sauvegarde, écrire d’abord le nombre de messages puis chaque message avec **`writeExternal`**.
* Lors du chargement, recréer les objets et utiliser **`readExternal`**, puis recalculer le champ `length`.
* Utiliser le **try-with-resources** et gérer **`IOException`** et **`ClassNotFoundException`**.
* Les extensions proposées concernent les formats JSON/XML, la compression avec **`GZIPOutputStream`**, la mise à jour incrémentale et la journalisation des versions.

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040018.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040044.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 040058.png" />

<img width="1270" height="674" alt="1" src="images/Capture d'écran 2026-09-10 050915.png" />
