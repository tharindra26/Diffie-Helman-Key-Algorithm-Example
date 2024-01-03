import java.math.BigInteger;

public class DH {
    private static final BigInteger selectedPrime = new BigInteger("65699");
    private static final BigInteger primitiveRoot = new BigInteger("3");

    public static void main(String[] args) {
        if (args.length == 1) {
            // Generate and print public key
            BigInteger privateKey = new BigInteger(args[0]);
            BigInteger publicKey = calculatePublicKey(privateKey);
            System.out.println("Public Key: " + publicKey);
        } else if (args.length == 2) {
            // Generate shared session key
            BigInteger privateKeyA = new BigInteger(args[0]);
            BigInteger publicKeyB = new BigInteger(args[1]);

            BigInteger sharedSecretA = calculateSharedSecret(privateKeyA, publicKeyB);
            System.out.println("Session Key: " + sharedSecretA);
        } else {
            System.out.println("Invalid number of arguments. Usage:");
            System.out.println("To generate public key: java DH private_key");
            System.out.println("To generate session key: java DH private_key public_key");
        }
    }

    private static BigInteger calculatePublicKey(BigInteger privateKey) {
        // base.modPow(exponent, modulus)
        return primitiveRoot.modPow(privateKey, selectedPrime);
    }

    private static BigInteger calculateSharedSecret(BigInteger privateKey, BigInteger publicKey) {
        return publicKey.modPow(privateKey, selectedPrime);
    }
}
