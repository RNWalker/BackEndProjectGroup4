# TechTails - Virtual Pet


## Description

This project is a Virtual Pet game in which a user interacts with their pets, feeding and playing with them. 

Each pet has a **happiness level** and an **energy level**, which start at **50**. Once the game starts running, these values decrease by **2** every **15 seconds**. If a pets health or happiness levels fall to **0**, the pet "dies" and is removed from the user.

The programme allows the user to interact with their pet by feeding them **foods**. Each food is assigned a **nutrition value**. When a pet is fed a **food**, its **energy level** increases by the **nutrition value** of the food. For example, if a pet with an **energy level** of **50** is fed some **Raw Meat** with a **nutritionValue** of **20**, its **energy level** will increase to **70**. 

The programme also allows the user to play with their pet with **toys**. Each toy is assigned a **happiness value**. When a pet plays with a particular **toy**, its **happiness level** increases by the **happiness value** of the toy. For example, if a pet with a **happiness level** of **30** plays with a **Stick** with a **happinessValue** of **10**, its **happiness level** will increase to **40**.

*A pet cannot be overfed or overplayed with.*

The user is also able to filter their pets based on their **energy levels** and **happiness levels**, checking which pets may soon die. 

The game ends when the pets **happiness level** or **energy level** reaches **0**.

Below is a description of all models available, along with the Class Diagram and Entity Relationship Diagram.

### Users
A User object contains a unique id, a name, an email, a list of pets. A user has a one-to-many relationship with the pets. A specific user and pet can be accessed directly with a GET request, described in the "How to use the API" section of this ReadMe.

### Pets
Pets have an id, a name, energyLevel, happinessLevel and a user asscoiated with that pet. The pets have a many-to-many relationship with both the foods and the toys. As the logic of the game and specifically, the survival of a pet is based on energyLevel and happinessLevel, the pets can be filtered by these two parameters in the GET request.

### Food
Foods have an id, a name, nutritionalValue and a list of pets. The nutritionalValue determines the energyLevel of the pet.

### Toys
Toys have an id, a name, happinessValue and a list of pets. The happinessValue determines the happinessLevel of the pet.

### DTOs
The DTOs are very similar to the POJOs above but they enable data transfer with HTTP requests. Their main difference to the POJOs are that they do not take in the primary keys (IDs) and instead of a list, they take in ids associated with the list i.e. pet IDs instead of list of pets.
 
### Class Diagram



### Entity Relationship Diagram
![FinalERD](https://github.com/RNWalker/BackEndProjectGroup4/assets/78052216/04b5ea68-b412-44f4-a916-5c7d0a822108)


-------------

## Tech Stack

The technologies used for this project are:
- Intellij IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman


-------------


## How to use the API

### RESTful route endpoints

##### To access the endpoints of the program, use `https://localhost:{port}/{endpoint}` - the default port is 8080 but any can be used

For every model, User, Pet, Food and Toy they each have REST controllers that provide basic CRUD functionality, with all models having Index, Show, Create, Update, and Delete routes, with the Pet model having extra functionality enabling to play and feed the pet.

- INDEX
  - `GET https://localhost:8080/pets` returns all pets in JSON format.
  - The pet model specifically also has a filter to look for happiness and energy level less than a integer value.

- SHOW
  - `GET https://localhost:8080/pets/{id}` returns the pet with unique id = {id}.

- CREATE
  - `POST https://localhost:8080/pets` creates a pet with a unique id, and returns all pets, including the new created pet. Attributes of this new pet must be sent in JSON format in the request body in Postman.
  - Attributes that must be sent to create a new pet include; name, species and userId.

- UPDATE
  - `PATCH https://localhost:8080/pets/{id}` updates the pet with unique id = {id}, and returns the updated pet. All attributes of the pet that is being updated, changed or not, should be sent in JSON format in the request body in Postman. 
  - Attributes that must be sent to update a pet include; name, species, userId,happinessLevel, energyLevel, toyIds and foodIds. With toyIds and foodIds both being lists.

- DELETE
  - `DELETE https://localhost:8080/pets/{id}` deletes the pet with unique id = {id}.Once the pet has been deleted, all remaining pets are returned.
  
- PLAY
  - `PATCH https://localhost:8080/pets/{id}/play?toyId={toyId}` Will play with the pet that has the unique id = {id}.
  - Returns the pet, with the toy that has just been played with removed.
  - Specifically for Pet model.

- FEED
  - `PATCH https://localhost:8080/pets/{id}/feed?foodId={foodId}` Will feed the pet that has the unique id = {id}.
  - Returns the pet, with the food that it has just been fed with removed.
  - Specifically for Pet model. 

### Filters and Sort

The pet service contains a filter that allows the user to narrow their search.

- FILTER
  - /pets?happinessLevel=45 & energyLevel = 45 : returns pets with happiness and energy levels that are 45 or below
  - no other filters currently supported
  
 
- SORT
  - /users/id{number} : returns user of a specific Id
  - /toys/id{number}  : returns toy of a specific Id
  - /food/id{number}  : returns food of a specific Id
  - /pet/id{number}   : returns pet of a specific Id
    
    
----------------

## Dependancies
- Spring Web
- SpringBoot Devtools
- Spring Data JPA
- H2 Database
- JUnit Jupiter
- AssertJ Core

----------------

## Collaborators
- Rebecca Walker
- Sarah O'Connor
- Charlotte Gould
- James Sode
- Zaiyad Zakaria
