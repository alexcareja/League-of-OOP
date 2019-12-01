Student: Careja Alexandru-Cristian
Grupa: 324 CD
Proiect - Etapa 1

	Pentru implementarea jocului am creat cateva clase, grupate in pachete pentru o
organizare mai buna a proiectului, dupa cum urmeaza:

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
	>< Clasa HeroesFactory: urmareste singleton pattern si este folositoare la
	generarea eroilor la inceputul programului.


<>|<> Feedback:-Cool tema! Singura obiectie este ca in jocuri de obicei cand ai
	o pasiva care iti permite sa dai un critical o data la 3 atacuri, nu se da
	proc incepand cu primul atac, ci cu al 3-lea incepand de la primul atac.
 				-Sper ca la etapa a 2-a sa apara mobi

                                \\_V_//
                                \/=|=\/
                                 [=v=]
                               __\___/_____
                              /..[  _____  ]
                             /_  [ [  M /] ]
                            /../.[ [ M /@] ]
                           <-->[_[ [M /@/] ]
                          /../ [.[ [ /@/ ] ]
     _________________]\ /__/  [_[ [/@/ C] ]
    <_________________>>0---]  [=\ \@/ C / /
       ___      ___   ]/000o   /__\ \ C / /
          \    /              /....\ \_/ /
       ....\||/....           [___/=\___/
      .    .  .    .          [...] [...]
     .      ..      .         [___/ \___]
     .    0 .. 0    .         <---> <--->
  /\/\.    .  .    ./\/\      [..]   [..]
 / / / .../|  |\... \ \ \    _[__]   [__]_
/ / /       \/       \ \ \  [____>   <____]