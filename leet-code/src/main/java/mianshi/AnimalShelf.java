package mianshi;

import org.junit.Test;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/animal-shelter-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shengouqiang
 * @date 2020/5/29
 */
public class AnimalShelf {
    @Test
    public void testOne() {
        enqueue(new int[]{0, 0});
        enqueue(new int[]{1, 0});
        print(dequeueCat());
        print(dequeueDog());
        print(dequeueAny());

    }

    @Test
    public void testTwo(){
        enqueue(new int[]{0, 0});
        enqueue(new int[]{1, 1});
        enqueue(new int[]{2, 0});
        print(dequeueAny());
        print(dequeueAny());
    }

    private void print(int[] result) {
        System.out.println(result[0] + "--->" + result[1]);
    }

    static class Node {
        int no;
        int type;
        Node next;
    }

    private Node head;
    private Node tail;

    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        Node tmpNode = new Node();
        tmpNode.no = animal[0];
        tmpNode.type = animal[1];
        if (head == null) {
            head = tmpNode;
            tail = tmpNode;
        }else{
            tail.next = tmpNode;
            tail= tmpNode;
        }
    }

    public int[] dequeueAny() {
        if(head == null){
            return new int[]{-1,-1};
        }
        Node tmpNode = head;
        if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        return new int[]{tmpNode.no,tmpNode.type};

    }

    public int[] dequeueDog() {
       return  dequeue(1);
    }

    public int[] dequeueCat() {
        return  dequeue(0);
    }

    private int[] dequeue(int type){
        if(head == null){
            return new int[]{-1,-1};
        }
        Node tmp = head;
        if(tmp.type == type){
            head = head.next;
            if(head == null){
                tail = null;
            }
            return new int[]{tmp.no,tmp.type};
        }
        Node prev = null;
        while(tmp != null){
            if(tmp.type == type){
                if(null != prev){
                    prev.next = tmp.next;
                }

                return new int[]{tmp.no,tmp.type};
            }
            prev = tmp;
            tmp = tmp.next;
        }
        return new int[]{-1,-1};
    }
}
