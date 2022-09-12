
Check this out !!

### To Run
 - Create a eclipse java project
 - Clone this repo
 - Add PDF Box and Commons Logging jars
 - Run as Java Application

*Jars*
- https://dlcdn.apache.org/pdfbox/2.0.26/pdfbox-2.0.26.jar
- https://dlcdn.apache.org/pdfbox/2.0.26/fontbox-2.0.26.jar
- https://dlcdn.apache.org//commons/logging/binaries/commons-logging-1.2-bin.zip (unzip and pick the jar)

### Output
```# # PARSING # # # # # # # # # # #
Sep 12, 2022 1:53:24 AM org.apache.pdfbox.pdfparser.BaseParser parseCOSDictionaryValue
SEVERE: invalid object number value =0 at offset 66914
Sep 12, 2022 1:53:24 AM org.apache.pdfbox.pdfparser.BaseParser parseCOSDictionaryValue
SEVERE: invalid object number value =0 at offset 68208
  # # # # # OoPdfForm1.pdf # # # # #
Sep 12, 2022 1:53:25 AM org.apache.pdfbox.pdfparser.BaseParser parseCOSDictionaryValue
SEVERE: invalid object number value =0 at offset 66914
Sep 12, 2022 1:53:25 AM org.apache.pdfbox.pdfparser.BaseParser parseCOSDictionaryValue
SEVERE: invalid object number value =0 at offset 160314
Sep 12, 2022 1:53:25 AM org.apache.pdfbox.pdfparser.BaseParser parseCOSDictionaryValue
SEVERE: invalid object number value =0 at offset 160577
  # # # # # OoPdfForm2.pdf # # # # #
# # PARSING DONE # # # # # # # #
= = SHOWING PARSED DATA = = = = = = =
    = = = = = John = = = = = 
Given Name: John
Family Name: Doe
House nr: 1
Address 1: 123 Street
Address 2: 
Postcode: 00000
City: City
Country: Finland
Height: 150
Gender: Man
Driving License: Yes
Language : English
Favourite Colour: Green
    = = = = = Kim = = = = = 
Given Name: Kim
Family Name: Jong
House nr: 9
Address 1: 567 Street
Address 2: 
Postcode: 99999
City: My City
Country: Germany
Height: 120
Gender: Woman
Driving License: No
Language : English
Favourite Colour: Green
= = SHOWING PARSED DATA DONE = = = = = = = = = = =
