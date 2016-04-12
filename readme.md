This application was built using spring boot and selenium webdriver for the web crawling. 

The aim of the application was to crawl over a particular set of pages, extract some key bits of information and then return that information back to the client in JSON form. 

The rationale was to separate out the concerns and give each entity a single responsibilty principle, hence I have one service that's focussed on extracting product information and another service for building the json. 

To run the application you will need to have maven installed locally and Java 7.

You will also need the download chrome driver from this url https://sites.google.com/a/chromium.org/chromedriver/ and update the location specified in the string DRIVER_LOCATION in PageConsumerService, I tried to run it with firefox but was encountering javascript errors. 

Go into the root directory and run mvn:clean install - this will download all of your dependencies. 

Once the application has been built you can run it with the following command: 

mvn spring-boot:run -Drun.arguments="http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&storeId=10151&krypto=lIMmjlSSD%2FBfugUE5e%2BZ7BQ17Y%2BdwnSH1FDzpuKnH6KQztVoW%2FvROK0LPAj4Sxlbi9mYPVJ7ozApp38iU3JPXmWE2hklcjjajOUUMtE6Y6Lffq79VjeQYlmfpzu3lU5m02sUhwhv4IaQRcxZLyJEEac1W8WH2hcnf65ihjc8qwwBSxNBMlL03tdLev2YNnmZbhAaFYwjqlF7Xh0u%2FXsoeioeMPrkL5MJUYzwrqBMfzBMXEGbTcPwZev3J1AndQnlkPdbDASog7isMYdY7hHgBF%2BFu%2F3jPfPqQOF4j%2BdKRcM%2BtJMxLGgW%2BicSQKNs35C8HbrItPdsIljGTfz7e8JGyA%3D%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0"
