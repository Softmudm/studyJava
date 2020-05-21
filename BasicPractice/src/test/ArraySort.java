package test;

import java.util.Arrays;

public class ArraySort {
	/**
	 * 数组排序算法
	 */
	public static void main(String[] args) {
		int array[] = {3,7,0,2,1,9,4,5,6,8};
		System.out.println(Arrays.toString(array));
		//System.out.println(Arrays.toString(xzSort(array)));
		//System.out.println(Arrays.toString(mpSort(array)));
		//System.out.println(Arrays.toString(crSort(array)));
		ksSort(array,0,(array.length-1));
		System.out.println(Arrays.toString(array));
	}
	/*
	 * 选择排序
	 */
	public static int[] xzSort(int[] array) {
		int index = -1;
		for(int i=0;i<array.length;i++) {
			index = i;						    //标记最左边元素下标
			for(int j=i+1;j<array.length;j++) { //从标记右边开始比较
				if(array[index]>array[j]) {		//从小到大排
					index = j;
				}
			}
			swop(array,i,index);
		}
		return array;
	}
	/*
	 * 冒泡排序
	 */
	public static int[] mpSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {       //比较相邻两个元素大小，每次大的放右边以便和更右边比较，这样循环一次大的就会冒泡到右边
					swop(array,j,(j+1));
				}
			}
		}
		return array;
	}
	/*
	 * 插入排序
	 */
	public static int[] crSort(int[] array) {
		int temp;								//存储当前取出的元素值
		for(int i=1;i<array.length;i++) {
			temp = array[i];
			for(int j=i;j>0;j--) {   			//从当前元素的前一个开始向前循环比较
				if(array[j-1]>temp) {			//前一个数比当前数大所以往后移一位
					array[j] = array[j-1];
					if(j==1){
                        array[j-1] = temp;
                        break;
                    }
				}else {							//前一个比较小那么当前元素就插在这里终止循环
					array[j] = temp;
					break;
				}
			}
		}
		return array;
	}
	/*
	 * 快速排序(递归方法)
	 */
	public static void ksSort(int[] array,int start,int end) {
		if(start<end) {
			int left = start;					//左边指针
			int right = end;					//右边指针
			int temp = array[start];			//中间数
			while(left<right) {
				while(left<right && array[right]>temp) {	//右边数字比中间数大，指针左移。直到右边比中间数字小		
					right--;
				}
				if(left==right) {				//最后的时候left==right,为了不走下面的left++
					break;
				}
				array[left] = array[right];		//右边比中间数字小时，右边的换到左边的标记处并使左指针右移一位
				left++;
				while(left<right && array[left]<=temp) {	//左边边数字比中间数小，指针右移。注意“=”号
					left++;
				}
				if(left==right) {
					break;
				}
				array[right] = array[left];
				right--;
			}
			array[left] = temp;					//左右指针相等时即为中间位置，将中间数插入
			ksSort(array,start,left);			//包括中间数的左边数组继续使用快速排序
			ksSort(array,(left+1),end);			//中间数右边的数组就像使用快速排序
		}
	}
	//两个数交换的方法(没用)
	public static void swop(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	//两个数组元素交换的方法
	public static void swop(int[] array,int m,int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
}
