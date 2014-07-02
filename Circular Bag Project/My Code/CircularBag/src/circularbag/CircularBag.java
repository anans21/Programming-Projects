package circularbag;

/**
 *
 * @author Sameer Anand
 * 
 */

public class CircularBag<T> implements BagInterface<T> {

    private int count;
    
    private Node head;
    
    private Node tail;

    private class Node {

        private T data;     // Entry in bag
    
        private Node next;  // Link to next node
        
        private Node previous;

        private Node(T dataPortion) {
            
            this(dataPortion, null, null);
        
        }

        private Node(T dataPortion, Node nextNode, Node previousNode) {
         
            data = dataPortion;
            
            next = nextNode;
            
            previous = previousNode;
        
        }

        private T getData() {
           
            return data;
        
        }

        private void setData(T newData) {
          
            data = newData;
        
        }

        private Node getNextNode() {
         
            return next;
        
        }

        private void setNextNode(Node nextNode) {
         
            next = nextNode;
        
        }

        private Node getPreviousNode() {
         
            return previous;
        
        }

        private void setPreviousNode(Node previousNode) {
        
            previous = previousNode;
        
        }
    
    }

    @Override
    public int getCurrentSize() {
    
        return count;
    
    }

    @Override
    public boolean isFull() {
    
        if (count == 100) {
        
            return true;
        
        } else {
        
            return false;
        
        }
    
    }

    @Override
    public boolean isEmpty() {
    
        if (count == 0) {
        
            return true;
        
        } else {
        
            return false;
        
        }
    
    }

    @Override
    public boolean add(T newEntry) {

        //        if(isFull()) {

        //         return false;   

        //        } else {


        //        }
        
        if (isEmpty()) {
            
            head = new Node(newEntry);
            
            head.next = head;
            
            head.previous = head;

            tail = head;

        } else {
            
            // System.out.println("Entry: " + newEntry);
            
            Node node = new Node(newEntry);
            
            tail.next = node;
            
            node.previous = tail;
            
            head.previous = node;
            
            node.next = head;

            tail = node;
        
        }
        
        count++;
        
        return true;
    
    }

    @Override
    public T remove() {
    
        if (isEmpty()) {
        
            return null;
        
        } else {
        
            Node node = tail;

            tail = tail.previous;
            
            tail.next = head;

            count--;

            return node.getData();
        
        }
    
    }

    @Override
    public boolean remove(T anEntry) {
    
        if (isEmpty()) {
        
            return false;
        
        } else {
        
            Node node = head;
            
            do {
            
                if (node.getData().equals(anEntry)) {
                
                    node.previous.next = node.next;
                    
                    node.next.previous = node.previous;
                    
                    if (node.equals(head)) {
                        
                        // System.out.println("Head: "+anEntry);
                        
                        head = head.next;
                    
                    }
                    
                    count--;
                    
                    return true;
                
                }
                
                node = node.next;
            
            } while (!node.equals(tail));

            if (node.getData().equals(anEntry)) {
            
                node.previous.next = node.next;
                
                node.next.previous = node.previous;
                
                if (node.equals(tail)) {

                    // System.out.println("Head: "+anEntry);
                    
                    tail = tail.previous;
                
                }
                
                count--;
                
                return true;
            
            }
            
            return false;
        
        }
    
    }

    @Override
    public void clear() {
        
        head = null;
        
        tail = null;
        
        count = 0;
    
    }

    @Override
    public int getFrequencyOf(T anEntry) {
    
        if (isEmpty()) {
        
            return 0;
        
        } else {
        
            int f = 0;
            
            Node node = head;
            
            do {
            
                if (node.getData().equals(anEntry)) {
                
                    f++;
                
                }
                
                node = node.next;
            
            } while (!node.equals(tail));
            
            return f;
        
        }
    
    }

    @Override
    public boolean contains(T anEntry) {
    
        if (isEmpty()) {
        
            return false;
        
        } else {
        
            Node node = head;
            
            do {
            
                if (node.getData().equals(anEntry)) {
                
                    return true;
                
                }
                
                node = node.next;
            
            } while (!node.equals(tail));
            
            return false;
        
        }
    
    }

    @Override
    public T[] toArray() {
       
        T[] t = (T[]) new Object[count];
        
        if (isEmpty()) {
        
            return t;
        
        } else {

            Node node = head;

            for (int i = 0; i < count; i++) {
                
                // System.out.println("Node: "+node.getData());
                
                t[i] = node.getData();
                
                node = node.next;
            
            }
            
            return t;
        
        }
    
    }

}