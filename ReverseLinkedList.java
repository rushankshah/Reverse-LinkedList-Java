class ReverseLinkedList {

    static class LinkedList {
        Node head;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList = addNodeAtTail(linkedList, 2);
        linkedList = addNodeAtTail(linkedList, 3);
        linkedList = addNodeAtTail(linkedList, 4);
        linkedList = addNodeAtTail(linkedList, 5);
        System.out.println("Initial Linked list: ");
        LinkedList.Node curr = linkedList.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("After reversing: ");
        // Reversing starts here:
        linkedList = reverseList(linkedList);
        curr = linkedList.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static LinkedList reverseList(LinkedList linkedList) {
        LinkedList.Node prevNode = null;
        LinkedList.Node currentNode = linkedList.head;

        while (currentNode != null) {
            LinkedList.Node nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        linkedList.head = prevNode;

        return linkedList;
    }

    public static LinkedList addNodeAtTail(LinkedList linkedList, int data) {
        LinkedList.Node newNode = new LinkedList.Node(data);
        // newNode.data = data;
        newNode.next = null;
        if (linkedList.head == null) {
            linkedList.head = newNode;
        } else {
            LinkedList.Node lastNode = linkedList.head;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = newNode;
        }
        return linkedList;
    }
}