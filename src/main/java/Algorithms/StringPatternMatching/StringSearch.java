package Algorithms.StringPatternMatching;


public class StringSearch {

    public int bruteForceSearch(String text, String substring) {
        char[] textArr = text.toCharArray();
        char[] substringArr = substring.toCharArray();

        int idxSubstring =0;
        for (int i =0; i< textArr.length; i++) {
            if (textArr[i] == substringArr[idxSubstring]) {
                if (idxSubstring == substring.length() -1)
                    return i-idxSubstring;

                idxSubstring++;
            } else if (idxSubstring > 0) {
                i = i-idxSubstring+1;
                idxSubstring =0;
            }
        }
        return -1;
    }

    public int knuthMorrisPrattSearch(String text, String substring) {
        if (substring.length() > text.length())
            return -1;

        char[] textArr = text.toCharArray();
        char[] substringArr = substring.toCharArray();

        int idxSubstring =0;
        int holdingFirstCharacter = 0;
        for (int i=0; i < textArr.length; i++) {
            if (textArr[i] == substringArr[idxSubstring]) {
                if (idxSubstring == substring.length() -1)
                    return i-idxSubstring;

                if (idxSubstring > 0 && textArr[i] == substringArr[idxSubstring]) {
                    holdingFirstCharacter = i;
                }
                idxSubstring++;
            } else if (idxSubstring > 0) {
                if (holdingFirstCharacter > 0)
                    i = holdingFirstCharacter-1;

                idxSubstring =0;
                holdingFirstCharacter = 0;
                i = i-1;
            }
        }
        return -1;
    }

    /**
     * Probably bug on integer overflows
     */
    public int rabinKarpSearch(String text, String substring) {
        if (substring.length() > text.length())
            return -1;

        final int mod = 997;
        final int power = 128;
        char[] textArr = text.toCharArray();
        char[] substringArr = substring.toCharArray();

        //Taking care of Horner's method first
        int hashText = computeHash(substringArr, mod, power, 0, substringArr.length-1);
        int hash = computeHash(textArr, mod, power, 0, substringArr.length-1);

        //Rolling calculations
        int temp = (int) Math.pow(power, substringArr.length-1)%mod;
        temp = mod-temp;
        for (int i= substringArr.length; i< textArr.length; i++) {
            int temp1 = (int)textArr[i];
            int temp2 = (int)textArr[i-substringArr.length];
            hash = ((hash + temp2*temp)*power+temp1)%mod;
            if (hash == hashText)
                return i;
        }

        return -1;
    }

    private int computeHash(char[] textArr, int mod, int power, int idxStart, int idxEnd) {
        int hash = 0;
        for (int i=idxStart; i <= idxEnd; i++) {
            hash = (hash*power + (int)textArr[i]-48)% mod;
        }
        return hash;
    }
}
