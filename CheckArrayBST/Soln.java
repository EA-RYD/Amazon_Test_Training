package CheckArrayBST;
import java.util.*;

public class Soln {
    public static void main(String[] args) {
        
    }

    /*
     * The idea is to use a queue data structure. 
     * Every element of queue has a structure say NodeDetails 
     * which stores details of a tree node. The details are node’s data, 
     * and two variables min and max where min stores the lower limit for the 
     * node values which can be a part of the left subtree and max stores the upper 
     * limit for the node values which can be a part of the right subtree for the specified 
     * node in NodeDetails structure variable. For the 1st array value arr[0], create a 
     * NodeDetails structure having arr[0] as node’s data and min = INT_MIN and max = INT_MAX. 
     * Add this structure variable to the queue. This Node will be the root of the tree. 
     * Move to 2nd element in arr[] and then perform the following steps:
     * 
     * 
     *  Pop NodeDetails from the queue in temp.
     * 
        Check whether the current array element can be a left child of 
        the node in temp with the help of min and temp.data values. 
        If it can, then create a new NodeDetails structure for this new 
        array element value with its proper ‘min’ and ‘max’ values and 
        push it to the queue, and move to next element in arr[].

        Check whether the current array element can be a right child of the 
        node in temp with the help of max and temp.data values. If it can, 
        then create a new NodeDetails structure for this new array element
        value with its proper ‘min’ and ‘max’ values and push it to the queue,
         and move to next element in arr[].

        Repeat steps 1, 2 and 3 until there are no more elements in arr[] or there are no more elements in the queue.
     */

    static class NodeDetails
{
    int data;
    int min, max;
};
 
// function to check if the given array
// can represent Level Order Traversal
// of Binary Search Tree
static boolean levelOrderIsOfBST(int arr[], int n)
{
    // if tree is empty
    if (n == 0)
        return true;
     
    // queue to store NodeDetails
    Queue<NodeDetails> q = new LinkedList<NodeDetails>();
     
    // index variable to access array elements
    int i = 0;
     
    // node details for the
    // root of the BST
    NodeDetails newNode=new NodeDetails();
    newNode.data = arr[i++];
    newNode.min = Integer.MIN_VALUE;
    newNode.max = Integer.MAX_VALUE;
    q.add(newNode);
     
    // until there are no more elements
    // in arr[] or queue is not empty
    while (i != n && q.size() > 0)    
    {
        // extracting NodeDetails of a
        // node from the queue
        NodeDetails temp = q.peek();
        q.remove();
        newNode = new NodeDetails();
         
        // check whether there are more elements
        // in the arr[] and arr[i] can be left child
        // of 'temp.data' or not
        if (i < n && (arr[i] < (int)temp.data &&
                    arr[i] > (int)temp.min))
        {
            // Create NodeDetails for newNode
            /// and add it to the queue
            newNode.data = arr[i++];
            newNode.min = temp.min;
            newNode.max = temp.data;
            q.add(newNode);            
        }
         
        newNode=new NodeDetails();
         
        // check whether there are more elements
        // in the arr[] and arr[i] can be right child
        // of 'temp.data' or not
        if (i < n && (arr[i] > (int)temp.data &&
                    arr[i] < (int)temp.max))
        {
            // Create NodeDetails for newNode
            /// and add it to the queue
            newNode.data = arr[i++];
            newNode.min = temp.data;
            newNode.max = temp.max;
            q.add(newNode);        
        }    
    }
     
    // given array represents level
    // order traversal of BST
    if (i == n)
        return true;
         
    // given array do not represent
    // level order traversal of BST
    return false;    
}
}
