public class DeleteLinkedList {

    //Delete a node from a linked list based on value

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    void deleteNodesOnData(Node node, int target) {
        while (node != null && node.data == target) {
            node = node.next;
        }
        if(node == null) return;
        Node back = node;
        Node front = node.next;

        while(front != null) {
            if(front.data == target) {
                back.next = front.next;
            } else {
                back = front;
            }
            front = front.next;
        }
    }
}

