package labs.lab1;

abstract class Student {
    int ID;
    double GPA;

    public Student(int ID, double GPA) {
        this.ID = ID;
        this.GPA = GPA;
    }

    public abstract String getStatus();

    public final String displayStudent() {
        return "ID: " + ID + ", GPA: " + Math.floor(GPA*100)/100 + ", Status: " + getStatus();
    }
}

