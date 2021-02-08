/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author gulyas
 */
public class Employee {
    private String firstName, lastName;
    private String job;
    private int salary;

    public Employee(String firstName, String lastName, String job, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }
    
    public void raiseSalary(int percent){
        salary = (int)(salary*(1.0 + percent / 100.0));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + job + ") fizetése: " + salary;
    }

    
    /**
     * @param args the command line arguments
     */
    
    
    private static String readString(Scanner sc, String msg){
        System.out.print(msg);
        String data = sc.next();
        return data;
    }
    
    private static int readInt(Scanner sc, String msg){
        System.out.print(msg);
        int data = sc.nextInt();
        sc.nextLine();
        return data;
    }
    
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in, "ISO-8859-1");    
        ArrayList<Employee> employees = new ArrayList<>();
        
        for(int i=0; i<3; ++i){ 
            employees.add(readEmployee(sc));
        }
        
        int raise = readInt(sc, "Emelés mértéke(%) = ");
        String job = readString(sc, "Érintett beosztás");
        
        for(Employee e : employees){
            if(e.getJob().equals(job)) e.raiseSalary(raise);
            System.out.println(e);
        }
        
        Employee richMan = employees.get(0);
        for(Employee e : employees){
            if(e.getSalary() > richMan.getSalary()){
                richMan = e;
            }
        }
        System.out.println("Legnagyobb fizetésű beosztott: " + richMan);
    }

    private static Employee readEmployee(Scanner sc) {
        String firstName = readString(sc ,"Vezetéknév: ");
        String lastName = readString(sc ,"Keresztnév: ");
        String job = readString(sc ,"Beosztás: ");
        int salary = readInt(sc ,"Fizetés: ");
        Employee e = new Employee(firstName, lastName, job, salary);
        return e;
    }
    
}
