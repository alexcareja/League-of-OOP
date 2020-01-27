Student: Careja Alexandru-Cristian
Grupa: 324 CD
Proiect POO

\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ Etapa 1 \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/

	Pentru implementarea jocului am creat cateva clase, grupate in pachete 
pentru oorganizare mai buna a proiectului, dupa cum urmeaza:

>>> Pachetul main:
	>< Clasa Main: In aceasta se realizeaza citirea din fisierul de intrare,
	apelurile pentru instantierea hartii si crearea acesteia, apelurile pentru
	generarea eroilor, desfasurarea jocului care implica cateva apeluri:
	applyDebuff, citirea si efectuarea miscarilor, apelul catre metoda ce duce
	la desfasurarea luptelor, si apelul pentru level up. In final se scrie in
	fisierul de iesire statutul fiecarui jucator.

>>> Pachetul visitor_pattern:
	>< Interfata Visitable: ce reprezinta patternul pentru obiectele visitable.
	>< Interfata Visitor: patternul pentru obiectele vizitator.

>>> Pachetul map:
	>< Clasa GameMap: Urmareste patternul de Singleton si contine metode pentru
	citirea + crearea hartii, pozitionarea jucatorilor pe harta, efectuarea
	mutarilor, desfasurarea luptelor si getter pentru pozitie (returnata ca 
	string). In metoda fight, se parcurge fiecare punct alt hartii si se cauta
	2 oponenti vii pe acea pozitie. Daca cei doi exista, ma asigur ca daca unul
	dintre ei este Wizard, el isi va folosi abilitatile al doilea, pentru a
	putea aplica Deflect asa cum trebuie. Aici este folosit double dispatch
	pentru aplicarea daunelor intre ei.
	>< Enumeratia LandType: Contine tipurile de teren Desert, Land, Vocanic,
	Woods si sunt folosite ca tip de date pentru harta si in verificarea
	terenului pe care se desfasoara o lupta in vederea obtinerii sau nu a unui
	bonus de teren.

>>> Pachetul heroes:
	>< Clasa abstracta Hero: o reprezentare abstracta a cum ar trebui sa arate
	clasa unui erou. Contine si implementarea unor metode de baza precum
	getteri pentru parametrii privati/protected, applyDebuff (care aplica daune
	overtime daca trebuie), checkHp (care verifica daca eroul a ajuns sub 0hp
	fie in urma unei batalii, fie in urma suferirii unor daune overtime) si
	getStatus (care returneaza ca String statusul jucatorului dupa cum este
	cerut: nivel, experienta, viata). Evident, exista si metode abstracte ce
	urmeaza a fi implementate in clasele ce vor deriva Hero.

	<(<>)> In continuare voi descrie numai una din clasele Knight, Rogue, 
		Wizard, Pyromancer, intrucat ele sunt foarte asemanatoare; ceea ce 
		difera sunt constantele folosite, debuffurile aplicate, metoda levelUp
		si stringul returnat de metoda getHeroClass.

	>< Clasa Knight: reprezentarea rasei Knight. Are bonus damage cand se afla
	pe teren de tip Land, iar metoda getLandModifier returneaza amplificatorul
	de damage (1 sau 1.15 in acest caz). Am implementat 4 metode dealDmg pentru
	fiecare tip de oponent primit ca parametru, dupa cum prevede Visitor 
	pattern. In aceste metode se cacluleaza daunele provocate de fiecare
	abilitate impreuna cu modificatorii specifici, rotunjite la un numar intreg
	care urmeaza sa fie aplicat ca dauna oponentului. De asemenea, se aplica
	debuff-ul de imobilizare al abilitatii slam. In cazul in care oponentul
	curent este un Wizard, se mai apeleaza o metoda(pe care o apeleaza si Rogue
	si Pyromancer) care seteaza daunele fara modificatori de rasa pe care
	le va folosi abilitatea Deflect pentru a provoca daune sursei. Metoda
	levelUp calculeaza nivelul jucatorului in functie de exeperienta sa si
	modifica atributele sale(viata, damage-ul, etc) daca face level up.

>>> Pachetul Utils:
	>< Clasa Constants: contine toate constantele jocului
	>< Clasa HeroesFactory: urmareste singleton pattern si factory pattern si
	este folositoare la generarea eroilor la inceputul programului.

<>|<> Observatii: Commiturile pe GitHub le-am facut din browser si se pot vedea
	prin rularea comenzii "git log --stat"


<>|<> Feedback:-Cool tema! Singura obiectie este ca in jocuri de obicei cand ai
	o pasiva care iti permite sa dai un critical o data la 3 atacuri, nu se da
	proc incepand cu primul atac, ci cu al 3-lea incepand de la primul atac.


\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ Etapa 2 \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/

In etapa a doua am facut urmatoarele modificari:

>>> Pachetul main:
	>< Clasa Main: A ramas la fel, cu mici modificari precum citirea mutarilor
	si a ingerilor, precum si spawnarea ingerilor si notificarea marelui vraji-
	tor in legatura cu toate cele intamplate.

>>> Pachetul map:
	>< Clasa GameMap: Am adaugat metoda spawnAngel care primeste ca parametri
	un inger, pozitia sa, si lista de eroi, si care aplica efectul ingerului
	eroilor care se afla pe pozitia respectiva in runda curenta. De asemenea,
	odata cu mutarile, in metoda moveHero, jucatorii isi aleg si strategiile
	daca nu sunt incapacitati.

>>> Pachetul heroes:
	>< Clasa abstracta Hero: Pentru fiecare erou am adaugat un modificator de
	inger si un modificator de strategie, care vor fi luate in calcul cand
	eroul va da damage. Am adaugat metode pentru setarea acestor modificatori,
	precum si metoda heal, care este folositoare cand ingerii redau o parte din
	viata eroilor. De asemenea, clasa Hero acum extinde clasa Observable si are
	metodele addObservers si notifyObservers, astfel incat marele vrajitor 
	poate fi la curent cu toate cele intamplate.

	<(<>)> In fiecare clasa de erou (Knight, Pyromancer, Rogue, Wizard) am
	adaugat metoda applyStrategy in care eroul decide daca vrea sa aplice o
	strategie anume si am modificat calculul de damage produs, adaugand la
	modificatorul de rasa modificatorii de inger si de strategie.

>>> Pachetul utils:
	>< Clasa Constants: Am adaugat mai multe constante
	>< Clasa AngelFactory: Urmareste singleton pattern si factory pattern si
	este folositoare la generarea ingerilor de-a lungul jocului.

>>> Pachetul admin:
	>< Clasa GrandWizard: Reprezinta implementarea marelui vrajitor care
	urmeaza patternul observer si atunci cand este notificat in legatura cu
	un eveniment, se scrie in fisier ceea ce s-a intamplat.

>>> Pachetul angels: 
	<(<>)> Contine clasa abstracta angel, respectiv implementarea tuturor
	ingerilor, urmarind patternul visitor si observer. Fiecare inger are 4
	metode visit cu care interactioneaza cu fiecare clasa de erou, respectiv
	doua metode care returneaza tipul ingerului respectiv actiunea realizata
	de el (helped/hit).
	>< Clasa abstracta Angel: Contine implementarea patternului Observer cu
	metodele addObserver si notifyObserver si doua metode abstracte.

>>> Pachetul strategies:
	>< Interfata Strategy: Are 4 metode applyStrategy, fiecare care primeste
	ca parametru un erou diferit.
	>< Deffensive Strategy: Este un Singleton si este strategia care atunci
	cand un erou scade sub un anumit nivel al HP-ului, va renunta o parte din
	coeficienti si va primi un procent din viata maxima inapoi.
	>< Offensive Strategy: De asemenea Singleton, si este aplicata atunci cand
	eroul se afla cu HP-ul intre doua limite, atunci cand poate renunta la un
	procent din HP-ul curent pentru a creste coeficientii.
	
