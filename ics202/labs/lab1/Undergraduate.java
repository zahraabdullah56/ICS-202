package labs.lab1;

class Undergraduate extends Student {

    public Undergraduate(int ID, double GPA) {
        super(ID, GPA);
    }

    @Override
    public String getStatus() {
        if (GPA >= 3.0) {
            return "Honor";
        } else if (GPA >= 2.0) {
            return "Good";
        } else {
            return "Probation";
        }
    }
}
