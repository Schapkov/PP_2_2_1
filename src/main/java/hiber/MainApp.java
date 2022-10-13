package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

       User user1 = new User("Name1", "Lastname1", "name1@mail.ru");
       User user2 = new User("Name2", "Lastname2", "name2@mail.ru");
       User user3 = new User("Name3", "Lastname3", "name3@mail.ru");
       User user4 = new User("Name4", "Lastname4", "name4@mail.ru");

       Car car1 = new Car(209, "car1");
       Car car2 = new Car(222, "car2");
       Car car3 = new Car(201, "car3");
       Car car4 = new Car(202, "car4");

       userService.add(user1.setUserCar(car1).setCarUser(user1));
       userService.add(user2.setUserCar(car2).setCarUser(user2));
       userService.add(user3.setUserCar(car3).setCarUser(user3));
       userService.add(user4.setUserCar(car4).setCarUser(user4));

         
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + "\n" + user.getUserCar());
         System.out.println();

      }

       System.out.println(userService.getUserByCar(202, "car4"));

      context.close();
   }
}
