# command Model Events

Sperimentazione della modellazione con il pattern derivato dal DDD + CQRS

## problema carrello

aggiungo articolo A--> vedo carrello
aggiungo articolo B--> vedo carrello aggiornato
aggiungo articolo B--> vedo carrello aggiornato
diminuisce prezzo articolo A --> vedo carrello aggiornato
aumenta il prezzo articolo A --> vedo carrello ignora aggiornamento



### modellazione con command - events
* chiedo stato carrello --> vuoto
* chiedo lista articoli --> restituisce articoli A, B con rispettivi prezzi e descrizione  
* aggiungo un articolo --> (empty)
* chiedo lista articoli --> carrello con un articolo e suo prezzo + totale prezzo carrello
* aggiungo un altro articolo --> (empty)
* aggiungo articoli --> (empty)
* chiedo lista articoli --> aggiornata
* aggiorno prezzo articoli --> (empty)



