package dataStructures.linkedlist.week3;

/**
 * Created by HWENG on 1/19/2016.
 */
/*Given two linked lists sorted in increasing order. Merge them such a way that the
result list is in decreasing order (reverse order).*/

public class MergeTwoSortedListsInReverseOrder {
    public static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
            next = null;
        }
    }


    public static void main(String[]args){
        System.out.println("Application start...");

        MergeTwoSortedListsInReverseOrder mergeOrder = new MergeTwoSortedListsInReverseOrder();

        Node node1 = new Node(3);
        Node node2 = new Node(7);
        Node node3 = new Node(12);
        Node node4 = new Node(34);
        Node node5 = new Node(45);
        Node node6 = new Node(100);
        Node node7 = new Node(1000);
        Node node8 = new Node(10080);

        Node nodeA = new Node(4);
        Node nodeB = new Node(5);
        Node nodeC = new Node(7);
        Node nodeD = new Node(45);
        Node nodeE = new Node(56);
        Node nodeF = new Node(123);
        Node nodeG = new Node(10000);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node A = node1;

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;

        Node B = nodeA;
        Node linkedList = mergeOrder.MergerTwoSortedListsInReverse(A, B);

        while(linkedList!=null){
            System.out.print(linkedList.data + " ,");
            linkedList = linkedList.next;
        }
    }

    public Node MergerTwoSortedListsInReverse(Node list1, Node list2){
        if(list1==null && list2==null){
            return null;
        }

        Node current = null;
        Node head = null;
        while(list1!=null || list2!=null){
            if(list1==null){
                current = list2;
                list2 = list2.next;
            }else if(list2==null){
                current = list1;
                list1 = list1.next;
            }else{
                if(list1.data < list2.data){
                    current = list1;
                    list1 = list1.next;
                }else{
                    current = list2;
                    list2 = list2.next;
                }
            }

            current.next = head;
            head = current;
        }
        return head;
    }
}
