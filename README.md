# OOP2 MSP Zusammenfassung

## Inhalt

### 01. Collections
- List, Maps, Sets
	- Listen kommen im vollen Umfang: Elemente hinzufügen, löschen, nach kleinstem oder grössten Element suchen, Liste erstellen, etc
	- Maps, Sets im kleineren Umfang
	
	
### 02. Streams & Lambdas
- auf collection basierend etwas machen via Stream oder Schleife
- wenige Aufgaben, bei denen vorgegeben ist, dass man Streams verwendet
	Streams > Schleife, da effizienter
	
### 03. Generics

Es kommt ganarantiert mind./etw. eine Aufgabe vor im Stile von:  
"Eine generische Klasse (à la Klasse Bottle) schreiben."
	
### 04. JavaFX: GUI mit Trennung PM/View:
Relevant im kleinen Umfang (ca. 2 Klassen + Starterklasse)

Aufgabe:
- einfaches Layout
- Binding
- EventListener
- EventHandler @ Button(s) -> z.b. .calc() oder .save() auslösen

Teilaufgaben:
-	Resizing: setHGrowth, setVGrowth
-	Button: Wenn 1 Button -> wächst in Breite
-	Button enablind/disablind

**Hinweis**: Entweder wird die RootPM.java oder die RootPane.java vorgegeben und man muss die jeweils andere Klasse schreiben.
Hinweis 2: Musterlösung erstellbar (Umfang: siehe Foto)

### 05. File Handling (I/O):
Textfile
- Lokalisieren (Pfad zurückgeben -> getPath())
- File einlesen
- In File speichern

**Hinweis**: siehe ServiceFileBased.java