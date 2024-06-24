// Author: Ali Kaddoura
import org.junit.jupiter.api.Test;

public class TestChain {

    @Test
    void testApprovers() {
        Approver erin = new Director("Erin");
        Approver chris = new VicePresident("Chris");
        Approver casey = new President("Casey");
        erin.setSuccessor(chris);
        chris.setSuccessor(casey);

        // Generate and process four different requests.
        PurchaseRequest supplies = new PurchaseRequest("Supplies", 350.00);
        erin.processReq(supplies);

        PurchaseRequest car = new PurchaseRequest("Car", 10001.00);
        erin.processReq(car);

        PurchaseRequest research = new PurchaseRequest("Research", 32590.10);
        erin.processReq(research);

        PurchaseRequest building = new PurchaseRequest("Building", 122100);
        erin.processReq(building);
    }
}

class PurchaseRequest {
    private String item;
    private double amount;

    public PurchaseRequest(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }
}

abstract class Approver {
    protected Approver successor;

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processReq(PurchaseRequest request);
}

class Director extends Approver {
    private String name;

    public Director(String name) {
        this.name = name;
    }

    @Override
    public void processReq(PurchaseRequest request) {
    	double currentAmount = request.getAmount();
        if (currentAmount<= 1000) {
            System.out.println("Director " + name + " approved " + request.getItem());
        } else if (successor != null) {
            successor.processReq(request);
        } else {
            System.out.println("No successor");
        }
    }
}

class VicePresident extends Approver {
    private String name;

    public VicePresident(String name) {
        this.name = name;
    }

    @Override
    public void processReq(PurchaseRequest request) {
        if (request.getAmount() <= 20000) {
            System.out.println("Vice President " + name + " approved " + request.getItem());
        } else if (successor != null) {
            successor.processReq(request);
        } else {
            System.out.println("No successor");
        }
    }
}


class President extends Approver {
    private String name;

    public President(String name) {
        this.name = name;
    }

    @Override
    public void processReq(PurchaseRequest request) {
    	double currentAmount = request.getAmount();
        if (currentAmount<= 100000) {
            System.out.println("President " + name + " approved " + request.getItem());
        } else if (successor != null) {
            successor.processReq(request);
        } else {
            System.out.println("No successor");
        }
    }
}