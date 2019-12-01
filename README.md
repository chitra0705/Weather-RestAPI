# Weather-RestAPI
Weather-RestAPI
# WeatherRestAPI
This framework helps in getting weather forecast for inputed location.

## Overview:
1. Schemes

* HTTP

2. Endpoints

* /data/2.5/weather

   * GET



## Schemes:

* HTTP

### historical
This endpoint has information about the historical weather data of London.

#### GET
/data/2.5/weather 

Description: List of all dates for which weather information is available. 

Parameters: None

Response: 

Code  | Description
----  | ---
**200** | *JSON array of dates in 'YYYYMMDD' format.*
**404** | *Error message in JSON format.*
