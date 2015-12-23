package Assignment;

/**
 * @author Priyamvada
 *
 */
public class CallByReference {
	 int data=10;  
	  
	 void change(CallByReference object){  
	 object.data=object.data+10;//changes will be in the instance variable  
	 }  
	     
	    
	 public static void main(String args[]){  
		 CallByReference callByReference=new CallByReference();  
	  
	   System.out.println("before change "+callByReference.data);  
	   callByReference.change(callByReference);//passing object  
	   System.out.println("after change "+callByReference.data);  
	  
	 }  
}
