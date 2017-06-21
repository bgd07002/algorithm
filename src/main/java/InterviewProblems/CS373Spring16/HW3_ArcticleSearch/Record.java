package InterviewProblems.CS373Spring16.HW3_ArcticleSearch;

public class Record {

    private int id;
    private String title;
    private String author;
    private Record next;

    public Record(int i, String t, String a, Record r){
        this.id = i;
        this.title = t;
        this.author = a;
        this.next = r;
    }

    public void print(){
        System.out.println(this.title);
        System.out.println(this.author);
    }
}
