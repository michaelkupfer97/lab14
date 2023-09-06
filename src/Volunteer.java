public class Volunteer extends StaffMember{
    public Volunteer(String name,String id){
        super(name,id);
    }
    @Override
    public double pay(){
        return 0;
    }
    @Override
    public String toString(){
        return " "+ id + " volunteer \t pay:0";
    }
}
