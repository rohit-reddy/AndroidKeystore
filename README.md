# AndroidKeystore

At some point in time, we all wanted to keep our data secure from being hacked/reverse engineered. The basic security mechanisms like,
a. ProGuard, ShrinkResources & minifyEnabled
b. Hiding in Manifest
c. Hiding in Build.Gradle
d. Storing in MySQL DB/Room DB/SharedPreference
e. Hiding in Strings.xml.

All these methods fail to provide maximum security. The most common and known logic of securing the key can be bypassed either by reversing and taking it from dex->jar file or by rooting the device and accessing the device storage.
But, there is one more method that beats them all. The mechanism which is generally used by applications for storing very sensitive data like Credit Card details, Bank Account and such.

Keystore is bound to hardware security which is generally used to store cryptographic keys. It becomes incredibly difficult for hackers to get access to it since a Keystore is very specific to every application. 
