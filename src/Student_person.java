public class Student_person extends Person {
    private String major;
    public Student_person(String name,String major){
        super(name);
        this.major=major;
    }
    public String getDescription(){
        return "a student majoring in "+major;
    }
}
