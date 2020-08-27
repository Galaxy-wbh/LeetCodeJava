package DemoRecord.AlgorithmRecord.Sort;

import java.util.Random;

public class AllSort {

    public static void quickSort(int[] data, int start, int end){
        if(data == null || data.length == 0)
            return;
        if(start == end)
            return;
        int index = partition(data, start, end);
        if(index > start)
            quickSort(data, start, index-1);
        if(index < end)
            quickSort(data, index+1, end);
    }

    public static int partition(int[] data, int start, int end){
        Random random = new Random();
        int index = start + random.nextInt(end-start+1);
        swap(data, index, end);
        int res = start-1;
        for(int i=start;i<end;i++){
            if(data[i] > data[end]){
                res++;
                if(i != res){
                    swap(data, i, res);
                }
            }
        }
        res++;
        swap(data, res, end);
        return res;
    }

    public static void swap(int[] data, int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }



    public static void mergeSort(int[] data, int start, int end){
        if(data == null || data.length == 0)
            return;
        int[] copy = new int[data.length];
        if(start < end){

            int mid = start + (end-start)/2;
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            merge(data, start, mid, end, copy);
        }
    }

    public static void merge(int[] data, int start, int mid, int end, int[] copy){
        int i=start;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j<=end){
            if(data[i] < data[j]){
                copy[k++] = data[i++];
            }else{
                copy[k++] = data[j++];
            }
        }
        while(i<=mid){
            copy[k++] = data[i++];
        }
        while(j<=end){
            copy[k++] = data[j++];
        }
        for(int index=0;index<end-start+1;index++)
            data[index+start] = copy[index];
    }

    public static void heapSort(int[] data){
        int len = data.length;
        if(data == null || len == 0)
            return;
        //构建大顶堆
        for(int i=len/2-1;i>=0;i--){
            adjust(data, i, len);
        }
        //把堆顶元素(最大值)下沉到数组后面，然后重新调整成大顶堆
        for(int i=len-1;i>=1;i--){
            swap(data, 0, i);
            adjust(data, 0, i);
        }
    }

    public static void adjust(int[] data, int index, int len){
        int l = 2*index + 1;//左子树
        int r = 2*index + 2;//右子树
        int maxIndex = index;
        if(l < len && data[l] > data[maxIndex])
            maxIndex = l;
        if(r < len && data[r] > data[maxIndex])
            maxIndex = r;
        if(maxIndex != index){
            swap(data, index, maxIndex);
            adjust(data, maxIndex, len);//交换后继续调整
        }
    }

    public static void selectSort(int[] data){
        int min;
        for(int i=0;i<data.length;i++){
            min = i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<data[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(data, i, min);
            }
        }
    }

    public static void bubbleSort(int[] data){
        int n = data.length;
        for(int i=0;i<n-1;i++){
            for(int j=1;j<n-i;j++){
                if(data[j] < data[j-1]){
                    swap(data, j, j-1);
                }
            }
        }
    }

    public static void insertSort(int[] data){
        int n = data.length;
        if(n == 1)
            return;
        for(int i=1;i<n;i++){
            int current = data[i];
            int j = i-1;
            while(j>=0 && data[j]>current){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = current;
        }
    }
    public static void main(String[] args) {
        int[] test = new int[]{5,2,4,1,3,6,0};
        mergeSort(test,0, test.length-1);
        for(int i:test)
            System.out.print(i+" ");

    }
}
