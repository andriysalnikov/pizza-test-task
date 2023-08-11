# Pizza Test Task
### Description
This application is the *Test task* for the position of **Junior Java Spring Developer**

## Features to do
The application needs to be made as a server on the following technologies:
- Java 8
- Spring (Boot, Web, Data, Thymeleaf)
- Apache Maven
- In-memory database (H2)

We have a database. In the database there is a relationship *many-to-many* between `Order` and `Meal`.

`Order` has the following fields: `id`, `start_date`, `start_time`, `end_date`, `end_time`,`status` (*enum*).

`Meal` has the following fields: `id`, `name`, `description`.

## How to run this application
- Clone or download repository
- Run `PizzaApplication.main`. The database will be automatically raised into memory
  and initialized with the initial values

## How it works
We have two pages:
- http://localhost:10010/user - here *User* can create and cancel orders
- http://localhost:10010/performer - here *Performer* can do and cancel orders

*User* and *Performer* pages automatically update every 1 second