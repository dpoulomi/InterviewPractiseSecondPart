// Java program to print the
// left view of Binary Tree
import java.util.*;

class LeftView
{
    static class node
    {
        int data;
        node left, right;
    };

    static node newNode(int item)
    {
        node temp = new node();
        temp.data = item;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    static Queue<node> q;

    static void leftViewUtil( node root )
    {
        if (root == null)
            return;

        q.add(root);

        q.add(null);

        while (q.size() > 0)
        {
            node temp = q.peek();

            if (temp != null)
            {

                System.out.print(temp.data + " ");

                while (temp != null)
                {

                    if (temp.left != null)
                        q.add(temp.left);

                    if (temp.right != null)
                        q.add(temp.right);

                    q.remove();

                    temp = q.peek();
                }

                q.add(null);
            }


            q.remove();
        }
    }


    static void leftView( node root)
    {

       // q = new LinkedList<node>();

        leftViewUtil(root);
    }

    // Driver Code
    public static void main(String args[])
    {
        node root = newNode(10);
        root.left = newNode(12);
        root.right = newNode(3);
        root.left.right = newNode(4);
        root.right.left = newNode(5);
        root.right.left.right = newNode(6);
        root.right.left.right.left = newNode(18);
        root.right.left.right.right = newNode(7);

        leftView(root);
    }
}

// This code is contributed by Arnab Kundu
