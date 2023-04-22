package work;

/**
 * @Author Administrator
 * @Date 2022/8/14 11:41
 * @Version 1.0
 */
public abstract class InstructionBook {

    public final void create(){
        firstProcess();
        secondProcess();
    }

    protected abstract void firstProcess();

    protected abstract void secondProcess();

}
