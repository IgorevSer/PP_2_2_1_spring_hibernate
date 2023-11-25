package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Bmw", 5)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Audi", 7)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Toyota", 10)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Volvo", 8)));


      List<User> users = userService.listUsers();
      users.forEach(System.out::println);
      System.out.println();


      System.out.println("Доставать юзера, владеющего машиной: Audi 7 ");
      System.out.println(userService.getUserByCar("Audi", 7));
      context.close();
   }
}
