/**
 * Dustin Naylor
 * 3/29/2017
 * CS-115 Section 1
 * assignment12
 */
class  BinaryNode
{
    private int Key;
    private int Data;
    private BinaryNode Left;
    private BinaryNode Right;

    public BinaryNode(int Key, int Data)
    { // constructor
        Key = this.Key;
        Data = this.Data;
        Left = null;
        Right = null;
    }
    // Get Operations
    public int gKey()
    {
        return Key;
    }

    public Object gData()
    {
        return Data;
    }

    public BinaryNode gLeft()
    {
        return Left;
    }
    public BinaryNode gRight()
    {
        return Right;
    }
    //Set Operations
    public void sKey(int AValue)
    {
        Key = AValue;
    }

    public void sData(int AValue)
    {
        Data = AValue;
    }

    public void sLeft( BinaryNode AValue)
    {
        Left = AValue;
    }

    public void sRight( BinaryNode AValue)
    {
        Right = AValue;
    }
} //End of node class code
