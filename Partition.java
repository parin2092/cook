import java.util.Arrays;

class Partition {
    public static int findMaxSum( int[] baseArr ) {
        int s1=0,s2=0,s3=0;
        int turn=0;
        Arrays.sort(baseArr);
        int N = baseArr.length;
        boolean dirFlipped = false;
        int a;
        for (int i = N-1 ; i >= 0 ; i--) {
            a = baseArr[i];
            int s = Math.min(Math.min(s1,s2),s3);
            if(s == s1){s1+= a;}
            else if(s == s2){s2+= a;}
            else{s3+= a;};
        }
        return (s1 > s2) ? ((s1 > s3) ? s1 : s3) : ((s2 > s3) ? s2 : s3);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,5,6,7,8,9,9};
        int sum = findMaxSum(arr);
        System.out.println(Math.round(sum));
    }
}


// import java.util.*;
// class Partition {
//     public static int karmarkarKarpPartition( int[] baseArr ) {
//         // create max heap
//         PriorityQueue <Integer> heap = new PriorityQueue <Integer>( baseArr.length, Collections.reverseOrder() );

//         for ( int value: baseArr ) {
//             heap.add( value );
//         }

//         while ( heap.size() > 2 ) {
//             int val1 = heap.poll();
//             int val2 = heap.poll();
//             int val3 = heap.poll();
//             heap.add( val1 - val2 - val3 );
//         }

//         return heap.poll();
//     }

//     public static void main(String[] args) {
//         int arr[] = {1,2,3,3,5,6,7,8,9,9};
//         int sum = karmarkarKarpPartition(arr);
//         System.out.println(Math.round(sum));
//     }
// }
