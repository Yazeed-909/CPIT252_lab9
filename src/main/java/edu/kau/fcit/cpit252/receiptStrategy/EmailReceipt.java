package edu.kau.fcit.cpit252.receiptStrategy;

import edu.kau.fcit.cpit252.paymentsStrategy.Payment;
import edu.kau.fcit.cpit252.shopping.Product;
import edu.kau.fcit.cpit252.utils.EmailTemplate;
import edu.kau.fcit.cpit252.utils.SendEmail;

import java.util.List;

public class EmailReceipt extends Receipt{
    private String recipient;

    public EmailReceipt(String subject , String recipient, List<Product> products) {
        super(subject, products);
        this.recipient = recipient;
    }

   


    @Override
    public void generate() {
        EmailTemplate template = new EmailTemplate();
        String message =  template.getEmailTemplate("Our Neighborhood Bakery", this.getId(), this.getIssueDate(),
                this.getProducts());
        try {
            SendEmail.send(this.subject, message, this.recipient);
//            System.out.println("Subject: " + this.subject);
//            System.out.println("Message: " + message);
//            System.out.println("Recipient: " + this.recipient);
        }
        catch(Exception e){
            System.err.println("Failed to email the receipt: Reason: " + e.getMessage());
            return;
        }

    }
}
