import java.io.*;

class Record{
	private String s;
	private int num;
	private double y;
	public Record(String str, int n ,double x){
		this.s = str;
		this.num = n;
		this.y = x;
	}
	public String  getString(){
		return s;
	}
	public int getInteger(){
		return num;
	}
	public double getDouble(){
		return y;
	}
	public String toString(){
		return s+" "+num+" "+y;
	}
}

class RecordInputStream extends FilterInputStream{
	public RecordInputStream(DataInputStream in){
		super(in);
	}
	public Record reads() throws IOException{
		DataInputStream in = (DataInputStream)this.in;
		if(in.available() == 0){
			return null;
		}
		return new Record(in.readUTF(),in.readInt(),in.readDouble());
	}
}

class RecordOutputStream extends FilterOutputStream{
	
	public RecordOutputStream(DataOutputStream out){
		super(out);
	}
	public void writes(Record r) throws IOException{
		DataOutputStream out = (DataOutputStream)this.out;
		String str = r.toString();
		out.writeUTF(str);
	}
}

   class WriteRecords {
	  public static void main(String[] args) {
	    Record rec1 = new Record("record #1", 2, Math.sqrt(2));
	    Record rec2 = new Record("record #2", 3, Math.E);
	    Record rec3 = new Record("record #3", 5, Math.PI);
	    Record rec4 = new Record("record #4", 7, 4.0);
	    Record rec5 = new Record("record #5", 9, Math.E + Math.PI);

	    try {
	      /***
	      **** Step 1: declare and initialize the record output stream
	      ***/
	    	
	    	FileOutputStream f = new FileOutputStream("record.db");
	    	DataOutputStream d = new DataOutputStream(f);
	    	RecordOutputStream r = new RecordOutputStream(d);

	      /***
	      **** Step 2: write the five records to the record output stream
	      **** Don't forget to close the top-level stream.
	      ***/
	    	
	    	r.writes(rec1);
	    	r.writes(rec2);
	    	r.writes(rec3);
	    	r.writes(rec4);
            r.writes(rec5);
	    	 
	      System.out.println("Five records have been saved to the 'record.db' file.");

	      // Handle excpetions
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
   
   class ReadRecords {
	   public static void main(String[] args) {
	     Record record;

	     try {
	       /***
	       **** Step 1: declare and initialize the record input stream
	       ***/

	    	 FileInputStream f = new FileInputStream("record.db");
	    	 DataInputStream d = new DataInputStream(f);
	    	 RecordInputStream r = new RecordInputStream(d);
	       /***
	       **** Step 2: read the five records from the record input stream
	       **** Don't forget to close the top-level stream.
	       ***/
	    	 while((record = r.reads())!=null){
	    		 System.out.println(record);
	    	 }
	    	 

	       // Handle excpetions
	     } catch (IOException e) {
	       e.printStackTrace();
	     }
	   }
	 }