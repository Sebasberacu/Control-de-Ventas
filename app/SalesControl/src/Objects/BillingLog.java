package Objects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingLog implements Billing {
    private ArrayList<Bill> bills;
    private String fileRoute;

    public BillingLog() {
        this.bills = new ArrayList<>();
        this.fileRoute = "./Bills/bills.txt";
    }

    public ArrayList<Bill> getBills() {
        try { // Load bills to have them up to date
            loadBills();
        } catch (IOException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList <Bill> activeBills = new ArrayList<>();
        for (Bill bill : bills){
            if (bill.isActive()){
                activeBills.add(bill);
            }
        }
        return activeBills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public String getFileRoute() {
        return fileRoute;
    }

    public void setFileRoute(String fileRoute) {
        this.fileRoute = fileRoute;
    }

    @Override
    public void addBill(Bill bill) {
        this.bills.add(bill);
        try {
            saveBills(); // save it on file
        } catch (IOException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cancelBill(Bill bill) {
        bill.setState(false);
        try {
            saveBills();
        } catch (IOException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public double obtainTotalIncome() {
        try { // load bills
            loadBills();
        } catch (IOException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillingLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        double totalAmount = 0.0;
        for (Bill bill : bills) {
            if (bill.isActive()) {
                totalAmount += bill.getAmount();
            }
        }
        return totalAmount;
    }
    @Override
    public Bill checkBill(String description){
        for (Bill bill : bills){
            if (bill.getDescription().equals(description)){
                return bill;
            }
        }
        return null;
    }

    @Override
    public void saveBills() throws IOException {
        // Save in file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileRoute))) {
            oos.writeObject(bills);
        }
    }

    @Override
    public void loadBills() throws IOException, ClassNotFoundException {
        // Load file info
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileRoute))) {
            bills = (ArrayList<Bill>) ois.readObject();
        }
    }
}