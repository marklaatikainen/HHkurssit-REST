# HHkurssit-REST
REST rajapinta kurssitarjonnalle

Live versio: https://hhkurssit.markl.fi/

## Toiminta:

Pyyntojen on oltava autorisoituja.

Esimerkiksi kirjautuminen tapahtuu:

<pre>
const apiBaseUrl = "https://hhkurssit.markl.fi/";

axios.post(apiBaseUrl + "login", payload)
  .then(response => {
    const auth = response.headers.authorization;
}
</pre>
jonka jälkeen palvelimelta saa jwt:n, joka on lähetettävä jokaisen pyynnön mukana palvelimelle. Jwt on voimassa 24 tuntia.

esimerkkipyyntö:

<pre>
const apiBaseUrl = "https://hhkurssit.markl.fi/";

export async function findAllCourses() {
  const res = await axios.get(apiBaseUrl + "course/all", {
    headers: { Authorization: getToken() }
  });
  return res.data;
}
</pre>


## Endpointit:

osoitteessa https://hhkurssit.markl.fi/ näkyvät kaikki endpointit ja niiden alta löytyy hakuvaihtoehdot. 
Dataa ei kuitenkaan saa ulos ilman autorisointia.

<pre>
[

    {
        "method": "GET",
        "path": "/all",
        "description": "get all courses"
    },
    {
        "method": "GET",
        "path": "/{id}",
        "description": "find course by it's id"
    },
    {
        "method": "GET",
        "path": "/campus",
        "description": "show courses in that campus"
    },
    {
        "method": "GET",
        "path": "/language",
        "description": "show courses in that language"
    },
    {
        "method": "GET",
        "path": "/method",
        "description": "show course methods"
    },
    {
        "method": "GET",
        "path": "/program",
        "description": "show courses in that program"
    },
    {
        "method": "GET",
        "path": "/coursename",
        "description": "find course by it's name"
    },
    {
        "method": "GET",
        "path": "/timing",
        "description": "show courses by timing"
    }

]
</pre>