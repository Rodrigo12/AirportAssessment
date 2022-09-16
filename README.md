# Airport Assessment

## Execute Program
In the command terminal go to AirportAssessment/airport-assessment/

Execute the command
<br />
mvn compile exec:java -Dexec.mainClass="com.airportassessment.Main" -Dexec.args="zimb"

If the *-Dexec.args is specified* the program will return Runways for each airport given a country code or country name
<br />
On the other hand, if the *-Dexec.args is not declared* the program will retrieve the top 10 countries with highest number of airports

## Environment

### Java version
java 13.0.1 2019-10-15
<br />
Java(TM) SE Runtime Environment (build 13.0.1+9)
<br />
Java HotSpot(TM) 64-Bit Server VM (build 13.0.1+9, mixed mode, sharing)

### Maven version
Apache Maven 3.6.2
