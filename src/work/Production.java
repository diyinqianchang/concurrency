package work;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:43
 * @Version 1.0
 */
public class Production extends InstructionBook{

    private final int prodID;

    public Production(int prodID) {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute the "+ prodID +" first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the "+ prodID +" second process");
    }
}
