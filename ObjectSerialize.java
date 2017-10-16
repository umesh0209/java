import java.io.*;

public class ObjectSerialize{
	
	public static void main(String[] args) throws ClassNotFoundException{
		ObjectOutputStream objWriter = null;
		ObjectInputStream objReader = null;
		
		try{
			objWriter = new ObjectOutputStream( 
				new FileOutputStream("myfamily.dat"));
			
			objWriter.writeObject(new Student(1, "Umesh"));
			objWriter.writeObject(new Student(2,"Mahima"));
			objWriter.writeObject(new Student(3,"Chaitanya"));
			
			System.out.println("List of students");
			
			objReader = new ObjectInputStream(
				new FileInputStream("myfamily.dat"));
			
			for (int i=0;i<3;i++){
				System.out.println(objReader.readObject());
			}
		}catch (IOException ie){
			ie.printStackTrace();
		} finally{
			try{
				objReader.close();
				objWriter.close();
			}catch (IOException ie){
				ie.printStackTrace();
			}
		}
	}
	
	static class Student implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String firstName;
		private int id;
		
		public Student(int id, String firstN){
			this.firstName = firstN;
			this.id = id;
		}
		
		public String toString(){
			return ("ID:"+id+" "+"Name:"+firstName);
		}
	}
}
