class Test {
	public static void main(String[] args)  {
		try{
			throw new Exception("Thay");
		}finally{
			System.out.println("Thai gayu");
		}
	}
}