package vop;

public class CaesarCipher extends AbstractCipher {
    int rotFactor;

    public CaesarCipher (int rotFactor) {
        if (rotFactor < 0 ) {
            this.rotFactor = 0;
        } else if (rotFactor >= ALPHABETH.length) {
            this.rotFactor = ALPHABETH.length - 1;
        } else {
            this.rotFactor = rotFactor;
        }
    }
    @Override
    public String encrypt(String original) {
        char[] messageArray = original.toCharArray();
        for (int i = 0 ; i < messageArray.length ; i++) {
            int charIndex = findCharIndex(messageArray[i]);
            if (charIndex != -1) {
                messageArray[i] = ALPHABETH[(charIndex + rotFactor) % ALPHABETH.length];
            }
        }
        return new String(messageArray);
    }

    @Override
    public String decrypt(String encrypted) {
        char[] messageArray = encrypted.toCharArray();
        for (int i = 0 ; i < messageArray.length ; i++) {
            int charIndex = findCharIndex(messageArray[i]);
            if (charIndex != -1) {
                messageArray[i] = ALPHABETH[((charIndex + ALPHABETH.length) - rotFactor) % ALPHABETH.length];
            }

        }
        return new String(messageArray);
    }
}
