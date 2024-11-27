# PeryLoth.com---Java---Selenium
Robot para probar pagina web personal, ejemplo para demostrar dominio en el tema

correr pruebas locales Chrome
```
mvn clean test -Dbrowser=chrome -DchromeDriverPath="D:\\QA_Automatiozacion\\chromedriver-win64\\chromedriver.exe" -DchromeBinaryPath="C:\Program Files\Google\Chrome\Application\\chrome.exe"
```

correr pruebas locales firefox
```
mvn clean test -Dbrowser=firefox -DfirefoxPath="C:\\Program Files\\Mozilla Firefox\\firefox.exe" -DfirefoxDriverPath="D:\\QA_Automatiozacion\\geckodriver-v0.35.0-win64\\geckodriver.exe"
```
