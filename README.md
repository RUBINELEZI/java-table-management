# java-table-management

This is a simple java fx desktop app created by Rubin Elezi (me). It was originally created as a school project and it is not suitable for commercial use.

## Installation

Download the zip file or clone the project. It was built with IntelliJ. All you need to do is change the CONNECTION_STRING variable at the databaseHandler class based on where you locate your file.

```bash
public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\User\\Desktop\\java-table-management\\src\\sample\\database\\" + DB_NAME;
```

## Usage
When you run the app to make a reservation you first need to define a date at the date picker. If on a given date there are existing reservations you cant add a new one. If you set the date for example 4/23/2020 you would see that 4 tables are reserved and on the reservation tab on the top, you can see all the reservations, search and delete them.




## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

