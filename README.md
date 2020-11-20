# TwitterApi with Springbot
This project posts a new tweet that returns the status code along with the URL of the tweet and then other functionality returns the tweets from the home timeline.
## Installation
Use the [spring initializr ](https://start.spring.io/) to create a maven project with the required dependencies.
## Procedure
Step 1: Create a Twitter account.  
Step 2: Create a Twitter developer account.  
Step 3: Create a new and save the access token, access secret token, customer key, and customer secret key.  
Step 4: Clone this repo and open it in IDE.  
Step 5: Go to twitter4j.properties file and paste your key accordingly.  
Step 6: Run the file.  
Step 7: Download and open [Postman](https://www.postman.com/downloads/)  
Step 8: Set the HTTP Request as Post, enter the [Local host](http://localhost:8080/api/1.0/twitter/tweet) URL, and type the tweet in Body. This will return the HTTP code, message, and URL of the tweet. If the request fails error message is returned.  
Step 9: For getting the home timeline, set the request as GET and enter this [URL](http://localhost:8080/api/1.0/twitter/timeline). This will return the tweets from home timeline.
