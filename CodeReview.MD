

Labdien, Dmitrij
 
Kopumā Jūsu darbu vērtēju kā viduvēju.
 
Jūsu darbā man patika ka:
1)      Kods ir īss un kodolīgs un viegli lasāms
2)      Testi ir īsi un testē tikai vienu darbību
3)      Testu nosaukumiem ieturēts vienots stils un var labi saprast, kuru metodi tie testē
4)      Pareizi esi izvēlējies metodi, kā  pārbaidīt vai viena nauda ir lielāka par citu. Arī pie pirkšanas naudas atņemšanas darbība ir realizēta pareizi, pārvēršot naudu uz centu kopsummu
 
Un ir arī kļūdas:
1)      Šķiet ka ir bijušas neskaidrības/šaubas darba pildīšanas laikā, taču neesi uzdevis man jautājumus. Komunikācija ar biznesu vai pasūtītāju ir svarīgi, lai vēlāk darbs nav jāpārtaisa.
2)      Ir tikai 6 UnitTesti. Ideālā gadījumā ir jābūt ap 22 testiem, lai pārbaudītu visus iespējamos gadījumus. Piemēram, tev nav neviena testa, kurš pārbauda metodi “getManufacturer()”
3)      Nav nevienas testa, kas pārbaudītu vai pievienotajiem produktiem ir iedoti nosaukumi, vai cena ir lielāka par nulli, vai daudzums ir lielāks par nulli.
4)      Nevienai kļūdas situācijai neesi izveidojis izņēmumu klases. Piemēram, pērkot produktu un ievadot produkta numuru lielāku par produktu skaitu, notiks Java valodas kļūda, kas lietotājam nedos nekādu priekšstatu par to, ko viņš ir izdarījis nepareizi.
5)      Klasē “Money” esi papildinājis doto struktūru ar savu kodu. Tas īsti nebija atļauts, jo Fiziskā iekārta saprot tikai “Eiropas savienībā” izdoto naudu. Naudas atpazīšanas iekārtas šo “naudu” atzītu par viltojumu. Pareizi būtu darbības ar naudu iznest atsevišķā klasē.
6)      Testā “insertCorrectCoinsAndGetCoinsBack”, metodes “prepareVariables();” izsaukums ir lieks.
7)      Testos visās vietās, kur lieto “Assert.assertTrue”, vajadzētu lietot “Assert.assertEquals”, lai iegūtu precīzāku ziņojumu kļūdas gadījumā.
8)      Testā “insertIncorrectCoinsAndGetCoinsBack”, pārbaude “Assert.assertTrue(correctedSum.isEqualTo(remainder));” izslēdz vajadzību pēc pārbaudes “Assert.assertFalse(incorrectSum.isEqualTo(remainder));”
9)      Testā “insertTooBigMoneyToBuyProduct” pēdējā pārbaudē nav jālieto metode “Money.subtract”, jo šī pati metode tiek izmantota pirkšanas brīdī. Tas nozīmē ka ja kļūda būs “substract” metodē, tad šo kļūdu nebūs iespējams noķert ar šo testu. Vispār testos maksimāli daudz jāizmanto konstantes ar konkrētiem ieejas datiem un precīzi sagaidāmiem izejas datiem.
10)   Nav pareizi uztverta metodes “insertCoin” nozīme. Komentāros pats arī atzīmējis ka tavā izvēlētajā gadījumā nav iespējams korekti pārbaudīt atļautās monētas. Šī problēma atkristu, ja pamanītu, ka dotajā interfeisā pie apraksta ir teikts: “Inserts the coin”. Tātad metode pieņem pa vienai kapeikai kā tas ir reālajā dzīvē. Līdz ar to precīzi var pārbaidīt monētu derīgumu. Un metodē ir jārealizē monētu summēšana.
 
Kopumā uzrakstītais kods no koda viedokļa ir labs, taču ne līdz galam esi iedziļinājies uzdevumā un izpildījis to ļoti vienkārši. Lai gan dotais interfeiss ir ļoti vienkāršs, pastāv ļoti daudz un dažādi izņēmuma gadījumi, kuri kodā ir jāparedz un attiecīgi ar testiem jānotestē.

