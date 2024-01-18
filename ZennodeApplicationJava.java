import java.util.Scanner;

public class ZennodeApplicationJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtyA,qtyB,qtyC;
        String giftA="no",giftB="no",giftC="no";

            System.out.println("Product A:$20");
            System.out.println("Product B:$40");
            System.out.println("Product C:$50");
            System.out.println("--------------------------------------------------");

            System.out.println("Enter quantity of Product A:"); 
            qtyA = sc.nextInt();
            if (qtyA!=0) {
                System.out.println("Should product be gift wrapped? yes/no:");
                giftA=sc.next();
            }
            System.out.println("Enter quantity of Product B:"); 
            qtyB = sc.nextInt();
            if (qtyB!=0) {
                System.out.println("Should product be gift wrapped? yes/no:");
                giftB=sc.next();
            }
            System.out.println("Enter quantity of Product C:"); 
            qtyC = sc.nextInt();
            if (qtyC!=0) {
                System.out.println("Should product be gift wrapped? yes/no:");
                giftC=sc.next();
            }

            // Calculate subtotal
            int subtotal = qtyA*20 + qtyB*40 + qtyC*50;

        
            
            double discount = 0;
            String discountName = "";

            //flat_10_discount
            if (subtotal > 200) {
                discount = 10.0;
                discountName = "flat_10_discount";
            }

           //bulk_5_discount
            if (qtyA > 10 || qtyB > 10 || qtyC > 10) {
            double tempDiscount = 0.0;
            if (qtyA > 10) {
                tempDiscount = 0.05 * qtyA * 20;
            }
            if (qtyB > 10) {
                tempDiscount = 0.05 * qtyB * 40;
            }
            if (qtyC > 10) {
                tempDiscount = 0.05 * qtyC * 50;
            }
            if (tempDiscount > discount) {
                discount = tempDiscount;
                discountName = "bulk_5_discount";
            }
        }

            //bulk_10_discount
            if (qtyA + qtyB + qtyC > 20) {
                double tempDiscount = 0.1 * subtotal;
                if (tempDiscount > discount) {
                    discount = tempDiscount;
                    discountName = "bulk_10_discount";
                }
            }

            //tiered_50_discount
            if (qtyA + qtyB + qtyC > 30 && (qtyA > 15 || qtyB > 15 || qtyC > 15)) {
            double tempDiscount = 0.0;
            if (qtyA > 15) {
                tempDiscount = 0.5 * (qtyA - 15) * 20;
            }
            if (qtyB > 15) {
                tempDiscount = 0.5 * (qtyB - 15) * 40;
            }
            if (qtyC > 15) {
                tempDiscount = 0.5 * (qtyC - 15) * 50;
            }
            if (tempDiscount > discount) {
                discount = tempDiscount;
                discountName = "tiered_50_discount";
            }
        }

            // Calculate fees
            int shippingFee;
            if(qtyA+qtyB+qtyC%10 == 0){
                shippingFee = (qtyA+qtyB+qtyC)/10 * 5;
            }
            else
            shippingFee = ((qtyA+qtyB+qtyC)/10 + 1) * 5;


            int giftWrapFee = 0;
            if(giftA.equals("yes")){
                giftWrapFee += qtyA*1;
            }
            if (giftB.equals("yes")) {
                giftWrapFee += qtyB*1;
                
            }
            if (giftC.equals("yes")) {
                giftWrapFee += qtyC*1;
            }


            // Calculate total
            double total = subtotal - discount + shippingFee + giftWrapFee;

            // Print details
            System.out.println("--------------------------------------------------");
            System.out.println("Order details:");
            System.out.println("--------------------------------------------------");
            System.out.printf("%-12s %-10s %-5s\n", "Product Name", "Quantity", "Total");
            System.out.printf("%-12s %-10d $%-5d\n", "Product A", qtyA, qtyA*20);
            System.out.printf("%-12s %-10d $%-5d\n", "Product B", qtyB, qtyB*40);
            System.out.printf("%-12s %-10d $%-5d\n", "Product C", qtyC, qtyC*50);

            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Discount (" + discountName + "): -$" + discount);
            System.out.println("Shipping fee: $" + shippingFee);
            System.out.println("Gift wrap fee: $" + giftWrapFee);
            System.out.println("Total: $" + total);

            sc.close();   
    }
}