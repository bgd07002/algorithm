package DataStructures.PrimitiveTypes;

public class BitVector {
    int[] bitVector;

    public BitVector(int size) {
        bitVector = new int[(size >> 5) + 1]; //Divide by 32
    }

    public boolean getBit(int pos) {
        int wordNumber = (pos >> 5);  //Divide by 32
        int bitNumber = (pos & 0x1F); //Mod 32
        return (bitVector[wordNumber] & (1 << bitNumber)) != 0;
    }

    public void set(int pos) {
        int wordNumber = (pos >> 5); //Divide by 32
        int bitNumber = (pos & 0x1F); //Mod 32
        bitVector[wordNumber] |= 1 << bitNumber;
    }
}
