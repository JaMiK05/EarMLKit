package uz.gita.earmlkit.presentation.screen.scanbarcodefragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import uz.gita.earmlkit.databinding.DialogScanBarcodeBinding

/**
 *   Created by Jamik on 7/20/2023 ot 8:33 AM
 **/
class ScanBarCodeDialog constructor(context: Context, private val url: String) : Dialog(context) {

    private var listener: (() -> Unit)? = null

    private var cancelListener: (() -> Unit)? = null
    fun setListener(block: () -> Unit) {
        listener = block
    }


    fun setCancelListener(block: () -> Unit) {
        cancelListener = block
    }

    private lateinit var binding: DialogScanBarcodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogScanBarcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.apply {
            urltxt.text = url
            btnCancel.setOnClickListener {
                dismiss()
            }
            btnEdit.setOnClickListener {
                listener?.invoke()
            }
        }
    }

    override fun dismiss() {
        cancelListener?.invoke()
        super.dismiss()
    }

}