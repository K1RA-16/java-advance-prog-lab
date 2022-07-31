public class q_6 {
    public static void main(String[] args) {
        System.out.print("Elements -");
        int n = 100;
        System.out.println();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[0] = 10;
                continue;
            }
            arr[i] = arr[i - 1] + (int) (10 * Math.random());
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int index = (int) (n * Math.random());// random index
        System.out.println("Selected - " + arr[index]);
        float percentile = (float) (index / n) * 100;
        System.out.println("Percentile - " + percentile + "%");
    }
}
