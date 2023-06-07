# vytvoris slozku, ta ~ je tvoje home slozka
mkdir ~/zaloha;
# zkopirujes tam tohle vsechno
cp -rf * ~/zaloha/;
# Timhle si vytvoris svoji vetev 'master' 
git checkout -b master

# to && znamena 'cekej az se provede predchozi prikaz, a pokud bude uspesny, pokracuj, jinak finito
# commit znas, proste zapises zmeny
&& git commit -m “XYZ udelala zmeny”
# Tady nahrajes na origin - coz je remote server - "to kam se to uklada" - svoji novou vetev
&& git push origin master
# Ted potrebujeme ten puvodni obsah dat zpatky do vetve takze ji smazeme
# A taky to rekneme serveru
&& git push origin -d main
# Ted zkopirujes to co mas u sebe do vetve 'main'
&& git checkout -b main
# A ted ty zmeny - to ze jsi spravila ten bordel co jsem nadelal nahrajes na server
&& git push 

