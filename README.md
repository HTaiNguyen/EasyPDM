# EasyPDM

Pour créer la base de donnée sous Netbeans :
  - se positionner sur l'onglet services
  - développer le noeud databases
  - clic droit sur le noeud java DB
  - create Database

Puis il faut créer la connectionPool pour cela :
  - se positionner sur l'onglet projects
  - clic droit sur le projet puis new > Other
  - dans la fenêtre chercher le répertoire glassfish et selectionner JDBC Ressource
  - Next
  - Cocher Create New JDBC Connection Pool
  - Saisir le nom jdbc/nomDeLaBase
  - Next
  - Next
  - Saisir le nom nomDeLaBasePool
  - Selectionner la base de donnée qu'on vient de créer
  - Next
  - Finish

On dispose maintenant du connexionPool pour le persistence Unit
