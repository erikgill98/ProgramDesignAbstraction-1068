import java.time.LocalDateTime;

public class HoneyDoMain {
    public static void main(String args[]){
        HoneyDoList hDo = new HoneyDoList();
        System.out.println(hDo);
        hDo.addTask(new Task("Wash Dishes", 5, LocalDateTime.of(2020,10,16,10,0)));
        System.out.println(hDo);
        System.out.println("Shortest Time is " + hDo.shortestTime());

    }
}
