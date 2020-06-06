package mianshi;

/**
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 * <p>
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @author shengouqiang
 * @date 2020/5/11
 */
public class TripleInOne {

    public static void main(String[] args) {
        TripleInOne stack = new TripleInOne(1);
        stack.push(0, 1);
        stack.push(0, 2);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.isEmpty(0));

        System.out.println("---------------------------------------");
        stack = new TripleInOne(2);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.peek(0));
    }

    private Integer[] array;
    private int[] indexArray;
    private int maxValueCount;


    public TripleInOne(int stackSize) {
        array = new Integer[stackSize * 3];
        indexArray = new int[3];
        maxValueCount = stackSize;
    }

    public void push(int stackNum, int value) {
        if (maxValueCount == indexArray[stackNum]) {
            return;
        }
        array[stackNum + indexArray[stackNum] * 3] = value;
        indexArray[stackNum]++;
    }

    public int pop(int stackNum) {
        int value = peek(stackNum);
        if(indexArray[stackNum] > 0){
            indexArray[stackNum] --;
        }
        return value;
    }

    public int peek(int stackNum) {
        if (0 == indexArray[stackNum]) {
            return -1;
        }
        int value = array[3 * (indexArray[stackNum] -1) + stackNum];
        return value;
    }

    public boolean isEmpty(int stackNum) {
        return indexArray[stackNum] ==0;
    }
}
