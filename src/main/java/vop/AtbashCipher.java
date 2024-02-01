package vop;

public class AtbashCipher extends AbstractCipher {
    @Override
    public String encrypt(String original) {
        char[] messageArray = original.toCharArray();
        for (int i = 0 ; i < messageArray.length ; i++) {
            int charIndex = findCharIndex(messageArray[i]);
            if (charIndex != -1) {
                messageArray[i] = ALPHABETH[ALPHABETH.length - (charIndex + 1)];
            }
        }
        return new String(messageArray);
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
