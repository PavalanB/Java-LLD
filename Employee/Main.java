package LLD.Employee;

class Employee{
    private String name;
    private int id;
    private int salary;
    void setName(String name){
        this.name=name;
    }
    void setId(int id){
        if(id<=0){
            System.out.println("Cannot assign a negative value for id");
        }else{
            this.id=id;
        }
    }
    void setSalary(int salary){
        if(salary<=0){
            System.out.println("Cannot assign a negative value for salary");
        }else{
            this.salary=salary;
        }
    }
    String getName(){
        return name;
    }
    int getId(){
        return id;
    }
    int getSalary(){
        return salary;
    }
    Employee(String name,int id,int salary){
        setName(name);
        setId(id);
        setSalary(salary);
    }
    void display(){
        System.out.println("Employee Name :"+name);
        System.out.println("Employee ID :"+id);
        System.out.println("Employee Salary :"+salary);
    }
    int calculateBonus(){
        return salary/10;
    }
}

interface Workable{
    void display();
    int calculateBonus();
}

class Developer extends Employee implements Workable{
    String programmingLanguage;
    Developer(String name,int id,int salary,String programmingLanguage){
        super(name,id,salary);
        this.programmingLanguage=programmingLanguage;
    }
    @Override 
    public void display(){
        super.display();
        System.out.println("Employee Programming Langugage :"+programmingLanguage);
    }
    @Override 
    public int calculateBonus(){
        int salary=getSalary();
        return salary/15;
    }
}

class Manager extends Employee implements Workable{
    int teamSize;
    Manager(String name,int id,int salary,int teamSize){
        super(name,id,salary);
        this.teamSize=teamSize;
    }
    @Override 
    public void display(){
        super.display();
        System.out.println("Team Size :"+teamSize);
    }
    @Override 
    public int calculateBonus(){
        int salary=getSalary();
        return salary/20;
    }
}

class Main{
    public static void main(String[] args){
        Employee dev=new Developer("Prime",45,100000,"JAVA");
        Employee mgr=new Manager("Thaneha",2,100000,2);
        dev.display();
        mgr.display();
        int devSal=dev.calculateBonus();
        int mgrSal= mgr.calculateBonus();
        System.out.println("Developer Bonus: "+devSal);
        System.out.println("Manager Bonus: "+mgrSal);
    }
}