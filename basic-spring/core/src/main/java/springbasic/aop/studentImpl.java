package springbasic.aop;

public class studentImpl implements Student {

    private int studentNo;
    private String studentName;

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void showDetails() {
        System.out.println(this.studentNo);
        System.out.println(this.studentName);
    }
}
