class GenOne {
	public int data;
	
	public GenOne(){
		System.out.println("In GenOne Constructor");
	}
	
	protected void doSomething(){
		System.out.println("In GenOne: do something!");
	}
	
	protected GenOne doIt(){
		return new GenOne();
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
	public boolean equals(GenOne other){
		if (this.data == other.data){
			return true;
		} else {
			return false;
		}
	}
}

