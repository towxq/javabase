package paixu;

public class maopaopaixu {
	public static void main(String[] args){
		int[] arr = {34,19,11,109,3,56};
		selectSort(arr);
		for(int m:arr){
			System.out.print("["+m+"],");
		}
	}

	public static void bubbleSort(int[] arr){//冒泡
		for(int x =0;x<arr.length;x++){
			for(int y =0;y<arr.length-1-x;y++){
				if(arr[y]>arr[y+1]){
					swap(arr,y,y+1);
				}
			}
		}
	}

	public static void selectSort(int[] arr){//选择
		for(int x =0;x<arr.length-1;x++){
			for(int y =x+1;y<arr.length;y++){
				if(arr[x]>arr[y]){
					swap(arr,x,y);
				}
			}
		}
	}


	private static void swap(int[] arr, int y, int i) {
		// TODO Auto-generated method stub
		int temp = arr[y];
		arr[y]=arr[i];
		arr[i]=temp;
	}
}
