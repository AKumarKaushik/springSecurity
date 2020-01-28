/*Q8) Implement proxy design for accessing Record of a student and allow the access only to Admin. */
package java6_Assgnmnt;

interface Record{
    void RecordInfo();
}

class SchoolMember{
    private String type;

    public SchoolMember(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class students implements Record{
    protected SchoolMember schoolMember;
    public students(SchoolMember schoolMember){
        this.schoolMember = schoolMember;
    }

    @Override
    public void RecordInfo() {
        System.out.println("Accessing The Record");
    }
}

class studentproxy extends students{

    public studentproxy(SchoolMember schoolMember) {
        super(schoolMember);
    }

    @Override
    public void RecordInfo() {
        if(schoolMember.getType().equals("Admin")){
            System.out.println("Records Are Accessible By Admin");
            super.RecordInfo();
        }else{
            System.out.println("Can not Access records");
        }
    }
}
public class Q8_ProxyDesign {
    public static void main(String[] args) {
        SchoolMember schoolMember = new SchoolMember("User");
        Record record = new studentproxy(schoolMember);
        record.RecordInfo();
    }
}
