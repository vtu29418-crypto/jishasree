import java.util.Scanner;

// Interface
interface Payment {
    void pay(double amount);
}

// Credit Card Payment
class CreditCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Credit Card payment: " + amount);
    }
}

// UPI Payment
class UPIPayment implements Payment {

    public void pay(double amount) {
        System.out.println("UPI payment: " + amount);
    }
}

// Net Banking Payment
class NetBankingPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Net Banking payment: " + amount);
    }
}

// Abstract class
abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

// Concrete class
class OnlinePaymentProcessor extends PaymentProcessor {

    @Override
    double processPayment(Payment payment, double amount) {

        double fee = 0;

        if (payment instanceof CreditCardPayment) {
            fee = amount * 0.02;
        }
        else if (payment instanceof UPIPayment) {
            fee = amount * 0.01;
        }
        else if (payment instanceof NetBankingPayment) {
            fee = amount * 0.015;
        }

        return amount + fee;
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < N; i++) {

            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String paymentName;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
                paymentName = "CreditCard";
            }
            else if (paymentType == 2) {
                payment = new UPIPayment();
                paymentName = "UPI";
            }
            else {
                payment = new NetBankingPayment();
                paymentName = "NetBanking";
            }

            double finalAmount =
                    processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n",
                    paymentName, finalAmount);
        }

        sc.close();
    }
}