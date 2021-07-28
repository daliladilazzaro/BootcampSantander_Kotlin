package com.example.fotosbootcamp

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pick_button.setOnClickListener{
            // se é melhor que a versão do android escolhida
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                //usuario permitir e ele vai pro onRequestePermission pra permitir e entrar na galeria
                if (checkSelfPermission
                  (Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
                    val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permission, PERMISSION_CODE)
                }else{
                    pickButtonFromGalery()
                }
            }else{
                pickButtonFromGalery()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickButtonFromGalery()
                }else{
                    //aqui é se ele nao permitir usar a galeria
                    Toast.makeText(this, "Permissão Negada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun pickButtonFromGalery() {
        //separa a activity que ta trabalhando
        val intent = Intent(Intent.ACTION_PICK)
        intent.type="image/*"//tudo que for imagem pode pegar
        startActivityForResult(intent, IMAGE_PICK_CODE)//precisa do recultado
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK && resultCode== IMAGE_PICK_CODE){
            image_view.setImageURI(data?.data)
        }
    }

    companion object{
        private val PERMISSION_CODE = 1000
        private val IMAGE_PICK_CODE = 1001
    }
}