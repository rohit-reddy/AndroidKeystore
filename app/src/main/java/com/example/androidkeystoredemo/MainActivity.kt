package com.example.androidkeystoredemo

import android.os.Bundle
import android.text.Editable
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import javax.crypto.BadPaddingException
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException


class MainActivity : AppCompatActivity() {

    var edTextToEncrypt: EditText? = null

    var tvEncryptedText: TextView? = null

    var tvDecryptedText: TextView? = null
    private var encryptor: EnCryptor? = null
    private var decryptor: DeCryptor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edTextToEncrypt = findViewById(R.id.edTextToEncrypt)
        tvEncryptedText = findViewById(R.id.tvEncryptedText)
        tvDecryptedText = findViewById(R.id.tvDecryptedText)

        edTextToEncrypt?.setText(SECRET)
        encryptor = EnCryptor()
        try {
            decryptor = DeCryptor()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun onClick(view: View) {
        val id: Int = view.getId()
        when (id) {
            R.id.btn_encrypt -> encryptText()
            R.id.btn_decrypt -> decryptText()
        }
    }

    private fun decryptText() {
        try {
            tvDecryptedText!!.text = decryptor!!
                .decryptData(SAMPLE_ALIAS, encryptor!!.encryption, encryptor!!.iv)
        } catch (e: UnrecoverableEntryException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: KeyStoreException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: NoSuchPaddingException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: NoSuchProviderException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: IOException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: InvalidKeyException) {
            Log.e(TAG, "decryptData() called with: " + e.message, e)
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        }
    }

    private fun encryptText() {
        try {
            val encryptedText = encryptor!!
                .encryptText(SAMPLE_ALIAS, edTextToEncrypt!!.text.toString())
            tvEncryptedText?.text = Base64.encodeToString(encryptedText, Base64.DEFAULT)
        } catch (e: UnrecoverableEntryException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: NoSuchProviderException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: KeyStoreException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: IOException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: NoSuchPaddingException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: InvalidKeyException) {
            Log.e(TAG, "onClick() called with: " + e.message, e)
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: SignatureException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val SAMPLE_ALIAS = "MYALIAS"
        private const val SECRET = "3d6decbf8145c585d34684a7a587c670"
    }
}