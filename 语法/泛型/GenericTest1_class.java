
public class GenericTest1_class<T, F> {
	private T paraT;
	private F paraF;
	
	public GenericTest1_class() {};
	public GenericTest1_class(T paraT, F paraF) {
		this.paraT = paraT;
		this.paraF = paraF;
	}

	public T getParaT() {
		return paraT;
	}
	public void setParaT(T paraT) {
		this.paraT = paraT;
	}
	public F getParaF() {
		return paraF;
	}
	public void setParaF(F paraF) {
		this.paraF = paraF;
	}
	
	public static void main(String[] args) {
		GenericTest1_class<String, Integer> test1 = new GenericTest1_class<String, Integer>("huangjin", 123);
		System.out.println(test1.getParaT() + test1.getParaF());
	}
}