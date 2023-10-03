# eventTracker
Problem Statement 
This is a machine coding round which aims to explore how well you can implement a solution you have in your mind. The task at hand
pertains to the development of a system for tracking user journey within an e-commerce application.
The following steps outline the user's journey within the application:
1. The user accesses the application.
2. The user clicks on the banner.
3. A list of products is displayed.
4. The user selects a specific product.
5. The user adds the selected product to the cart.
6. The user places an order.
This is generally referred to as the app funnel and in this task we want to build a system to track the percentage of users at each step of
the funnel.
# Final Output
The final output, obtained by querying the database, includes the following information:
1. Percentage of users in each stage of the user journey: This indicates the proportion of users at each stage of the journey within the
application. It provides insights into how users progress through the different steps of the app.
2. Evaluation of the performance of different cities: This evaluation is based on the percentage of users from each city. It allows us to
assess how well or poorly different cities are performing in terms of user engagement with the application. By analyzing the distribution
of users across cities, we can identify which cities have a higher or lower percentage of users using the app.
# How to Run : 
MondoDB setup : at port 27017
Server port : 8081

API REQUESTS :
1. to test the connection and response : GET http://localhost:8081/webhook/test \
2. to post the data in MongoDB : POST http://localhost:8081/webhook/event \
             {  \
  "id":"abc125",  \
  "userId":"003",  \
  "eventName":"BANNER_CLICK",  \
  "city":"Pune"  \
}  \
3.to get the percentage of each stage : POST http://localhost:8081/webhook/percentage/{eventName}  \
  eventNames can be -  APP_ACCESS,BANNER_CLICK,VIEW_PRODUCTS,SELECT_PRODUCT,ADD_TO_CART,PLACE_ORDER  \
4. to get the performances of cities : localhost:8081/webhook/performance/{city}  \
