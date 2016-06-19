    private static byte[] encryptText(String plaintext) throws NoSuchAlgorithmException,
    NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
    InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, BadPaddingException
    {
    	byte[] iv = new byte[16];	// This is bad, especially when using streaming mode
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // cipher
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, KEY, ivSpec);

        // encryption
        byte[] message = plaintext.getBytes();
        byte[] ciphertext = new byte[cipher.getOutputSize(message.length)];
        int ctLength = cipher.update(message, 0, message.length, ciphertext, 0);
        cipher.doFinal(ciphertext, ctLength);

        return ciphertext;
    }
