package datastructure.linklist.node;

import lombok.Data;

/**
 * 单链表节点
 * @author shengouqiang
 * @date 2020/3/25
 */
@Data
public class SingletonNode<T> {

    private T data;

    private SingletonNode<T> next;
}
