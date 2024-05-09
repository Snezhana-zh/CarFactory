public abstract class Task {
    private final String name;
    public Task(String n) {
        name = n;
    }
    public String getTaskName() {
        return name;
    }
    public abstract void perform() throws InterruptedException;
    public abstract void setDelay(int d);
}
