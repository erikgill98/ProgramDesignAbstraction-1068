import java.time.LocalDateTime;

public class TaskMain {
    public static void main(String args[]){
        Task t = new Task("Wash the dishes", 5,200,LocalDateTime.now());
        System.out.println(t.toString());
    }
}
