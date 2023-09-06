import java.util.Objects;

public abstract class StaffMember {
    protected id id;
    protected status stat;

    public StaffMember(String name,String id){
        this.id=new id(name,id);
        this.stat=status.INSTAFF;
    }
    public abstract double pay();
    @Override
    public abstract String toString();
    @Override
    public boolean equals(Object o){
        if (o==this)return true;
        if (o.getClass()!= getClass() ||o==null)return false;
        StaffMember member=(StaffMember) o;
        return Objects.equals(id,member.id);
    }

    public id getId() {
        return id;
    }

    public void setId(id id) {
        this.id = id;
    }

    public status getStat() {
        return stat;
    }

    public void setStat(status stat) {
        this.stat = stat;
    }
}
