package HelloJava;

class RunnableTest {
	Thread t1;
	Thread t2;
	int data; // no lock mechanism, this is not safe "data"
	
	private void setThreads(){
		this.t1 = new Thread(new Runnable() {
			public void run(){
				while(data > 0) {
					System.out.print(data + ", ");
					--data;
				}
			}
		});
		
		this.t2 = new Thread(new Runnable() {
			public void run() {
				while(data < 20) {
					System.out.print(data + "; ");
					++data;
				}
			}
		});
	}
	
	public RunnableTest(int data){
		this.data = data;
		this.setThreads();
	}
	
	public RunnableTest(){
		this.data = 10;
		this.setThreads();
	}
	
	public void startThreads(){
		t1.start();
		t2.start();
	}
}
