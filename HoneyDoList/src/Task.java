import java.time.LocalDateTime;

public class Task {
    private String name;
    private int priority;
    private int estMinsToComplete;
    private LocalDateTime due;

    public Task(String n, int p, int est,LocalDateTime d) {
        this.name = n;
        this.priority = p;
        this.estMinsToComplete = est;
        this.due = d;
    }
    public Task(String n, int p, LocalDateTime due){
        this.name = n;
        this.priority = p;
        this.due = due;
    }

    //accessor for name
    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getEstMinsToComplete() {
        return this.estMinsToComplete;
    }

    //mutators
    public void setName(String newName) {
        this.name = newName;
    }

    public void setTime(int newTime) {
        this.estMinsToComplete = newTime;
    }

    public void increasePriority(int amount) {
        if (amount > 0)
            this.priority = amount;
    }

    public void decreasePriority(int amount) {
        int x;
        x = this.priority - amount;
        if (x > this.priority) {
            this.priority = x;
        }
        if (x < 0) {
            this.priority = 0;
        }
    }

    //extra credit
    public LocalDateTime getDue(){
        return due;
    }

    public void setDue(LocalDateTime dueSet){
        this.due = dueSet;
    }

    public boolean overdue(){
        if(LocalDateTime.now().compareTo(this.due) > 0){
            return true;
        }
        return false;
    }

    //toString
    public String toString() {
        return "Your task is " + name + ", its priority is " + priority + " and you have " + estMinsToComplete + " minutes to complete your task. It is due " + due;
    }
}

/* class HoneyDoList {
    private Task[] tasks;
    private int numTask;
    private final int INITIAL_CAPACITY = 0;
    //constructor
    public HoneyDoList() {
        tasks = new Task[INITIAL_CAPACITY];
        numTask = 0;
    }
    //toString
    public String toString() {
        String string = "";
        if (numTask == 0) {
            return null;
        } else {
            for (int i = 0; i < numTask; i++) {
                string += tasks[i];
            }
        }
        return string;
    }
    //Task Finder
    public int find(String name){
        for(int i = 0; i < numTask; i++){
            if(name.equalsIgnoreCase(tasks[i].getName())){

            }
        }
        return -1;
    }
    //Adding Task
    public void addTask(Task t){
        if(tasks.length == numTask){
            Task[] tempTask = new Task[numTask + 1];
            tempTask = tasks;
            tempTask = new Task[numTask + 1];
            tasks = tempTask;
        }else{
            tasks[numTask] = t;
            numTask++;
        }
    }
    //Total Time
    public int totalTime(){
        int tot = 0;
        for(int i = 0; i < numTask; i++){
            tot += tasks[i].getEstMinsToComplete();
        }
        return tot;
    }
    //shortest time
    public int shortestTime(){
        int shortest = 0;
        if(numTask == 0){
            return -1;
        }else{
            for(int i = 0; i < numTask; i++){
                if(shortest > tasks[i].getEstMinsToComplete()){
                    shortest = tasks[i].getEstMinsToComplete();
                }
            }
        }
        return shortest;
    }
    //remove completed
    public Task completeTask(int index){
        Task t = tasks[index];
        if(index < 0 && index > numTask){
            return null;
        }else{
            for(int i = index; i < numTask - 1; i++){
                tasks[i] = tasks[i-1];
            }
        }
        return t;
    }
    //overdue
    public Task[] overdueTask() {
        Task[] t = new Task[tasks.length];
        int i = 0;
        for (int j = 0; j < numTask; j++) {
            if (tasks[j].overdue() == true) {
                t[i++] = tasks[j];
            }
        }
        return t;
    }

 */
    //main
  /*  public class HoneyDo{
        public void main(String[] args){
            HoneyDoList honeyDo = new HoneyDoList();
            System.out.println(honeyDo);
            honeyDo.addTask(new Task("Wash the dishes", 10, LocalDateTime.of(2020,11,16,8,0),200));
            System.out.println(honeyDo);
            System.out.println("The index of the shortest time = " + honeyDo.shortestTime());
        }
    }
}

   */