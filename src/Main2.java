import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        ArrayList<StaffMember> staff = new ArrayList<>();
        StaffMember emp = new Employee("michael", "2222", 32444.5, "235679765");
        StaffMember man = new Manager("dan", "3333", 3556, "2345235");
        ((Manager) man).addBonus(1500);
        StaffMember hw = new HourlyPayedEmployee("oleg", "4444", 2323, "2444566", 188);
        ((HourlyPayedEmployee) hw).addWorkHoures(10);
        StaffMember v = new Volunteer("zohar", "5555");
        staff.add(emp);
        staff.add(man);
        staff.add(hw);
        staff.add(v);
        //crate a file
        File monthlyPaymentFile = new File("C:\\Users\\micha\\IdeaProjects\\lab14\\MonthlyPayment.txt");
        try {
            if (monthlyPaymentFile.createNewFile()) {
                System.out.println("MonthlyPayment file created successfully.");
            } else {
                System.out.println("MonthlyPayment file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the MonthlyPayment file.");
            e.printStackTrace();
        }
        //use the method asked.
        staffMonthlyPayment(staff, "monthlyPaymentFile");


    }

    public static void staffMonthlyPayment(ArrayList<StaffMember> staff, String MonthlyPayment) throws IOException {
        Path filePath = Paths.get("MonthlyPayment.txt");
        String text="pay day for staff members\n " +
                "==========================\n" ;
        double totalpay = 0;
        for (StaffMember staffMember : staff) {
            text += staffMember.toString() + "\n";
            totalpay += staffMember.pay();
        }
        Files.write(filePath, text.getBytes());
        Files.writeString(filePath, "=================================" +
                "\n total payment: " + totalpay, StandardOpenOption.APPEND);
    }
}