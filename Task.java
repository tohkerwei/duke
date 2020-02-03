public class Task {
    public String type;
    public String description;
    public String dateTime;
    public boolean isDone;

    public Task(String type, String description, String dateTime) {
        this.type = type;
        this.description = description;
        this.dateTime = dateTime;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString(){
        String result = "[" + getStatusIcon() + "] " + description;
        return result;
    }

}
