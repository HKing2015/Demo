import org.junit.Test;

//排序都是从大到小排列
public class SortTest {
	private int[] a = {3,2,1,4,7,8,5,1,9};
	
	@Test
	//直接插入排序
	public void insertSort() {
		for(int i = 1; i < a.length; i++) { //第一个元素认为是有序的，从第二个开始
			int temp = a[i]; //待插入元素
			int j = i - 1;
			
			while(j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}				
			a[j + 1] = temp;
		}
		for(Integer i : a) {
			System.out.println(i);
		}
	}
	
	
	@Test
	//二分插入排序
	public void binSort() {
		for(int i = 0; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			
			while(left <= right) {
				mid = (left + right)/2;
				if(temp < a[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			for(int j = i - 1; j > left; j--) {
				a[j + 1] = a[j];
			}
			
			if(left != i) {
				a[left] = temp;
			}
		}
		
		for(Integer i : a) {
			System.out.println(i);
		}
	}
}
