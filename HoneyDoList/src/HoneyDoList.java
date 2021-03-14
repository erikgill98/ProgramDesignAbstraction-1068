class HoneyDoList {
    private Task[] tasks;
    private int numTask;
    private final int INITIAL_CAPACITY = 10;

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
                string += tasks[i] + "\n";
            }
        }
        return string;
    }

    //Task Finder
    public int find(String name) {
        for(int i = 0; i < numTask; i++) {
            if(name.equalsIgnoreCase(tasks[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    //Adding Task
    public void addTask(Task t) {
        if (tasks.length == numTask) {
            Task[] tempTask = new Task[numTask + 1];
            tempTask = tasks;
            tempTask = new Task[numTask + 1];
            tasks = tempTask;
        } else {
            tasks[numTask] = t;
            numTask++;
        }
    }

    //Total Time
    public int totalTime() {
        int tot = 0;
        for (int i = 0; i < numTask; i++) {
            tot += tasks[i].getEstMinsToComplete();
        }
        return tot;
    }

    //shortest time
    public int shortestTime() {
        int shortest = 0;
        if (numTask == 0) {
            return -1;
        } else {
            for (int i = 0; i < numTask; i++) {
                if (shortest > tasks[i].getEstMinsToComplete()) {
                    shortest = tasks[i].getEstMinsToComplete();
                }
            }
        }
        return shortest;
    }

    //remove completed
    public Task completeTask(int index) {
        Task t = tasks[index];
        if (index < 0 && index > numTask) {
            return null;
        } else {
            for (int i = index; i < numTask - 1; i++) {
                tasks[i] = tasks[i - 1];
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
}