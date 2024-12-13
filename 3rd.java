import java.util.Scanner;

public class Main { // Change class name to Main
    public static void main(String[] args) {
        int choice, cont;
        Scanner c = new Scanner(System.in); // Single Scanner instance

        do {
            System.out.println("\nPAYROLL");
            System.out.print("1. Programmer\n2. Assistant Professor\n3. Associate Professor\n4. Professor\n");
            System.out.println("Enter your choice:");
            choice = c.nextInt();

            switch (choice) {
                case 1:
                    Programmer p = new Programmer();
                    p.getData();
                    p.getBasicPay();
                    p.display();
                    p.Calculate();
                    break;
                case 2:
                    AssistantProfessor asst = new AssistantProfessor();
                    asst.getData();
                    asst.getBasicPay();
                    asst.display();
                    asst.Calculate();
                    break;
                case 3:
                    AssociateProfessor asso = new AssociateProfessor();
                    asso.getData();
                    asso.getBasicPay();
                    asso.display();
                    asso.Calculate();
                    break;
                case 4:
                    Professor prof = new Professor();
                    prof.getData();
                    prof.getBasicPay();
                    prof.display();
                    prof.Calculate();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

            System.out.println("Enter 0 to quit and 1 to continue:");
            cont = c.nextInt();
        } while (cont == 1);

        c.close(); // Close Scanner
    }
}

// Employee class
class Employee {
    int empid;
    long mobile;
    String name, address, mailid;

    Scanner g = new Scanner(System.in);

    void getData() {
        System.out.println("Enter Name of the Employee:");
        name = g.nextLine();
        System.out.println("Enter Mail ID:");
        mailid = g.nextLine();
        System.out.println("Enter Address of the Employee:");
        address = g.nextLine();
        System.out.println("Enter the Employee ID:");
        empid = g.nextInt();
        System.out.println("Enter Mobile Number:");
        mobile = g.nextLong();
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empid);
        System.out.println("Mail ID: " + mailid);
        System.out.println("Address: " + address);
        System.out.println("Mobile Number: " + mobile);
    }
}

// Professor class
class Professor extends Employee {
    double bp, da, hra, pf, club, net, gross;

    void getBasicPay() {
        System.out.println("Enter basic pay:");
        bp = g.nextDouble();
    }

    void Calculate() {
        da = 0.97 * bp;
        hra = 0.10 * bp;
        pf = 0.12 * bp;
        club = 0.001 * bp; // Fixed club percentage
        gross = bp + da + hra;
        net = gross - pf - club;

        System.out.println("\nPAY SLIP FOR PROFESSOR\n");
        System.out.println("Basic Pay: Rs. " + bp);
        System.out.println("DA: Rs. " + da);
        System.out.println("HRA: Rs. " + hra);
        System.out.println("PF: Rs. " + pf);
        System.out.println("CLUB: Rs. " + club);
        System.out.println("GROSS PAY: Rs. " + gross);
        System.out.println("NET PAY: Rs. " + net);
    }
}

// Programmer class
class Programmer extends Employee {
    double bp, da, hra, pf, club, net, gross;

    void getBasicPay() {
        System.out.println("Enter basic pay:");
        bp = g.nextDouble();
    }

    void Calculate() {
        da = 0.97 * bp;
        hra = 0.10 * bp;
        pf = 0.12 * bp;
        club = 0.001 * bp; // Fixed club percentage
        gross = bp + da + hra;
        net = gross - pf - club;

        System.out.println("\nPAY SLIP FOR PROGRAMMER\n");
        System.out.println("Basic Pay: Rs. " + bp);
        System.out.println("DA: Rs. " + da);
        System.out.println("HRA: Rs. " + hra);
        System.out.println("PF: Rs. " + pf);
        System.out.println("CLUB: Rs. " + club);
        System.out.println("GROSS PAY: Rs. " + gross);
        System.out.println("NET PAY: Rs. " + net);
    }
}

// AssistantProfessor class
class AssistantProfessor extends Employee {
    double bp, da, hra, pf, club, net, gross;

    void getBasicPay() {
        System.out.println("Enter basic pay:");
        bp = g.nextDouble();
    }

    void Calculate() {
        da = 0.97 * bp;
        hra = 0.10 * bp;
        pf = 0.12 * bp;
        club = 0.001 * bp; // Fixed club percentage
        gross = bp + da + hra;
        net = gross - pf - club;

        System.out.println("\nPAY SLIP FOR ASSISTANT PROFESSOR\n");
        System.out.println("Basic Pay: Rs. " + bp);
        System.out.println("DA: Rs. " + da);
        System.out.println("HRA: Rs. " + hra);
        System.out.println("PF: Rs. " + pf);
        System.out.println("CLUB: Rs. " + club);
        System.out.println("GROSS PAY: Rs. " + gross);
        System.out.println("NET PAY: Rs. " + net);
    }
}

// AssociateProfessor class
class AssociateProfessor extends Employee {
    double bp, da, hra, pf, club, net, gross;

    void getBasicPay() {
        System.out.println("Enter basic pay:");
        bp = g.nextDouble();
    }

    void Calculate() {
        da = 0.97 * bp;
        hra = 0.10 * bp;
        pf = 0.12 * bp;
        club = 0.001 * bp; // Fixed club percentage
        gross = bp + da + hra;
        net = gross - pf - club;

        System.out.println("\nPAY SLIP FOR ASSOCIATE PROFESSOR\n");
        System.out.println("Basic Pay: Rs. " + bp);
        System.out.println("DA: Rs. " + da);
        System.out.println("HRA: Rs. " + hra);
        System.out.println("PF: Rs. " + pf);
        System.out.println("CLUB: Rs. " + club);
        System.out.println("GROSS PAY: Rs. " + gross);
        System.out.println("NET PAY: Rs. " + net);
    }
}