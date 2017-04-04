import static org.junit.Assert.*;

/**
 * Dustin Naylor
 * 3/29/2017
 * CS-115 Section 1
 * assignment12
 */
public class BTreeTest {
    @org.junit.Test
    public void isEmpty() throws Exception {
        BTree tree1 = new BTree();

        assertTrue(tree1.IsEmpty() );
        tree1.Insert(1, 1);
        assertFalse(tree1.IsEmpty() );

    }

    @org.junit.Test
    public void gRoot() throws Exception {
        BTree tree1 = new BTree();
        assertNull(tree1.gRoot());

        tree1.Insert(1,1);
        assertNotNull(tree1.gRoot());
    }

    @org.junit.Test
    public void count() throws Exception{
        BTree tree = new BTree();
        assertEquals(0, tree.Count());
        tree.Insert(1,1);
        assertEquals(1, tree.Count());
    }
    @org.junit.Test
    public void size() throws Exception {

        BTree tree = new BTree();
        BinaryNode node = new BinaryNode(1,1);
        assertEquals(1, tree.Size(node) );
        BinaryNode node1 = new BinaryNode(2,2);
        node.sLeft(node1);
        assertEquals(2, tree.Size(node));
    }

    @org.junit.Test
    public void height() throws Exception {

        BTree tree = new BTree();
        BinaryNode node = new BinaryNode(1,1);
        assertEquals(1, tree.Height(node) );
        BinaryNode node1 = new BinaryNode(2,2);
        node.sLeft(node1);
        assertEquals(2, tree.Height(node));
        BinaryNode node2 = new BinaryNode(3,3);
        node.sRight(node2);
        assertEquals(2, tree.Height(node));
        BinaryNode node3 = new BinaryNode(4,4);
        node1.sLeft(node3);
        assertEquals(3, tree.Height(node));

    }

    @org.junit.Test
    public void preOrder() throws Exception {

        BTree tree = new BTree();
        tree.Insert(1,1);
        assertEquals("1", tree.PreOrder(tree.Find(1)));
        tree.Insert(2,2);
        tree.Insert(3,3);
    }

    @org.junit.Test
    public void inOrder() throws Exception {

    }

    @org.junit.Test
    public void postOrder() throws Exception {

    }

    @org.junit.Test
    public void insert() throws Exception {

    }

    @org.junit.Test
    public void find() throws Exception {

    }

    @org.junit.Test
    public void getSuccessor() throws Exception {

    }

    @org.junit.Test
    public void delete() throws Exception {

    }

}