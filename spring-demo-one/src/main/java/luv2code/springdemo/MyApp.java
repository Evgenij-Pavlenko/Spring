package luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {

//        Coach theCoach = new BaseballCoach();
//        Coach theCoach = new TrackCoach();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        String dailyWorkout = theCoach.getDailyWorkout();

        System.out.println(dailyWorkout);
    }
}
