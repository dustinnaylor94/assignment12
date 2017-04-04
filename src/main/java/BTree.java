/**
 * Dustin Naylor
 * 3/29/2017
 * CS-115 Section 1
 * assignment12
 */
public class BTree {
    private BinaryNode Root;
    private int NoOfNodes;

    public BTree() {                                      // constructor
        Root = null;
        NoOfNodes = 0;
    }

    public boolean IsEmpty() {
        return (NoOfNodes == 0);
    }

    public BinaryNode gRoot() {
        return Root;
    }
    public int Count()
    {
        return NoOfNodes;
    }

    public int Size(BinaryNode ATree) {
        if (ATree == null)
            return 0;
        else
            return (1 + Size(ATree.gLeft()) + Size(ATree.gRight()));
    }

    public int Height(BinaryNode ATree) {
        if (ATree == null)
            return 0;
        else
            return (1 + Math.max(Height(ATree.gLeft()), Height(ATree.gRight())));
    }

    public void PreOrder(BinaryNode ATree) {
        String result = "";
        if (ATree != null) {
            result = result + ATree.gData().toString();
            PreOrder(ATree.gLeft());
            PreOrder(ATree.gRight());
        }
    }

    public void InOrder(BinaryNode ATree) {
        if (ATree != null) {
            InOrder(ATree.gLeft());
            System.out.println(ATree.gData());
            InOrder(ATree.gRight());
        }
    }

    public void PostOrder(BinaryNode ATree) {
        if (ATree != null) {
            PostOrder(ATree.gLeft());
            PostOrder(ATree.gRight());
            System.out.println(ATree.gData());
        }
    }

    public void Insert(int AId, int AValue) {
        BinaryNode Temp, Current, Parent;
        if (Root == null)//tree is empty
        {
            Temp = new BinaryNode(AId, AValue);
            Root = Temp;
            NoOfNodes++;
        } else//tree is not empty
        {
            Temp = new BinaryNode(AId, AValue);
            Current = Root;
            while (true)//never ending while loop
            {
                Parent = Current;
                if (AId < Current.gKey()) {//go left
                    Current = Current.gLeft();
                    if (Current == null) {
                        Parent.sLeft(Temp);
                        NoOfNodes++;
                        return;//jump out of loop
                    }
                } else { //go right
                    Current = Current.gRight();
                    if (Current == null) {
                        Parent.sRight(Temp);
                        NoOfNodes++;
                        return;
                    }
                }
            }
        }
    }

    public BinaryNode Find(int AKey)
    {
        BinaryNode Current = null;
        if(!IsEmpty())
        {
            Current = Root; //start search at top of tree
            while(Current.gKey() != AKey)
            {
                if(AKey < Current.gKey())
                    Current = Current.gLeft();
                else
                    Current = Current.gRight();
                if(Current == null)
                    return null;
            }
        }
        return Current;
    }

    public BinaryNode GetSuccessor(BinaryNode ANode)
    {
        BinaryNode Current,Successor,SuccessorParent;
        Successor = ANode;
        SuccessorParent = ANode;
        Current = ANode.gRight();
        while(Current !=null)
        {
            SuccessorParent = Successor;
            Successor = Current;
            Current = Current.gLeft();
        }
        if(Successor != ANode.gRight())
        {
            SuccessorParent.sLeft(Successor.gRight());
            Successor.sRight(ANode.gRight());
        }
        return Successor;
    }

    public boolean Delete (int AKey)
    {
        BinaryNode Current, Parent;
        boolean IsLeftChild = true;
        Current = Root;
        Parent = Root;
        while (Current.gKey() != AKey)
        {
            Parent = Current;
            if (AKey < Current.gKey())
            {
                IsLeftChild = true;
                Current = Current.gLeft();
            }
            else
            {
                IsLeftChild = false;
                Current = Current.gRight();
            }
            if(Current == null)
                return false;
        }
        // if no children delete the node
        if (Current.gLeft() == null && Current.gRight() == null)
        {
            if (Current == Root)
                Root = Current.gLeft();
            else
            if (IsLeftChild)
                Parent.sLeft(Current.gRight());
            else
                Parent.sRight(Current.gRight());
        }
        // if no right child replace with left subtree
        else
        {
            if (Current.gRight() == null)
            {
                if (Current == Root)
                    Root = Current.gRight();
                else
                if (IsLeftChild)
                    Parent.sLeft(Current.gLeft());
                else
                    Parent.sRight(Current.gLeft());
            }
            // if no left child replace with right subtree
            else
            {
                if (Current.gLeft() == null)
                {
                    if (Current == Root)
                        Root = Current.gLeft();
                    else
                    if (IsLeftChild)
                        Parent.sLeft(Current.gRight());
                    else
                        Parent.sRight(Current.gRight());
                }
                // two children so replace in order of successor
                else
                {
                    BinaryNode Successor = GetSuccessor(Current);
                    if (Current == Root)
                        Root = Successor;
                    else
                    if (IsLeftChild)
                        Parent.sLeft(Successor);
                    else
                        Parent.sRight(Successor);
                    Successor.sLeft(Current.gLeft());
                }
            }
        }
        NoOfNodes--;
        return true;
    }
}
