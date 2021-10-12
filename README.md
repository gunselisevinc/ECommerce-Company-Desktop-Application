# E-Commerce Company Desktop Application
Web Service and Desktop Application Example for an E-Commerce Company

## Project Description
The project has two parts:
* Web service that is designed to support interoperable machine-to-machine interaction over a network
* GUI-based desktop application that consumes the web service.

### Web Service: 
Develop a web service for an e-commerce company that sells computers and phones. This company keep tracks of the brand, model, screen size, screen resolution, processor, memory, storage capacity and price for each computer, and also the brand, model, screen size, internal memory and price for each phone. For each product, there could be a list of additional features, including all-day battery life (between 10 hours and 16 hours), touchscreen, face recognition, fingerprint reader, extra-long battery life (16 hours or more). Besides, for each product, there is a list of anonymous comments with ratings (between 1 and 5), such as "★★★★ Nice design!". The web service is designed to provide products along with all associated information based on the search criteria. The search criteria can be created based on the information available in the system. The search criteria should be created for either computers or phones, not both. Therefore, the web service can return a list of computers or the list of phones at the same time, not both of them.

## Desktop Application: 
Develop a GUI-based desktop application that allows to send a request to the web service and processes the information retrieved from there. When it receives a list of computers or a list of phones along with their associated information, it assigns them special labels as follows where appropriate:
* If a computer memory is greater than 16 GB, then the application will consider it as a computer with large memory.
* If the computer storage is greater than 1 TB, then the application will consider it as a computer with large storage.
* If the phone screen size is greater than 6 inches, then the application will consider it as a phone with large screen.
* If the phone internal memory is greater than 128 GB, then the application will consider itas a phone with large storage.

The application should list the brand and models of the products retrieved along with the special labels added by the application. The application should also
allow to generate a comparison for up to 3 products. The comparison is done in two different views where one view compares the brand, model, screen size, screen resolution, processor, memory, storage capacity, price and extra features for computers, and the brand, model, screen size, internal memory, price and extra features for phones, whereas another view compares their average ratings and show the most recent 3 comments for each product.
