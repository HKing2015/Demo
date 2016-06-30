import java.util.ArrayList;
import java.util.List;

public class GenericTest3_wildcards {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("222");
		list.add("333");
		
		WildCards wc = new WildCards();
		wc.test1(list);
		
		GenericType<?,?> generic = wc.test2("huangjin", "jin");
		generic.show();
	}
}


class WildCards {
	public void test1(List<?> list) { //可以处理任意泛型的List
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public <T, E> GenericType<?,?> test2(T str1, E str2) { //可以返回任意泛型的GenericType类(泛型方法+通配符)
		GenericType<?, ?> generic = new GenericType<>(str1, str2);
		return generic;
	}
}

class GenericType<K,V> {
	private K key;
	private V value;
	
	public GenericType() {}
	public GenericType(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

	public void show() {
		System.out.println("key: " + key);
		System.out.println("value: " + value);
	}
	
}
