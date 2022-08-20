import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part_a {
    static int find(int[] arr,int k,int l,int r,int a){
        if(l>r){
            return -1;
        }
        else {
            int mid = l + (r-l)/2;
            a++;
            if(arr[mid]==k){
                return a;
            }
            if(arr[mid] > k){
                return find(arr,k,l,mid-1,a);
            }
            else{
                return find(arr,k,mid+1,r,a);
            }
        
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        String path = "01a_test1.inp";
        Scanner sc = new Scanner(new File(path));
        int n = 0; // number of elements
        if (sc.hasNextLine()) {
            n = sc.nextInt();
        }
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
            else{
                break;
            }
            
        }
        int k;
        k = sc.nextInt();
        int a = find(arr,k,0,n-1,0);
        System.out.println(a);
    }
} 