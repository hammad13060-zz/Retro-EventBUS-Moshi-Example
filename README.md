# Retro-EventBUS-Moshi-Example

A sample android client demonstrating usage of Retrofit, EventBUS, MoshiConverter. json-server has been used for quick backend.

## [License](https://github.com/hammad13060/Retro-EventBUS-Moshi-Example/blob/master/LICENSE)

# Libraries

### [Retrofit](http://square.github.io/retrofit/)
- A type-safe HTTP client for Android and Java

### [EventBUS](http://greenrobot.org/eventbus/)
- EventBus is publish/subscribe event bus optimized for Android
  
### MoshiConvertor
- convertor for de-serializing HTTP request/response bodies
  
### [lombok](https://projectlombok.org/)
- for generating getters and setters using annotations
- used [this](http://stackoverflow.com/questions/21344692/how-to-set-up-compile-library-in-android-studio-lombok) link to configure it
  
# Usage

## Android Client
1. clone the repo
2. import the android client project into the android studio
3. change the ip address for SERVER_URL variable in UsersService.java to that of the machine on which you will run json-server
  - consider `public static final String SERVER_URL = "http://192.168.0.8:3000/users/";`
  - replace `192.168.0.8` with your ip address
4.  install lombok plugin for android studio
5. Build the project. Run.

## JSON server
1. install [node.js](https://nodejs.org/en/)
2. install [json-server](https://github.com/typicode/json-server) using following command
  - `npm install -g json-server`
3. cd into cloned OkHTTPExample directory
4. type the following command
  - `json-server --watch db.json`
    OR
  - `sudo json-server --watch db.json` in case access is denied
5. Your are good to go now
6. Play with client
