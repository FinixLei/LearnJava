package HelloJava;

class SyncMethodTest {
	Thread t1;
	Thread t2;
	int data;
	
	// private void addData(String id){ // If no synchronized, t1 and t2 will all run
	private synchronized void addData(String id){ // t1 will run first, then t2, as it is synchronized. 
		try{
			while(data < 50) {
				System.out.print(data + " " + id + ", ");
				++data;
				Thread.sleep(10);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void setThreads(){
		this.t1 = new Thread(new Runnable() {
			public void run(){
				addData("t1"); 
			}
		});
		
		this.t2 = new Thread(new Runnable() {
			public void run() {
				addData("t2");
			}
		});
	}
	
	public SyncMethodTest(int data){
		this.data = data;
		this.setThreads();
	}
	
	public void startThreads(){
		t1.start();
		t2.start();
	}
}