# Test Sandbox

## Introduction

Ce repo a pour but de repertorier un ensemble de couples UseCase/TestCase pertinant et representatif de ce que l'on trouve sur les projets.

## Objectifs

L'objectif est d'identifier les differents type d'implementation d'un usecase que l'on peut trouver, et de fournir la ou les implementation de test associee.

## Structure

Il existe plusieurs type de usecases, avec les dimensions suivantes :

- Programmation
	- Synchrone
	- Asynchrones (Reactifs)
- Complexite
	- Sans dependance
	- Avec dependances
-  Pureté
	- Uniquement en java/kotlin
	- Avec des lib externes (Joda)
	- Avec des resources 

## Techniques

### Structure

- // Given
- // When 
- // Then

### Type de test

Pour des tests simples, on peut faire une methode par cas

Pour des tests necessitant un jeu de donnee d'entree important, il est preferable d'utiliser des cas de test avec parametres

### Objectif des tests

On test des uses case, donc notre test doit evoquer une regle fonctionnelle, pas un detail d'implementation.

Le but du test n'est pas de reecrire l'implementation du usecase dans le test, mais de verifier soit :
- le comportement a haut niveau
- les differents comportements par des cas particuliers suffisants
- les sequences d'appels de ses dependances

### Librairies

- AssertJ
- Mockk
- RoboElectric

### Processus

- TDD
- Couverture

### Consideration

Les tests sont aussi du code, il y a autant de bug dans les tests que dans le fonctionnel !



### Reduction des tests




# Contenu du repo

## Sync

- [x] ExampleUnitTest

## Async

- [x] Completable
- [x] Observable
- [ ] Maybe
- [ ] Single
- [ ] doOn
- [ ] Subscribing
- [ ] Interval
- [ ] Zip
- [ ] Scan
- [ ] ConbineLatest
- [ ] Interval
- [ ] Callback
- [ ] Callback/Lambda anonyme

## Android

- [ ] BuildConfig
- [ ] Resources
- [ ] Context

## Object

- [ ] SimpleObject
- [ ] ComplexObject
- [ ] ComplexObjectWithDep

## Dependencie Injection

- [ ] UseCase
- [ ] Repository
- [ ] ViewModel
- [ ] SingleTon
- [ ] ActivitySingleton



