# PeryLoth.com---Java---Selenium
Robot para probar pagina web personal, ejemplo para demostrar dominio en el tema

correr pruebas locales Chrome
`mvn clean test -Dbrowser=chrome -DchromeDriverPath="/usr/local/bin/chromedriver" -DchromePath="/usr/bin/google-chrome"`

correr pruebas locales firefox
`mvn clean test -Dbrowser=firefox -DfirefoxPath="/usr/bin/firefox"`