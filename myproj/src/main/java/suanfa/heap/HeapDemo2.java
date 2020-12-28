package suanfa.heap;

public class HeapDemo2 {
    public static void main(String[] args) {
        int[] arr = {10, 60, 70, 40, 30, 50, 90, 80, 20, 100};
        heap_sort(arr, arr.length);

        reverse(arr);
        for (int n : arr) {
            System.out.printf("%d ", n);
        }
    }

    public static void heap_sort(int[] arr, int n) {
        make_heap(arr, n);
        for (int count = n - 1; count > 0; count--) {
            int tmp = arr[count];
            arr[count] = arr[0];
            arr[0] = tmp;
            heap_adjust(arr, 0, count);
        }
    }

    public static void make_heap(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heap_adjust(arr, i, n);
        }
    }

//    public static void heap_adjust(int []arr, int root, int n) {
//        int left = 2 * root + 1;
//        int right = 2 * root + 2;
//        int min;
//        int minIndex;
//        int parent = root;
//        while (left < n) {
//            min = arr[left];
//            minIndex = left;
//            if (right < n && (arr[right] < min)) {
//                min = arr[right];
//                minIndex = right;
//            }
//            if (arr[parent] <= min) {
//                break;
//            }
//            int tmp = arr[parent];
//            arr[parent] = min;
//            arr[minIndex] = tmp;
//            parent = minIndex;
//            left = 2 * parent + 1;
//            right = 2 * parent + 2;
//        }
//    }

//    public static void heap_adjust(int []arr, int root, int n) {
//        int min;
//        int minIndex;
//        int parent = root;
//        while (2 * parent < n) {
//            min = arr[parent];
//            minIndex = parent;
//            int left = 2 * parent + 1;
//            int right = 2 * parent + 2;
//            if (right < n && (arr[right] < min)) {
//                min = arr[right];
//                minIndex = right;
//            }
//            if (left < n && (arr[left] < min)) {
//                min = arr[left];
//                minIndex = left;
//            }
//            if (minIndex == parent) {
//                break;
//            }
//            int tmp = arr[parent];
//            arr[parent] = min;
//            arr[minIndex] = tmp;
//            parent = minIndex;
//        }
//    }


//    public static void heap_adjust(int []arr, int root, int n) {
//        int left = 2 * root + 1;
//        int right = 2 * root + 2;
//        int min;
//        int minIndex = root;
//        int parent = root;
//        int tmp = arr[root];
//        while (left < n) {
//            min = arr[left];
//            minIndex = left;
//            if (right < n && (arr[right] < min)) {
//                min = arr[right];
//                minIndex = right;
//            }
//            if (tmp <= min) {
//                break;
//            }
//            arr[parent] = min;
//            parent = minIndex;
//            left = 2 * parent + 1;
//            right = 2 * parent + 2;
//        }
//
//        if (parent != root) {
//            arr[minIndex] = tmp;
//        }
//
//    }



//    public static void heap_adjust(int[] arr, int root, int n) {
//        int left = 2 * root + 1;
//        int right = 2 * root + 2;
//        int min;
//        int minIndex;
//        int parent = root;
//
//        if (left < n) {
//            min = arr[left];
//            minIndex = left;
//            if (right < n && (arr[right] < min)) {
//                min = arr[right];
//                minIndex = right;
//            }
//            if (arr[parent] <= min) {
//                return;
//            }
//            int tmp = arr[parent];
//            arr[parent] = min;
//            arr[minIndex] = tmp;
//            heap_adjust(arr, minIndex, n);
//        }
//    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heap_adjust(int arr[], int i, int n)
    {
        int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            heap_adjust(arr, smallest, n);
        }
    }


    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
