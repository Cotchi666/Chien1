
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StudentTest {
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        
        int choose;
        
        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            switch(choose) {
                case 1:
                    inputStudent(studentList);
                    break;
                case 2:
                    displayStudent(studentList);
                    break;
                case 3:
                    showMinMax(studentList);
                    break;
                case 4:
                    searchStudent(studentList);
                    break;
                case 5:
                    displaySortByName(studentList);
                    break;
                case 6:
                    displayByCerfiticate(studentList);
                    break;
                case 7:
                    System.out.println("Thoat!!!");
                    break;
                default:
                    System.out.println("Nhap lai!!!");
                    break;
            }
        } while(choose != 7);
    }
    
    static void showMenu() {
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Hien thi thong tin sinh vien");
        System.out.println("3. Sinh vien diem cao nhat va thap nhat");
        System.out.println("4. Tim kiem theo ma sinh vien");
        System.out.println("5. Hien thi theo ten A-Z");
        System.out.println("6. Hien thi sinh vien duoc hoc bong (cao -> thap)");
        System.out.println("7. Thoat");
        System.out.println("Chon: ");
    }

    static void inputStudent(ArrayList<Student> studentList) {
        System.out.println("Nhap so sinh vien can them: ");
        int n = Integer.parseInt(scan.nextLine());
        
        for (int i = 0; i < n; i++) {
            Student std = new Student();
            std.input();
            
            studentList.add(std);
        }
    }

    static void displayStudent(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            student.display();
        }
    }

    static void showMinMax(ArrayList<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getMark() > o2.getMark()) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.println("Thong tin sinh vien diem trung binh thap nhat");
        studentList.get(0).display();
        System.out.println("Thong tin sinh vien diem trung binh cao nhat");
        studentList.get(studentList.size() - 1).display();
    }

    static void searchStudent(ArrayList<Student> studentList) {
        System.out.println("Nhap MSV can tim: ");
        String rollnoSearch = scan.nextLine();
        
        boolean isFind = false;
        for (Student student : studentList) {
            if(student.getRollno().equalsIgnoreCase(rollnoSearch)) {
                student.display();
                isFind = true;
                break;
            }
        }
        if(!isFind) {
            System.out.println("Khong tim thay sinh vien vs rollno = " + rollnoSearch);
        }
    }

    static void displaySortByName(ArrayList<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullname().compareToIgnoreCase(o2.getFullname());
            }
            
        });
        
        displayStudent(studentList);
    }

    static void displayByCerfiticate(ArrayList<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getMark() > o2.getMark()) {
                    return -1;
                }
                return 1;
            }
            
        });
        for (Student student : studentList) {
            if(student.checkCerfiticate()) {
                student.display();
            } else {
                break;
            }
        }
    }
}
