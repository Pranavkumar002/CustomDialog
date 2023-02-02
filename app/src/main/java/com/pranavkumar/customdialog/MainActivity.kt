package com.pranavkumar.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.pranavkumar.customdialog.databinding.ActivityMainBinding
import com.pranavkumar.customdialog.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)


        binding.btnUpdate.setOnClickListener {
            var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.etName.setText(binding.etName.text.toString())
            dialogBinding.etAddress.setText(binding.etAddress.text.toString())
            if (binding.etGender.text.toString().equals("Male")) {
                dialogBinding.rbMale.isChecked = true
            } else if (binding.etGender.text.toString().equals("Female")) {
                dialogBinding.rbFemale.isChecked = true
            } else if (binding.etGender.text.toString().equals("Transgender")) {
                dialogBinding.rbTransgender.isChecked = true
            } else {
            }

        dialogBinding.btnUpdatein.setOnClickListener{

            if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                Toast.makeText(this,getString(R.string.enter_name),Toast.LENGTH_SHORT).show()
            }
            else if(dialogBinding.etAddress.text.toString().isNullOrEmpty()){
                Toast.makeText(this,getString(R.string.enter_address),Toast.LENGTH_SHORT).show()
            }
            else{
                binding.etName.setText(dialogBinding.etName.text.toString())
                binding.etAddress.setText(dialogBinding.etAddress.text.toString())
                if(dialogBinding.rbMale.isChecked){
                    binding.etGender.setText("Male")
                }
                else if(dialogBinding.rbFemale.isChecked){
                    binding.etGender.setText("Female")
                }
                else {
                    binding.etGender.setText("Transgender")
                }
                dialog.dismiss()
            }


        }
        dialog.show()
    }
        }
    }