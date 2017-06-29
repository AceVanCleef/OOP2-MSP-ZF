# oop2_generics_uebung

## Projektstuktur
### Inheritance Tree
![inheritance tree](https://github.com/AceVanCleef/oop2_generics_uebung/blob/master/documents/inheritance-tree.jpg?raw=true "Inheritance tree")

In OOP2 - MSP:
- A = Getränk
- B = Wein
- D = Rotwein
- C = Bier

### Generische Klassen
- Box < T>:  
Eine generische Klasse mit einem einzelnen Typparameter.
- BoxWith2Typeparams<Q, T>:  
Eine Klasse mit mehreren Typparametern (hier: key-value - Paar).
- ArrayBox< T extends A>:  
Eine generische Klasse mit constraints (extends, super)

### TestGenerics
Zweck: Zeigt, welche Aufrufe u.ä. funktionieren oder einen Compilierfehler ergeben..