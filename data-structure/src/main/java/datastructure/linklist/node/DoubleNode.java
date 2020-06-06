package datastructure.linklist.node;

import lombok.Data;

/**
 * 双链表节点
 * @author shengouqiang
 * @date 2020/3/25
 */
@Data
public class DoubleNode<T> {

    private DoubleNode<T> prev;

    private T data;

    private DoubleNode<T> next;

}
