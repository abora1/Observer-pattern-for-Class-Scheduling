package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements SubjectI,ObserverI {

	Node left, right;
    Integer Bno;
    String course;
    ArrayList<ObserverI> obs1=new ArrayList<ObserverI>();
    public Node(){
    	Bno=0;
    	left=null;
    	course=null;
    }
    public Node(String courseDataIN,int numIN)
    {
        left = null;
        right = null;
        Bno = numIN;
        course = courseDataIN;
    }
    public void deleteAndUpdate(String course)
    {
    	
    	if(this.course.equals(course))
    	{
    		//System.out.println("\ndeleting course : " + course);
    		this.setCourse("");
    	}
    }
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node leftIn) {
		this.left = leftIn;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node rightIn) {
		this.right = rightIn;
	}

	public Integer getBno() {
		return Bno;
	}

	public void setBno(Integer bnoI) {
		Bno = bnoI;
		Notify();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String courseIn) {
		this.course = courseIn;
		Notify();
	}
	 public String getData()
	    {
	    	return this.Bno.toString() + ":" + course; 
	    }    
	    
	public void Notify()
	{
		//	Update all the observers through notify.
		for(ObserverI obs : this.obs1)
		{
			obs.Update(course, Bno);
		}
	}
	
	@Override
	public void Update(String course, int data) {
		this.course="-";
		
	}

	@Override
	public void Subscribe(ObserverI observer) {
		this.obs1.add(observer);
		
	}

}
