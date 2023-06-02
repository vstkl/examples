
 
Prepare service using WSGI standard with three endpoints: 
1.  by sending text to endpoint via POST method return JSON containing lowercase 
words not present in dictionary 
2.  for the same input, return pairs of lowercase words where one of pair is present in 
dictionary and one not 
3.  for the same input, return the counts of dictionary and not-dictionary words 
As a dictionary use wordlist provided by wamerican debian package 
(https://packages.debian.org/stable/wamerican) 
Split incoming text by one or more whitespace, commas, bracket, dots and dash characters. 
Additional goals with extra points: 
a)  Try to use none or minimal number of 3rd party libraries 
b)  Prepare deployment for uWSGI or another server using Python package or Debian 
package or Dockerfile. It’s up to your preferences. 
c)  Consider performance (min 100 requests/responses per second), memory footprint 
and high-availability/failover of the endpoint  
d)  Describe all necessary steps to deploy the service like this 
e)  Use spaCy to compare lemmas of words (describe significant performance drop) 
 
Example calling first endpoint 
```
POST /filter_words 
Content-Type: text/plain 
Content-Length: 1341 
 
On top of the cliffs stood a reception committee. 
It consisted in large part of the engineers and researchers who had built the Heart of 
Gold—mostly humanoid, but here and there were a few reptiloid atomineers, two or three 
green sylphlike maximegalacticians, an octopodic physucturalist or two and a Hooloovoo (a 
Hooloovoo is a superintelligent shade of the color blue). All except the Hooloovoo were 
resplendent in their multicolored ceremonial lab coats; the Hooloovoo had been temporarily 
refracted into a free-standing prism for the occasion. 
There was a mood of immense excitement thrilling through all of them. Together and between 
them they had gone to and beyond the furthest limits of physical laws, restructured the 
fundamental fabric of matter, strained, twisted and broken the laws of possibility and 
impossibility, but still the greatest excitement of all seemed to be to meet a man with an 
orange sash round his neck. (An orange sash was what the President of the Galaxy 
traditionally wore.) It might not even have made much difference to them if they'd known 
exactly how much power the President of the Galaxy actually wielded: none at all. Only six 
people in the Galaxy knew that the job of the Galactic President was not to wield power but 
to attract attention away from it. 
Zaphod Beeblebrox was amazingly good at his job. 
```

Example of response 
```
HTTP/1.1 200 OK 
Connection: close 
Content-type: application/json 
 
{"filter_words": ["maximegalacticians", "octopodic", "physucturalist", ...]} 
 
```
Example request for second endpoint 
```
POST /filter_pairs 
Content-Type: text/plain 
Content-Length: 1341 
 
On top of the cliffs stood a reception committee. 
It consisted in large part of the engineers and researchers who had built the 
Heart of Gold—mostly humanoid, but here and there were a few reptiloid atomineers, 
two or three green sylphlike maximegalacticians, an octopodic physucturalist or 
two and a Hooloovoo (a Hooloovoo is a superintelligent shade of the color blue)... 
```
Example of response for second endpoint
```
HTTP/1.1 200 OK 
Connection: close 
Content-type: application/json 
 
{"filter_pairs": [["sylphlike", "maximegalacticians"], ["maximegalacticians", 
"an"], ["an", "octopodic"], ["physucturalist", "or"], ...]} 
```
Example calling third endpoint 

```
POST /filter_counts 
Content-Type: text/plain 
Content-Length: 1341 
 
On top of the cliffs stood a reception committee. 
It consisted in large part of the engineers and researchers who had built the 
Heart of Gold—mostly humanoid, but here and there were a few reptiloid atomineers, 
two or three green sylphlike maximegalacticians, an octopodic physucturalist or 
two and a Hooloovoo (a Hooloovoo is a superintelligent shade of the color blue)... 
```
Example of response 
```
HTTP/1.1 200 OK 
Connection: close 
Content-type: application/json 
{"filter_counts": {"dictwords": 376, "non-dictwords": 42}} 
```