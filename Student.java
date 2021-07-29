
import java.util.Scanner;


public class Student extends People{
    String rollno, email;
    float mark;

    public Student() {
    }

    public Student(String rollno, String email, float mark, String fullname, String gender, String birthday, String address) {
        super(fullname, gender, birthday, address);
        this.rollno = rollno;
        this.email = email;
        this.mark = mark;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.contains("@")) {
            this.email = email;
            return true;
        } else {
            System.out.println("Sai format ...");
        }
        return false;
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if(mark >=0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.out.println("Yeu cau: mark >= 0 & mark <= 10");
        }
        return false;
    }

    @Override
    public void input() {
        super.input(); //To change body of generated methods, choose Tools | Templates.
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter rollno: ");
        rollno = scan.nextLine();
        
        System.out.println("Enter email: ");
        while(true) {
            String inputEmail = scan.nextLine();
            if(setEmail(inputEmail)) {
                break;
            }
            System.out.println("Enter email again!!!");
        }
        
        System.out.println("Enter mark: ");
        while(!setMark(Float.parseFloat(scan.nextLine()))) {
            System.out.println("Enter mail again!!!");
        }
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        System.out.printf(", rollno: %s, mark: %f, email: %s\n", rollno, mark, email);
    }
    
    public boolean checkCerfiticate() {
        return mark >= 8;
    }
}
