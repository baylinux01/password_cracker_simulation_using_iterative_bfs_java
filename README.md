# password_cracker_simulation_using_iterative_bfs_java
Java ile iterative bfs kullanarak şifre kırma simulasyonu konsol uygulaması

bu küçük konsol uygulaması BFS ve DFS algoritmalarını denemek için 
bir şifre kırma simulasyonu olarak tasarlanmıştır

bu uygulamanın yapımında yararlanılan BFS ve DFS algoritmaları java fonksiyonu olarak aşağıda ayrıca mevcuttur

crackPassword metodu ise bu algoritmalardan daha doğrusu direkt iterative BFS algoritmasından yararlanarak oluşturulmuştur

ilk iki parametre taranacak karakterlerin ascii numaralarının alt ve üst limitleri(bakınız ascii table)

3üncü ve 4üncü parametre denenmek istenen değerin minimum ve maksimum usunlukları

son parametre ise kırılmak istenen hayali şifre

ama harf aralığı ascii 48 ve 122 iken şifre 4 harfli olduğunda 

benim i9 13üncü nesil H serisi işlemcili 16GB ramli ve 1TB nvme ssd'li bilgisayarım çok zorlandı

o yüzden ya şifreyi bir pin gibi sadece sayılardan belirleyerek ascii aralığını kısaltacaktım 

yani 48,122 yerine 48,57 yapacaktım

ya da şifreyi 3 haneye düşürecektim

ancak bu şekilde bilgisayarın gücü yetti.
