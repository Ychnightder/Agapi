# 📱 AGAPI - Application Mobile de Gestion des Dons

**AGAPI** est une solution numérique développée pour répondre à une demande de l'association **France Assos Santé**. L'objectif est de proposer une plateforme simple, intuitive et accessible à tous pour faciliter le soutien aux associations partenaires.

## 🎯 Objectifs du Projet
* **Accessibilité Numérique** : Respect des normes en vigueur (WCAG, RGAA) pour une application inclusive.
* **Flexibilité des Dons** : Gestion des dons ponctuels (sans compte) et récurrents (avec compte sécurisé).
* **Innovation** : Accès direct aux fiches d'associations via des **QR Codes** présents sur divers supports de communication.
* **Pilotage** : Interface dédiée pour les administrateurs permettant de consulter les dons et d'obtenir des statistiques précises.

## ✨ Fonctionnalités Clés
* **Interface Dynamique** : Sections Accueil, Association et Profil adaptées selon le type d'utilisateur (anonyme ou inscrit).
* **Deep Linking** : Redirection automatique vers la bonne association grâce à un système de liens profonds (`donsante://association`) intégrés aux QR Codes.
* **Dashboard Admin** : Tableau de bord web affichant des graphiques sur le nombre de dons par mois et le montant total récolté.
* **Navigation Fluide** : Utilisation de **RecyclerViews** avec adapters personnalisés pour l'affichage des listes d'associations.

## 🛠 Stack Technique 
### Frontend (Mobile)
* **Langages** : Java et XML sous **Android Studio**.
* **Composants** : Activities, Fragments, et **ConstraintLayout** pour une mise en page responsive.
* **Persistance** : SharedPreferences pour sauvegarder l'état de connexion.

### Backend & API
* **Logique Serveur** : Développement en **PHP** pour la communication client/serveur et les requêtes SQL.
* **Modèle de Données (MCD)** : Structure relationnelle incluant les entités Utilisateurs, Associations, Dons et Rapports.
* **API REST** : Gestion complète des accès aux données (Endpoints GET, POST, PUT, DELETE).

## 🎨 Conception et Organisation
* **Design** : Phase de conception ergonomique réalisée intégralement sur **Figma**.
* **Collaboration** : Travail en équipe de 4 personnes avec versioning du code via **GitHub**.
