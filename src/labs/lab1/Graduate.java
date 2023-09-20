package labs.lab1;

class Graduate extends Student {

    public Graduate(int ID, double GPA) {
        super(ID, GPA);
    }

    @Override
    public String getStatus() {
        if (GPA >= 3.0) {
            return "Good";
        } else {
            return "Probation";
        }
    }
}
