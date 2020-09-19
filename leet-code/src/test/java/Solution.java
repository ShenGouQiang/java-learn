import mianshi.DeleteNode;
import org.junit.Test;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {


    @Test
    public void testFour(){
        System.out.println(findWaterKing(new int[]{2, 7, 2, 2, 6, 5, 2, 0, 2, 2, 2, 8, 2, 3, 2, 2, 9, 4, 2, 2, 2}));
    }

    @Test
    public void testFive(){
        int[] array = new int[]{1,5,3,8,6,9,0,4};
        quickSort(array,0,array.length-1);
        System.out.println(1);
    }

    public void quickSort(int[] array,int left,int right){

        if(left > right){
            return;
        }
        int med = array[left];
        int i= left;
        int j= right;
        while (i < j){
            while (array[j] >= med && i < j){
                j--;
            }
            while (array[i] <= med && i<j){
                i++;
            }
            if(i < j){
                int temp = array[i];
                array[i] =array[j];
                array[j] = temp;
            }
        }
        array[left]=array[i];
        array[i] = med;
        quickSort(array,left, i-1);
        quickSort(array,i+1,right);
    }

    public int findWaterKing(int[] array){
        int waterKing = array[0];
        int num=1;
        for (int i=1;i<array.length;i++){
            if(waterKing == array[i]){
                num++;
                continue;
            }
            num--;
            if(num == 0){
                waterKing = array[i];
                num=1;
            }
        }
        return waterKing;
    }


    @Test
    public void testThree(){
        int[] num = {4,5,1,6,2,7,3,8};
        minHeapSort(num,4);
      //  maxHeapSort(num,4);
    }


    public void maxHeapSort(int[] array,int k){
        Queue<Integer> pq = new PriorityQueue<>(k);
        for(int sum : array){
            if(pq.size() < k){
                pq.offer(sum);
            }else if(sum > pq.peek()){
                pq.poll();
                pq.offer(sum);
            }
        }
        System.out.println(pq);
    }


    public void minHeapSort(int[] array,int k){
        List<Integer> list = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(10,(v1,v2)->v2- v1);
        for (int num: array) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        pq.stream().forEach(System.out::println);
    }


    @Test
    public void testOne(){
        System.out.println(solve(new char[][]{{'1','1','1'},{'1','1','1'},{'1','1','1'}}));
    }

    @Test
    public void testTwo(){
        Object o = new Object();
        final int[] count = {0};

        class printNumber  implements Runnable{

            @Override
            public void run() {
               while(count[0] < 10){
                   synchronized (o){
                       System.out.println(count[0]);
                       count[0]++;
                       o.notify();
                       try {
                           o.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        }

        Thread a = new Thread(new printNumber(),"a");
        Thread b = new Thread(new printNumber(),"a");
    }

    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }


    private void dfs(char[][] grid,int i,int j){
        Pointer p = new Pointer(i,j);
        Queue<Pointer> queue = new LinkedList<>();
        queue.offer(p);
        while(!queue.isEmpty()){
            Pointer tmp = queue.poll();
            grid[tmp.x][tmp.y] = '2';
            if(tmp.x -1 >= 0 && grid[tmp.x-1][tmp.y] == '1'){
                queue.offer(new Pointer(tmp.x-1,tmp.y));
            }
            if(tmp.x +1 < grid.length && grid[tmp.x+1][tmp.y] == '1'){
                queue.offer(new Pointer(tmp.x+1,tmp.y));
            }
            if(tmp.y-1 >=0  && grid[tmp.x][tmp.y-1] == '1'){
                queue.offer(new Pointer(tmp.x,tmp.y-1));
            }
            if(tmp.y +1 < grid[0].length && grid[tmp.x][tmp.y+1] == '1'){
                queue.offer(new Pointer(tmp.x,tmp.y+1));
            }
        }
    }

    static class Pointer{
        int x;
        int y;
        public Pointer(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void testSix(){
        System.out.println(searchMatrix(new int[][]{{-8},{-5},{-4},{-2},{0},{3},{4},{5},{6},{8},{9},{11},{13},{16},{18},{20},{23},{25},{26},{27},{29},{31},{32},{34},{37},{38},{41},{44},{46},{49},{51},{53},{56},{57},{58},{60},{63},{65},{68},{70},{73},{76},{77},{79},{82},{84},{87},{90},{92},{94}},57));
    }



    public boolean searchMatrix (int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = row * col -1;
        return findByBinary(matrix,row,col,0,sum,target);
    }

    public boolean findByBinary(int[][] matrix,int row,int col,int left,int right,int target){
        while(left <= right){
            int med = (left + right) /2;
            int tmpRow = med / col;
            int tmpCol = med  - tmpRow * col + tmpRow == 0 || col == 1 ? 0:1;
            if(matrix[tmpRow][tmpCol] == target){
                return true;
            }
            if(matrix[tmpRow][tmpCol] > target){
                right = med - 1;
            }
            if(matrix[tmpRow][tmpCol] < target){
                left = med + 1;
            }
        }
        return false;
    }

    @Test
    public void testSeven(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(reverseKGroup(n1,2));
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = new ListNode(0);
        prevHead.next = head;
        ListNode pre = prevHead;
        ListNode end = prevHead;
        while(end.next != null){
            for(int i=0;i<k && end != null;i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return prevHead.next;
    }


    public ListNode reverse(ListNode node){
        if(node == null){
            return node;
        }
        ListNode prev = null;
        ListNode next = node.next;
        while(node != null){
            node.next = prev;
            prev = node;
            node = next ;
            if(null != next){
                next = next;
            }
        }
        return prev;
    }


    @Test
    public void testEight(){
     //   System.out.println(findMedianinTwoSortedAray(new int[]{1,2,3,4},new int[]{3,4,5,6}) == 3);
        System.out.println(findMedianinTwoSortedAray(new int[]{1,2,3,4,5},new int[]{-1,1,3,5,6}) == 3);
    }


    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        int a1Start = 0;
        int a2Start = 0;
        int len = arr1.length -1;
        int mid = arr1.length -1;
        while(mid > 0){
            int a1Mid = (a1Start + len) /2;
            int a2Mid = (a2Start + len) /2;
            if(arr1[a1Mid] == arr2[a2Mid]){
                int subLen =0;
                if(a1Mid == a1Start){
                    subLen =1;

                }else{
                    subLen = a1Mid -a1Start;

                }
            }else if(arr1[a1Mid] > arr2[a2Mid]){

            }else{

            }
        }

        return arr1[a1Start] >= arr2[a2Start] ? arr2[a2Start] : arr1[a1Start];
    }


    @Test
    public void test10(){
        merge(new int[]{1},1,new int[0],0);
    }


    public void merge(int A[], int m, int B[], int n) {
        int finalCount  = m + n -1;
        while(finalCount >=0){
            if(m >0 && n >0){
                if(A[m-1] >= B[n-1]){
                    A[finalCount] = A[m-1];
                    m--;
                }else{
                    A[finalCount] = B[n-1];
                    n--;
                }
                finalCount--;
            }else if(m > 0){
                A[finalCount] = A[m-1];
                m--;
                finalCount--;
            }else if(n > 0){
                A[finalCount] = B[n-1];
                n--;
                finalCount--;
            }
        }
    }

}