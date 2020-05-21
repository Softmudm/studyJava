package test;

import java.util.Arrays;

public class ArraySort {
	/**
	 * ���������㷨
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
	 * ѡ������
	 */
	public static int[] xzSort(int[] array) {
		int index = -1;
		for(int i=0;i<array.length;i++) {
			index = i;						    //��������Ԫ���±�
			for(int j=i+1;j<array.length;j++) { //�ӱ���ұ߿�ʼ�Ƚ�
				if(array[index]>array[j]) {		//��С������
					index = j;
				}
			}
			swop(array,i,index);
		}
		return array;
	}
	/*
	 * ð������
	 */
	public static int[] mpSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {       //�Ƚ���������Ԫ�ش�С��ÿ�δ�ķ��ұ��Ա�͸��ұ߱Ƚϣ�����ѭ��һ�δ�ľͻ�ð�ݵ��ұ�
					swop(array,j,(j+1));
				}
			}
		}
		return array;
	}
	/*
	 * ��������
	 */
	public static int[] crSort(int[] array) {
		int temp;								//�洢��ǰȡ����Ԫ��ֵ
		for(int i=1;i<array.length;i++) {
			temp = array[i];
			for(int j=i;j>0;j--) {   			//�ӵ�ǰԪ�ص�ǰһ����ʼ��ǰѭ���Ƚ�
				if(array[j-1]>temp) {			//ǰһ�����ȵ�ǰ��������������һλ
					array[j] = array[j-1];
					if(j==1){
                        array[j-1] = temp;
                        break;
                    }
				}else {							//ǰһ���Ƚ�С��ô��ǰԪ�ؾͲ���������ֹѭ��
					array[j] = temp;
					break;
				}
			}
		}
		return array;
	}
	/*
	 * ��������(�ݹ鷽��)
	 */
	public static void ksSort(int[] array,int start,int end) {
		if(start<end) {
			int left = start;					//���ָ��
			int right = end;					//�ұ�ָ��
			int temp = array[start];			//�м���
			while(left<right) {
				while(left<right && array[right]>temp) {	//�ұ����ֱ��м�����ָ�����ơ�ֱ���ұ߱��м�����С		
					right--;
				}
				if(left==right) {				//����ʱ��left==right,Ϊ�˲��������left++
					break;
				}
				array[left] = array[right];		//�ұ߱��м�����Сʱ���ұߵĻ�����ߵı�Ǵ���ʹ��ָ������һλ
				left++;
				while(left<right && array[left]<=temp) {	//��߱����ֱ��м���С��ָ�����ơ�ע�⡰=����
					left++;
				}
				if(left==right) {
					break;
				}
				array[right] = array[left];
				right--;
			}
			array[left] = temp;					//����ָ�����ʱ��Ϊ�м�λ�ã����м�������
			ksSort(array,start,left);			//�����м���������������ʹ�ÿ�������
			ksSort(array,(left+1),end);			//�м����ұߵ��������ʹ�ÿ�������
		}
	}
	//�����������ķ���(û��)
	public static void swop(int a,int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	//��������Ԫ�ؽ����ķ���
	public static void swop(int[] array,int m,int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
}
