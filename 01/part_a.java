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
    public static void main(String[] args) {
        String path = "0";
        Scanner sc = new Scanner(new File(path));
         
        
        int n; // number of elements
        while (sc.hasNextLine()) {
            n = s.nextInt(); = sc.nextLine();
            if(line.contains("include")) {
                addStringFromExternal(buffer,line);
                continue;
            }
        int[] arr;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k;
        k = s.nextInt();
        int a = find(arr,k,0,n-1,0);
        System.out.println(a);
    }
} 