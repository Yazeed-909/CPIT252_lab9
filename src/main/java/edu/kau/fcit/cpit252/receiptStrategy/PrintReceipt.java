package edu.kau.fcit.cpit252.receiptStrategy;

import edu.kau.fcit.cpit252.paymentsStrategy.Payment;
import edu.kau.fcit.cpit252.shopping.Product;

import java.util.List;

public class PrintReceipt extends Receipt{

   

    public PrintReceipt(String subject, List<Product> products) {
        super(subject, products);
    }

 
    @Override
    public void generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t\t" + this.subject + "\n");
        sb.append("-----------\t\t\t --------------\n");
        sb.append("Item\t\t\t\t Price\n");
        sb.append("-----------\t\t\t --------------\n");
        double total = 0;
        for (Product p : this.getProducts()) {

            sb.append("\t" + p.getName() + "\t\t\t" + p.getPrice() + "\n");
            total += p.getPrice();
        }
        sb.append("\t\t\t\t\t Total:\t" + total);
        System.out.println(sb.toString());
    }
}
