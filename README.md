#  Capteurs embarqués Android

## 📌 Description

Ce projet Android (Java) illustre l’utilisation des capteurs embarqués d’un smartphone afin de développer une application interactive permettant de lire, afficher et analyser des données en temps réel.

L’application exploite les capteurs matériels Android via `SensorManager` et présente les résultats sous forme de textes et de graphes dynamiques.

---

## 🎯 Objectifs du projet

* Comprendre l’architecture des capteurs Android
* Utiliser le SensorManager et SensorEventListener
* Lire les données des capteurs en temps réel
* Créer des graphes dynamiques avec Canvas
* Utiliser les Fragments pour structurer l’application
* Implémenter une interface mobile interactive

---
<img width="519" height="985" alt="Screenshot 2026-05-11 213549" src="https://github.com/user-attachments/assets/8364648e-3d20-4918-83b9-2b45048b1bb3" />

## 🧠 Capteurs utilisés

* 🌡️ Température ambiante
* 💧 Humidité relative
* 📏 Proximité
* 🧲 Champ magnétique
* 📱 Accéléromètre
* 🌍 Gravité
* 🔄 Gyroscope
* 👣 Compteur de pas

---

## 🏗️ Architecture du projet

app/src/main/java/com/example/sensors/

├── MainActivity.java
├── fragments/
│   ├── SensorsListFragment.java
│   ├── SensorGraphFragment.java
│   ├── MotionSensorFragment.java
│   ├── StepCounterFragment.java
│   ├── CompassFragment.java
│   └── ActivityRecognitionFragment.java
│
├── utils/
│   └── SensorFormatter.java
│
└── views/
└── LineChartView.java

---

## ⚙️ Fonctionnalités

### 📋 Liste des capteurs

Affichage de tous les capteurs disponibles avec :

* Nom
* Fabricant
* Type
* Résolution
* Consommation
* Portée maximale

---

### 📊 Graphe en temps réel

* Affichage dynamique des données
* Utilisation de Canvas + Path
* Mise à jour avec invalidate()

---

### 📱 Capteurs environnementaux

* Température
* Humidité
* Proximité
* Champ magnétique

---

### 🧭 Capteurs de mouvement

* Accéléromètre (X, Y, Z)
* Gyroscope
* Gravité

---

### 👣 Compteur de pas

* Suivi automatique des pas
* Optimisation énergie

---

### 🧭 Boussole numérique

* Orientation via magnétomètre + accéléromètre
* Détection du nord

---

### 🏃 Reconnaissance d’activité

* Immobile
* Marche
* Mouvement rapide

---

## 🧩 Technologies utilisées

* Java Android
* Android SDK
* SensorManager API
* Fragments
* Canvas
* Gradle

---

## 🚀 Installation

```bash
git clone https://github.com/youness-lahdiri01/Capteurs-embarqu-s-Android.git
```

Ouvrir dans Android Studio puis :

* Sync Gradle
* Run ▶

---

## 📌 Résultat attendu

Application capable de :

* Lire les capteurs Android
* Afficher données en temps réel
* Tracer des graphes
* Gérer plusieurs fragments

---
<img width="454" height="834" alt="Screenshot 2026-05-11 220914" src="https://github.com/user-attachments/assets/ec247346-2ae3-4215-9ce6-13f6d000412c" />

## 👨‍💻 Auteur

Youness Lahdiri

---

## 📄 Licence

Projet académique – usage éducatif uniquement.
