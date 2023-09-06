package ass3;

public interface SizeFixable <T>{
    void add(T element)throws Exception;
    T remove();
    int getSize();
    int getQSize();
    void setQSize(int newQSize) throws Exception;

}
