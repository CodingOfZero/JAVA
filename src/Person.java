public abstract class Person {//抽象类
    public abstract String getDescription();
    private String name;
    public Person(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
