package ass3;

import java.util.ArrayList;

public class FixedSizeQueue<T> implements SizeFixable<T>{
    protected ArrayList<T> fixQ;
    protected int QSize;

    public FixedSizeQueue(int firstSize){
        this.QSize =firstSize;
        fixQ=new ArrayList<>();
    }

    @Override
    public void add(Object element) throws Exception{
        if(fixQ.size()>= QSize)throw new MyQueueException("Queue is full.cannot add element.");
    fixQ.add((T)element);
    }

    @Override
    public T remove(){
        return fixQ.remove(0);
    }

    @Override
    public int getSize(){
        return fixQ.size();
    }
    @Override
    public int getQSize(){
        return this.QSize;
    }
    @Override
    public void setQSize(int newQSize)throws Exception {
        if (newQSize < fixQ.size())
            throw new MyQueueException("cannot decrease queue size (queue consists of more element).");
        this.QSize = newQSize;
    }
    @Override
    public String toString(){
        return fixQ.toString();
    }




}
