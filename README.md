# AESLock

An experimental AES-256 bit file encryption system built in Java.

Learn more about AES-256 bit encryption [here](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard).

## Getting Started

You can view the live demo on my website [here](https://jtrpan.azurewebsites.net), or download the source code and modify it for your machine.

### What is AES-256?

AES is a symmetric key cipher. This means the same secret key is used for both encryption and decryption, and both the sender and receiver of the data need a copy of the key. By contrast, asymmetric key systems use a different key for each of the two processes. Asymmetric keys are best for external file transfers, whereas symmetric keys are better suited to internal encryption. The advantage of symmetric systems like AES is their speed. Because a symmetric key algorithm requires less computational power than an asymmetric one, it’s faster and more efficient to run. 

AES is also characterized as a block cipher. In this type of cipher, the information to be encrypted (known as plaintext) is divided into sections called blocks. AES uses a 128-bit block size, in which data is divided into a four-by-four array containing 16 bytes. Since there are eight bits per byte, the total in each block is 128 bits. The size of the encrypted data remains the same: 128 bits of plaintext yields 128 bits of ciphertext. 

### How does it work?

The basic principle of all encryption is that each unit of data is replaced by a different one according to the security key. More specifically, AES was designed as a substitution-permutation network. AES brings additional security because it uses a key expansion process in which the initial key is used to come up with a series of new keys called round keys. These round keys are generated over multiple rounds of modification, each of which makes it harder to break the encryption. 

First, the initial key is added to the block using an XOR (“exclusive or”) cipher, which is an operation built into processor hardware. Then each byte of data is substituted with another, following a predetermined table. Next, the rows of the 4x4 array are shifted: bytes in the second row are moved one space to the left, bytes in the third row are moved two spaces, and bytes in the fourth are moved three. The columns are then mixed—a mathematical operation combines the four bytes in each column. Finally, the round key is added to the block (much like the initial key was), and the process is repeated for each round. This yields ciphertext that is radically different from the plaintext. For AES decryption, the same process is carried out in reverse. 

Each stage of the AES encryption algorithm serves an important function. Using a different key for each round provides a much more complex result. Byte substitution modifies the data in a nonlinear manner, obscuring the relationship between the original and encrypted content. Shifting the rows and mixing the columns diffuses the data, transposing bytes to further complicate the encryption. Shifting diffuses the data horizontally, while mixing does so vertically. The result is a tremendously sophisticated form of encryption. 

### How secure is it?

The National Institute of Standards and Technology selected three “flavors” of AES: 128-bit, 192-bit, and 256-bit. Each type uses 128-bit blocks. The difference lies in the length of the key. As the longest, the 256-bit key provides the strongest level of encryption. With a 256-bit key, a hacker would need to try 2256 different combinations to ensure the right one is included. This number is astronomically large, landing at 78 digits total. It is exponentially greater than the number of atoms in the observable universe. Understandably, the US government requires 128- or 256-bit encryption for sensitive data. 

The three AES varieties are also distinguished by the number of rounds of encryption. AES 128 uses 10 rounds, AES 192 uses 12 rounds, and AES 256 uses 14 rounds. The more rounds, the more complex the encryption, making AES 256 the most secure AES implementation. It should be noted that with a longer key and more rounds comes higher performance requirements. AES 256 uses 40% more system resources than AES 192, and is therefore best suited to high sensitivity environments where security is more important than speed. 

AES 256 is virtually impenetrable using brute-force methods. While a 56-bit DES key can be cracked in less than a day, AES would take billions of years to break using current computing technology. Hackers would be foolish to even attempt this type of attack. 

Nevertheless, no encryption system is entirely secure. Researchers who have probed AES have found a few potential ways in. In 2009, they discovered a possible related-key attack. This type of cryptanalysis attempts to crack a cipher by observing how it operates using different keys. Fortunately, the related-key attack is only a threat to AES systems that are incorrectly configured. 

That same year, there was a known-key distinguishing attack against AES 128. The attack used a known-key to discern the structure of the encryption. However, the hack only targeted an eight-round version of AES 128—not the standard 10-round version—so it would not be a major threat.

Since the AES cipher itself is so secure, the main risk comes from side-channel attacks. These don’t attempt a brute-force assault, but rather try to pick up information the system is leaking. Hackers can listen in to sounds, electromagnetic signals, timing information, or power consumption to try to discover how the security algorithms work. Side-channel attacks can be prevented by removing information leaks or masking the leaked data (by generating extra electromagnetic signals or sounds) so it doesn’t yield any useful information. A careful implementation of AES will guard against these side-channel risks. 

Of course, even the strongest cryptographic systems are vulnerable if a hacker gains access to the key itself. That’s why utilizing strong passwords, multifactor authentication, firewalls, and antivirus software is critical to the larger security picture. It’s also essential to educate employees against social engineering and phishing attacks. Properly trained users are the first line of defense. 

Besides its advanced technology, the open nature of AES 256 makes it one of the most secure encryption protocols. Researchers are constantly studying AES to uncover any potential vulnerabilities. Whenever one is discovered, users can take action to address the issue. 

## Prerequisites

```
Java SE 8 or higher
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

Copyright © 1993, 2020, Oracle and/or its affiliates.
