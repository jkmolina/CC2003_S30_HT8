public class Patient
{
    String name;
    String sickness;
    String priority;

    void setName(String name){
        this.name=name;
    }

    void setSickness(String sickness){
        this.sickness=sickness;
    }

    void setPriority(String priority){
        this.priority=priority;
    }

    String name()
    {
        return this.name;
    }
    String sickness()
    {
        return this.sickness;
    }
    String priority()
    {
        return this.priority;
    }
}