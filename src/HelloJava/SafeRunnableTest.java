package HelloJava;

class SafeRunnableTest {
	Thread t1;
	Thread t2;
	int data;
	
	private void setThreads(){
		this.t1 = new Thread(new Runnable() {
			public void run(){
				synchronized(""){
					while(data > 0) {
						System.out.print(data + ", ");
						--data;
					}
				}
			}
		});
		
		this.t2 = new Thread(new Runnable() {
			public void run() {
				synchronized(""){
					while(data < 20) {
						System.out.print(data + "; ");
						++data;
					}
				}
			}
		});
	}
	
	public SafeRunnableTest(int data){
		this.data = data;
		this.setThreads();
	}
	
	public SafeRunnableTest(){
		this.data = 10;
		this.setThreads();
	}
	
	public void startThreads(){
		t1.start();
		t2.start();
	}
}