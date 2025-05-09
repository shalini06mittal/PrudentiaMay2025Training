package oops;
@FunctionalInterface
public interface Addition {
    public int add(int a, int b);
    public default int add1(int a, int b){
        return 1;
    }
}
