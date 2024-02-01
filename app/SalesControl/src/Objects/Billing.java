package Objects;

import java.io.IOException;

public interface Billing {
    void addBill(Bill factura);
    void cancelBill(Bill factura);
    double obtainTotalIncome();
    Bill checkBill(String descripcion);
    void saveBills() throws IOException;
    void loadBills() throws IOException, ClassNotFoundException;
    
}
