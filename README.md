# Hero Service Project with Using Angular & Spring Boot

This project is just an exercise for using angularJS and spring boot and also combining them.
On angularJS side, angular hero service tutorial is used. [https://angular.io/guide/quickstart](https://angular.io/guide/quickstart)

AngularJS sending rest requests and spring boot is processing them and response them. In spring boot side, h2database is used for hero data. To check tables goto [http://localhost:8081/h2-console](http://localhost:8081/h2-console).
All database information is configured in application.properties fie.

## How to import project
### Spring boot side
import maven project into your ide. Then run the project and goto [http://localhost:8081](http://localhost:8081) address.

### Angular side
  * go to `src\main\angular-app`v and install angular cli
  ```
   npm install -g @angular/cli
   ```
  * then install npm modules
  ```
   npm install
   ```
  * now angular project is ready you can serve project with this command;
  ```
   ng serve --open
  ```
  
**How to deploy angular project into spring boot project**
  * go to `src\main\angular-app` and run below command;
  ```
   ng build
   ```
  * after build completed, dist folder will be created. Copy all file inside it into `src/main/resources/static` folder.
